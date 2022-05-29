package mental.mentalhospital.Repositories;

import mental.mentalhospital.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findByEmail(String email);
}
