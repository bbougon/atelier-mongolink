package fr.bbougon.atelier.mongo.domain;

public class Medicine {

    public String getName() {
        return name;
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
}
