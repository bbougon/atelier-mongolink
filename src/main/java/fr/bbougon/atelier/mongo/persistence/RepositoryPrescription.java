package fr.bbougon.atelier.mongo.persistence;

import fr.bbougon.atelier.mongo.domain.Prescription;
import org.mongolink.MongoSession;
import org.mongolink.domain.criteria.Criteria;
import org.mongolink.domain.criteria.Restrictions;

import java.util.List;

public class RepositoryPrescription extends Repository<Prescription> {

    RepositoryPrescription(final MongoSession session) {
        super(session);
    }

    public Prescription findByName(final String name) {
        Criteria criteria = session.createCriteria(persistenceType());
        criteria.add(Restrictions.equals("name", name));
        criteria.limit(1);
        return (Prescription) criteria.list().stream().findFirst().get();
    }

    public List<Prescription> findByMedicineName(final String medicineName) {
        Criteria criteria = session.createCriteria(persistenceType());
        criteria.add(Restrictions.equals("medicine.name", medicineName));
        return criteria.list();
    }
}
