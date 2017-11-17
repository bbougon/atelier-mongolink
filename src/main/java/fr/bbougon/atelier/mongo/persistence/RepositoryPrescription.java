package fr.bbougon.atelier.mongo.persistence;

import fr.bbougon.atelier.mongo.domain.Prescription;
import org.mongolink.MongoSession;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class RepositoryPrescription extends Repository<Prescription> {

    RepositoryPrescription(final MongoSession session) {
        super(session);
    }

    public Prescription findByName(final String name) {
        throw new NotImplementedException();
    }

    public List<Prescription> findByMedicineName(final String medicineName) {
        throw new NotImplementedException();
    }
}
