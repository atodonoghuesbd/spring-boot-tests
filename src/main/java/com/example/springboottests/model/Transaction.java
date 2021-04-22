package com.example.springboottests.model;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.Currency;

@Builder
public class Transaction {
    private Long sourcePersonId;
    private Long targetPersonId;
    private Currency currency;
    private BigDecimal cardinality;
}
