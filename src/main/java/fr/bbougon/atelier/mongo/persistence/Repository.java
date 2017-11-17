package fr.bbougon.atelier.mongo.persistence;

import org.bson.Document;
import org.mongolink.MongoSession;
import org.mongolink.domain.criteria.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class Repository<T> {

    Repository(final MongoSession session) {
        this.session = null;
    }

    public void add(final T entity) {
        throw new NotImplementedException();
    }

    public T get(final Object id) {
        return null;
    }

    public void deleteAll() {
        throw new NotImplementedException();
    }

    private Class<T> persistenceType() {
        final ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) superclass.getActualTypeArguments()[0];
    }

    public T findByName(final String name) {
        return null;
    }

    public List<T> findByMedicineName(final String medicineName) {
        return null;
    }

    private final MongoSession session;
}
