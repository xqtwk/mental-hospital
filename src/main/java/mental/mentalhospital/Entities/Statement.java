package mental.mentalhospital.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "statement")
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String description;

    /*@OneToMany(mappedBy = "statement")
    private List<Patient> patients;*/
    public Statement(){}
    public Statement(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
