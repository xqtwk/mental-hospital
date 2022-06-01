package mental.mentalhospital.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 64)
    private Integer room_number;
    @Column
    private String room_description;
    @Column
    private Integer patients_limit;

    @ManyToOne
    @JoinColumn(name="floor_ID")
    private Floor floor;

    @OneToMany(mappedBy = "room")
    private List<Patient> patients;
    public Room() {}

    public Room(Integer room_number, String room_description, Integer patients_limit) {
        this.room_number = room_number;
        this.room_description = room_description;
        this.patients_limit = patients_limit;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoom_number() {
        return room_number;
    }

    public void setRoom_number(Integer room_number) {
        this.room_number = room_number;
    }

    public String getRoom_description() {
        return room_description;
    }

    public void setRoom_description(String room_description) {
        this.room_description = room_description;
    }

    public Integer getPatients_limit() {
        return patients_limit;
    }

    public void setPatients_limit(Integer patients_limit) {
        this.patients_limit = patients_limit;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
