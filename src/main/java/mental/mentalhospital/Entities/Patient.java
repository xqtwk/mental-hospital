package mental.mentalhospital.Entities;

import com.sun.istack.NotNull;
import mental.mentalhospital.Validators.DateConstraint;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
@Entity
@Table( name = "patient")
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


    @ManyToOne
    @MapsId
    @JoinColumn(name="doctorID", nullable = false, insertable = false, updatable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="gender_ID", nullable = false)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name="city_ID", nullable = false)
    private City city;


    public Patient(){}

    public Patient(
            @Length(min = 3, max = 20, message = "Vardas turi būti ilgesnis nei 3 simboliai ir trumpesnis nei 20 simbolių") @javax.validation.constraints.NotNull @NotEmpty(message = "Vardas privalomas") String name,
            @Length(min = 3, max = 20, message = "Pavardė turi būti ilgesnė nei 3 simboliai ir trumpesnė nei 20 simbolių") @javax.validation.constraints.NotNull @NotEmpty(message = "Pavardė privaloma") String surname,
            @Length(max = 15, message = "Telefonas turi būti ne ilgesnis nei 15 simbolių") @javax.validation.constraints.NotNull @NotEmpty(message = "Telefonas privalomas") String phone,
            @javax.validation.constraints.NotNull @NotEmpty(message = "Adresas privalomas") String address, String birthDate,
            @NotBlank(message = "Pasirinkite lytį") Gender gender,
            @NotBlank(message = "Pasirinkite miestą") City city) {
        super();
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.birthDate = birthDate;
        this.gender = gender;
        this.city = city;
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
}
