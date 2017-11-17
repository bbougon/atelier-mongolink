package fr.bbougon.atelier.mongo.persistence;

import org.bson.Document;
import org.mongolink.MongoSession;
import org.mongolink.domain.criteria.*;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class Repository<T> {

    Repository(final MongoSession session) {
        this.session = session;
    }

    public void add(final T entity) {
        session.save(entity);
    }

    public T get(final Object id) {
        return session.get(id, persistenceType());
    }

    public void deleteAll() {
        session.getAll(persistenceType()).forEach(session::delete);
    }

    private Class<T> persistenceType() {
        final ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) superclass.getActualTypeArguments()[0];
    }

    public T findByName(final String name) {
        Criteria criteria = session.createCriteria(persistenceType());
        criteria.add(Restrictions.equals("name", name));
        criteria.limit(1);
        return (T) criteria.list().stream().findFirst().get();
    }

    public List<T> findByMedicineName(final String medicineName) {
        Criteria criteria = session.createCriteria(persistenceType());
        criteria.add(Restrictions.equals("medicine.name", medicineName));
        return criteria.list();
    }

    private final MongoSession session;
}
