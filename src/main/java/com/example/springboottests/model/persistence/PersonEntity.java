package com.example.springboottests.model.persistence;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity(name = "person")
public class PersonEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @OneToOne
    private WalletEntity wallet;

    public PersonEntity() {

    }
}
