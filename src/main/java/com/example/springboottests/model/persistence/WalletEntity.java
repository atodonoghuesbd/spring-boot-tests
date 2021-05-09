package com.example.springboottests.model.persistence;

import java.math.BigDecimal;
import java.util.Currency;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class WalletEntity {

  @Column
  private Currency currency;
  @Column
  private BigDecimal cardinality;
}
