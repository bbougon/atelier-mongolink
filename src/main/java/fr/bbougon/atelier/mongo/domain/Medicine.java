package fr.bbougon.atelier.mongo.domain;

import java.util.UUID;

public class Medicine {

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public static class MedicineFactory {
        public MedicineFactory(final String medicineName) {
            this.medicineName = medicineName;
        }

        public Medicine create() {
            Medicine medicine = new Medicine();
            medicine.name = medicineName;
            return medicine;
        }

        private final String medicineName;
    }

    private String name;
    private UUID id = UUID.randomUUID();
}
