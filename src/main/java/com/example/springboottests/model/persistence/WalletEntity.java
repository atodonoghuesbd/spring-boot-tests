package com.example.springboottests.model.persistence;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.Currency;

@Data
@Entity(name = "wallet")
public class WalletEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Currency currency;
    @Column
    private BigDecimal cardinality;
    @OneToOne
    private PersonEntity owner;

    public WalletEntity() {

    }
}
