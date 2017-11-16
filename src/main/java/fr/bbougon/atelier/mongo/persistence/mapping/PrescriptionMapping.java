package fr.bbougon.atelier.mongo.persistence.mapping;

import fr.bbougon.atelier.mongo.domain.Prescription;
import org.mongolink.domain.mapper.AggregateMap;

@SuppressWarnings("Needed for mongolink")
public class PrescriptionMapping extends AggregateMap<Prescription> {

    @Override
    public void map() {
        id().onProperty(Prescription::getId).natural();
        property().onProperty(Prescription::getName);
    }
}
