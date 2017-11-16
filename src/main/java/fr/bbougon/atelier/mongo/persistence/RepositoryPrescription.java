package fr.bbougon.atelier.mongo.persistence;

import fr.bbougon.atelier.mongo.domain.Prescription;
import fr.bbougon.atelier.mongo.persistence.Repository;
import org.mongolink.MongoSession;

class RepositoryPrescription extends Repository<Prescription> {

    RepositoryPrescription(final MongoSession session) {
        super(session);
    }

}
