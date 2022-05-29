package mental.mentalhospital.Services;

import mental.mentalhospital.Entities.Doctor;
import mental.mentalhospital.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService implements UserDetailsService {
    @Autowired
    DoctorRepository doctorRepository;

    public Doctor addClient(Doctor client){
        client.setPassword((new BCryptPasswordEncoder()).encode(client.getPassword()));
        return doctorRepository.save(client);
    }
    public void deleteDoctors( Integer id){
        doctorRepository.deleteById(id);
    }
    public Doctor getDoctors(Integer id){
        return doctorRepository.getById(id);
    }
    public List<Doctor> getAllDoctors() { return doctorRepository.findAll(); }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Doctor client = doctorRepository.findByEmail(email);
        if (client==null) {
            throw new UsernameNotFoundException("Vartotojas nerastas");
        }
        return client;
    }
}
