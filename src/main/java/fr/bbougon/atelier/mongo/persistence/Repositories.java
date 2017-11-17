package fr.bbougon.atelier.mongo.persistence;

import org.mongolink.MongoSession;

public class Repositories {

    private Repositories(final MongoSession session) {
        prescription = new RepositoryPrescription(session);
    }

    public static RepositoryPrescription prescription() {
        return SingletonHolder.INSTANCE.getPrescription();
    }

    public static void initialise(final MongoSession session) {
        SingletonHolder.INSTANCE = new Repositories(session);
    }

    private RepositoryPrescription getPrescription() {
        return prescription;
    }

    static class SingletonHolder {
        static Repositories INSTANCE;
    }

    private RepositoryPrescription prescription;
}
