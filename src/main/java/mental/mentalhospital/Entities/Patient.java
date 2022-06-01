package mental.mentalhospital.Entities;

import mental.mentalhospital.Validators.DateConstraint;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table( name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 64)
    @Length(min = 3, max = 20, message = "Vardas turi būti ilgesnis nei 3 simboliai ir trumpesnis nei 20 simbolių")
    @NotNull
    @NotEmpty(message = "Vardas privalomas")
    private String name;

    @Column(nullable = false, length = 64)
    @Length(min = 3, max = 20, message = "Pavardė turi būti ilgesnė nei 3 simboliai ir trumpesnė nei 20 simbolių")
    @NotNull @NotEmpty(message = "Pavardė privaloma")
    private String surname;

    @Column(length = 64)
    @Length(max = 15, message = "Telefonas turi būti ne ilgesnis nei 15 simbolių") @NotNull @NotEmpty(message = "Telefonas privalomas")
    private String phone;

    @Column(length = 64)
    @NotNull @NotEmpty(message = "Adresas privalomas")
    private String address;

    @Column(length = 64)
    @DateConstraint
    private String birthDate;

    @Column
    private String filename;

    @ManyToOne
    @JoinColumn(name="doctorID", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="gender_ID", nullable = false)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name="city_ID", nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name="room_ID", nullable = false)
    private Room room;

    @Column
    private String statement;

    @Column
    private String treatment;

   /* @ManyToOne
    @JoinColumn(name="statement_ID", nullable = false)
    private Statement statement;

    @ManyToOne
    @JoinColumn(name="treatment_ID", nullable = false)
    private Treatment treatment;*/

    public Patient(){}

    public Patient(
            @Length(min = 3, max = 20, message = "Vardas turi būti ilgesnis nei 3 simboliai ir trumpesnis nei 20 simbolių") @javax.validation.constraints.NotNull @NotEmpty(message = "Vardas privalomas") String name,
            @Length(min = 3, max = 20, message = "Pavardė turi būti ilgesnė nei 3 simboliai ir trumpesnė nei 20 simbolių") @javax.validation.constraints.NotNull @NotEmpty(message = "Pavardė privaloma") String surname,
            @Length(max = 15, message = "Telefonas turi būti ne ilgesnis nei 15 simbolių") @javax.validation.constraints.NotNull @NotEmpty(message = "Telefonas privalomas") String phone,
            @javax.validation.constraints.NotNull @NotEmpty(message = "Adresas privalomas") String address, String birthDate,
            @NotBlank(message = "Pasirinkite lytį") Gender gender,
            @NotBlank(message = "Pasirinkite miestą") City city,
            @NotEmpty(message = "Diagnoze privaloma") String statement,
            String treatment) {
        super();
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.birthDate = birthDate;
        this.gender = gender;
        this.city = city;
        this.treatment = treatment;
        this.statement = statement;
    }
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
