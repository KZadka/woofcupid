package com.example.woofcupid.pet;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String type;
    private LocalDate birthDate;
    private String sex;
    private String character;
}
