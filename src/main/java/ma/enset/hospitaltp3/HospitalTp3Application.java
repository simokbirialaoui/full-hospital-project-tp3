package ma.enset.hospitaltp3;

import ma.enset.hospitaltp3.entities.Patient;
import ma.enset.hospitaltp3.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalTp3Application  {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalTp3Application.class, args);
    }


  //@Bean
    CommandLineRunner commandLineRunner( PatientRepository patientRepository) {
        return args -> {

            Patient patient = new Patient();
            patient.setId(null);
            patient.setNom("mohammed");
            patient.setDateNaissance(new Date());
            patient.setMalade(false);
            patient.setScore(333);

            Patient patient2 = new Patient(null, "hanan", new Date(), false, 120);
            //En utilisant Builder
            Patient patient3 = Patient.builder()
                    .nom("ahlam")
                    .dateNaissance(new Date())
                    .score(250)
                    .malade(true)
                    .build();

            patientRepository.save(patient);
            patientRepository.save(patient2);
            patientRepository.save(patient3);

        };
    }

    @Bean
    PasswordEncoder  passwordEncoder(){

    return new BCryptPasswordEncoder();
    }
}
