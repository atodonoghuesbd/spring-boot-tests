package com.example.springboottests.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Currency;

@Builder
@Getter
@Setter
public class Transaction {
    private Long sourcePersonId;
    private Long targetPersonId;
    private Currency currency;
    private BigDecimal cardinality;
}
