package mental.mentalhospital.Repositories;

import mental.mentalhospital.Entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    @Query("SELECT c from City c ORDER BY c.name ASC")
    List<City> findAllCitiesByAsc();
}
