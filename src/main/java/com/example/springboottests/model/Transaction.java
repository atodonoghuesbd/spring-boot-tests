package com.example.springboottests.model;

import java.math.BigDecimal;
import java.util.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Transaction {

  private Long sourcePersonId;
  private Long targetPersonId;
  private Currency currency;
  private BigDecimal cardinality;
}
