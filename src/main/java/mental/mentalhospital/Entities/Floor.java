package mental.mentalhospital.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "floor")
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 64)
    private Integer number;

    @Column
    private Integer room_number;

    @OneToMany(mappedBy = "floor")
    private List<Room> rooms;
    public Floor(){}
    public Floor(Integer number, Integer room_number){
        this.number = number;
        this.room_number = room_number;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setRoom_number(Integer room_number) {
        this.room_number = room_number;
    }
}
