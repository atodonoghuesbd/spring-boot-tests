package com.example.springboottests.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Builder
@Data
public class Transaction {
    private Long sourcePersonId;
    private Long targetPersonId;
    private Currency currency;
    private BigDecimal cardinality;
}
