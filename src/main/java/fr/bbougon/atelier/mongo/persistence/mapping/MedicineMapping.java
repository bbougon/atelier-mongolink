package fr.bbougon.atelier.mongo.persistence.mapping;

import fr.bbougon.atelier.mongo.domain.Medicine;
import org.mongolink.domain.mapper.AggregateMap;

@SuppressWarnings("Needed for MongoLink")
public class MedicineMapping extends AggregateMap<Medicine> {
    @Override
    public void map() {
        id().onProperty(Medicine::getId);
        property().onProperty(Medicine::getName);
    }
}
