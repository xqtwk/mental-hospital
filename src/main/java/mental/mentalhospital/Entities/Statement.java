package mental.mentalhospital.Entities;

import javax.persistence.*;

@Entity
@Table( name = "statement")
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


}
