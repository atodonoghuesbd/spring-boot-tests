package com.example.springboottests.model.persistence;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Currency;

@Data
@Embeddable
public class WalletEntity {
    @Column
    private Currency currency;
    @Column
    private BigDecimal cardinality;
}
