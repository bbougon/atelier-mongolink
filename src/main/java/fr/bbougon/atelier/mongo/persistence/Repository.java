package fr.bbougon.atelier.mongo.persistence;

import org.mongolink.MongoSession;
import org.mongolink.domain.criteria.*;

import java.lang.reflect.ParameterizedType;

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

    Class<T> persistenceType() {
        final ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) superclass.getActualTypeArguments()[0];
    }

    final MongoSession session;
}
