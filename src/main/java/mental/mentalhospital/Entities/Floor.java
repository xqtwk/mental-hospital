package mental.mentalhospital.Entities;

import javax.persistence.*;

@Entity
@Table( name = "floor")
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 64)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;

    @Column
    private Integer room_number;

    public Floor(){}
    public Floor(Integer room_number){
        this.room_number = room_number;
    }
    public Integer getRoom_number() {
        return room_number;
    }

    public void setRoom_number(Integer room_number) {
        this.room_number = room_number;
    }
}
