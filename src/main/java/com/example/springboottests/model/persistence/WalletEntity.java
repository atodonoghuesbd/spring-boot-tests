package com.example.springboottests.model.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Currency;

@Getter
@Setter
@Embeddable
public class WalletEntity {
    @Column
    private Currency currency;
    @Column
    private BigDecimal cardinality;
}
