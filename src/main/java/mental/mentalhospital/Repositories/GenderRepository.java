package mental.mentalhospital.Repositories;

import mental.mentalhospital.Entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Integer> {

}