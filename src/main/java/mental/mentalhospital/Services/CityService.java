package mental.mentalhospital.Services;

import mental.mentalhospital.Entities.City;
import mental.mentalhospital.Repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public List<City> getAllCities(){

        return cityRepository.findAllCitiesByAsc();
    }
    public City getCity(Integer id) {
        return cityRepository.getById(id);
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public void deleteCity(Integer id) {
        cityRepository.deleteById(id);
    }

    public City updateCity(City city) {
        City old = cityRepository.getById(city.getId());
        old.setName(city.getName());
        return old;
    }
}
