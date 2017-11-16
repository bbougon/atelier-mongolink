package fr.bbougon.atelier.mongo.persistence;

import fr.bbougon.atelier.mongo.domain.Prescription;
import org.mongolink.*;

public class Repositories {

    private Repositories(final MongoSession session) {
        prescription = new RepositoryPrescription(session);
    }

    public static Repository<Prescription> prescription() {
        return SingletonHolder.INSTANCE.getPrescription();
    }

    public static void initialise(final MongoSession session) {
        SingletonHolder.INSTANCE = new Repositories(session);
    }

    private Repository<Prescription> getPrescription() {
        return prescription;
    }

    static class SingletonHolder {
        static Repositories INSTANCE;
    }

    private Repository<Prescription> prescription;
}
