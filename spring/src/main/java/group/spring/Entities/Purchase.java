package group.spring.Entities;

import javax.persistence.*;

@Entity(name = "Purchase")
@Table
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String surname;
    private String telNumber;
    private String email;

    public Purchase() {
    }

    public Purchase(Long id, String name, String surname, String telNumber, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.telNumber = telNumber;
        this.email = email;
    }

    public Purchase(String name, String surname, String telNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.telNumber = telNumber;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getEmail() {
        return email;
    }
}
