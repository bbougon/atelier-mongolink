package fr.bbougon.atelier.mongo;

import com.mongodb.MongoClient;
import fr.bbougon.atelier.mongo.domain.Prescription;
import fr.bbougon.atelier.mongo.persistence.Repositories;
import org.junit.*;
import org.mongolink.*;
import org.mongolink.domain.mapper.ContextBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class MongoPrescriptionRepositoryTest {

    @Before
    public void before() {
        ContextBuilder builder = new ContextBuilder("fr.bbougon.atelier.mongo.persistence.mapping");
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        Settings settings = Settings.defaultInstance()
                .withDefaultUpdateStrategy(UpdateStrategies.DIFF)
                .withDatabase(mongoClient.getDatabase("ateliermongolink"));
        session = MongoSessionManager.create(builder, settings).createSession();
        Repositories.initialise(session);
        session.start();
    }

    @After
    public void after() {
        Repositories.prescription().deleteAll();
        session.stop();
    }

    @Test
    public void canAddPrescription() {
        Prescription prescription = new Prescription.PrescriptionFactory("prescription").create();
        Repositories.prescription().add(prescription);
        cleanSession();

        Prescription foundPrescription = Repositories.prescription().get(prescription.getId());

        assertThat(foundPrescription).isNotNull();
        assertThat(foundPrescription.getName()).isEqualTo("prescription");
    }

    @Test
    public void canFindByName() {
        Prescription prescription = new Prescription.PrescriptionFactory("find by name").create();
        Repositories.prescription().add(prescription);
        cleanSession();

        Prescription foundPrescription = Repositories.prescription().findByName(prescription.getName());

        assertThat(foundPrescription).isNotNull();
        assertThat(foundPrescription.getName()).isEqualTo("find by name");
    }

    private void cleanSession() {
        session.flush();
        session.clear();
    }

    private MongoSession session;
}
