package mental.mentalhospital.Entities;

import javax.persistence.*;

@Entity
@Table( name = "treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String treatment;
    public Treatment(){}
    public Treatment(String treatment){
        this.treatment = treatment;
    }
    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
