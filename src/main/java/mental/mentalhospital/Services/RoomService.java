package mental.mentalhospital.Services;

import mental.mentalhospital.Entities.Floor;
import mental.mentalhospital.Repositories.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    FloorRepository floorRepository;

    public Floor addClients(Floor client){
        return floorRepository.save(client);
    }
    public Floor updateClients(Floor client){
        Floor old = floorRepository.getById(client.getId());
        old.setNumber(client.getNumber());
        old.setRoom_number(client.getRoom_number());
        floorRepository.save(old);
        return old;
    }
    public void deleteClients( Integer id){
        floorRepository.deleteById(id);
    }
    public Floor getClients(Integer id){
        return floorRepository.getById(id);
    }
    public List<Floor> getAllClients(){
        return floorRepository.findAll();
    }
}
