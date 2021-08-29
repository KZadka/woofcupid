package com.example.woofcupid.pet;

import com.example.woofcupid.owner.Owner;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String gender;
    private String character;
    private String type;

    @ManyToOne()
    @JoinColumn(name = "owner_id")
    private Owner owner;


    public Pet(String name, String birthDate,
               String gender,String type,
               String character, Long owner) {
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate);
        this.gender = gender;
        this.type = type;
        this.character = character;
        this.owner = owner;
    }
    protected Pet() {
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", character='" + character + '\'' +
                '}';
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
