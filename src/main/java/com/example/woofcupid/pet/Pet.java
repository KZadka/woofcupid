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
    //private String owner;
    private String name;
    private String type;
    private LocalDate birthDate;
    private String sex;
    private String character;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;



    public Pet(String owner, String name, String type,
               LocalDate birthDate, String sex,
               String character) {
        //this.owner = owner;
        this.name = name;
        this.type = type;
        this.birthDate = birthDate;
        this.sex = sex;
        this.character = character;
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
                ", sex='" + sex + '\'' +
                ", character='" + character + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
