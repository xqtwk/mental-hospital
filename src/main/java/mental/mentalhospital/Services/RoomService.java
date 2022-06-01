package mental.mentalhospital.Services;

import mental.mentalhospital.Entities.Room;
import mental.mentalhospital.Repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public Room addClients(Room client){
        return roomRepository.save(client);
    }
    public Room updateClients(Room client){
        Room old = roomRepository.getById(client.getId());
        old.setRoom_number(client.getRoom_number());
        old.setRoom_description(client.getRoom_description());
        old.setPatients_limit(client.getPatients_limit());
        roomRepository.save(old);
        return old;
    }
    public void deleteClients( Integer id){
        roomRepository.deleteById(id);
    }
    public Room getClients(Integer id){
        return roomRepository.getById(id);
    }
    public List<Room> getAllClients(){
        return roomRepository.findAll();
    }
}
