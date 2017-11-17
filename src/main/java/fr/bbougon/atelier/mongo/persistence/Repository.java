package fr.bbougon.atelier.mongo.persistence;

import org.mongolink.MongoSession;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.ParameterizedType;

public class Repository<T> {

    Repository(final MongoSession session) {
        this.session = session;
    }

    public void add(final T entity) {
        throw new NotImplementedException();
    }

    public T get(final Object id) {
        throw new NotImplementedException();
    }

    public void deleteAll() {
        throw new NotImplementedException();
    }

    Class<T> persistenceType() {
        final ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) superclass.getActualTypeArguments()[0];
    }

    final MongoSession session;
}
