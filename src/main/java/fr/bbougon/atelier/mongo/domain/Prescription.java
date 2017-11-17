package fr.bbougon.atelier.mongo.domain;

import java.util.UUID;

public class Prescription {


    Prescription() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public static class PrescriptionFactory {
        public PrescriptionFactory(final String prescriptionName) {
            this.prescriptionName = prescriptionName;
        }

        public PrescriptionFactory(final String prescriptionName, final Medicine medicine) {
            this(prescriptionName);
            this.medicine = medicine;
        }

        public Prescription create() {
            Prescription prescription = new Prescription();
            prescription.name = prescriptionName;
            prescription.medicine = medicine;
            return prescription;
        }

        private final String prescriptionName;
        private Medicine medicine;
    }

    private String name;
    private UUID id = UUID.randomUUID();
    private Medicine medicine;
}
