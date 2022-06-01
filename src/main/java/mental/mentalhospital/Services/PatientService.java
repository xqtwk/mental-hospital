package mental.mentalhospital.Services;

import mental.mentalhospital.Entities.Patient;
import mental.mentalhospital.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public Patient addClients(Patient client){
        return patientRepository.save(client);
    }
    public Patient updateClients(Patient client){
        Patient old = patientRepository.getReferenceById(client.getId());
        old.setName(client.getName());
        old.setSurname(client.getSurname());
        old.setPhone(client.getPhone());
        old.setAddress(client.getAddress());
        old.setBirthDate(client.getBirthDate());
        old.setStatement(client.getStatement());
        old.setTreatment(client.getTreatment());
        old.setDoctor(client.getDoctor());
        //old.setGender(client.getGender());
        //old.setCity(client.getCity());
        old.setRoom(client.getRoom());
        patientRepository.save(old);
        return old;
    }
    public void deleteClients( Integer id){
        patientRepository.deleteById(id);
    }
    public Patient getClients(Integer id){
        return patientRepository.getById(id);
    }
    public List<Patient> getAllClients(){
        return patientRepository.findAll();
    }
}
