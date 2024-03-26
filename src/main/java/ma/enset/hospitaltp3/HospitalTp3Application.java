package ma.enset.hospitaltp3;

import ma.enset.hospitaltp3.entities.Patient;
import ma.enset.hospitaltp3.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalTp3Application implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalTp3Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Patient patient = new Patient();
        patient.setId(null);
        patient.setNom("mohammed");
        patient.setDateNaissace(new Date());
        patient.setMalade(false);
        patient.setScore(55);

        Patient patient2 = new Patient(null, "hanan", new Date(), false, 100);
        //En utilisant Builder
        Patient patient3 = Patient.builder()
                .nom("ahlam")
                .dateNaissace(new Date())
                .score(99)
                .malade(true)
                .build();

        patientRepository.save(patient);
        patientRepository.save(patient2);
        patientRepository.save(patient3);

    }
}
