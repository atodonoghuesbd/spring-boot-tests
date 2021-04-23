package com.example.springboottests.model.transport;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
public class WalletTransportObject {
    private Long id;
    private Currency currency;
    private BigDecimal cardinality;
}
