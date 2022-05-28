package mental.mentalhospital.Services;

import mental.mentalhospital.Entities.Gender;
import mental.mentalhospital.Repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {

    @Autowired
    GenderRepository genderRepository;

    public List<Gender> getAllGenders(){
        return genderRepository.findAll();
    }

    public Gender getGender(Integer id) {
        return genderRepository.getById(id);
    }

    public void deleteGender(Integer id) {
        genderRepository.deleteById(id);
    }

    public Gender addGender(Gender gender) {
        return genderRepository.save(gender);
    }
    public Gender updateGender(Gender gender) {
        Gender old = genderRepository.getById(gender.getId());
        old.setName(gender.getName());
        return old;
    }
}
