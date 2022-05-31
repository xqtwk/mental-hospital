package mental.mentalhospital.Entities;

import javax.persistence.*;

@Entity
@Table( name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 64)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;
    @Column(columnDefinition="TEXT")
    String description;
    @Column
    private Integer limit;
    public Room() {}

    public Room(String description, Integer limit) {
        this.description = description;
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
