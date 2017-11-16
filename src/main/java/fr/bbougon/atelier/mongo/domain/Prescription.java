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

    public static class PrescriptionFactory {
        public PrescriptionFactory(final String prescriptionName) {
            this.prescriptionName = prescriptionName;
        }

        public Prescription create() {
            Prescription prescription = new Prescription();
            prescription.name = prescriptionName;
            return prescription;
        }

        private final String prescriptionName;
    }

    private String name;
    private UUID id = UUID.randomUUID();
}
