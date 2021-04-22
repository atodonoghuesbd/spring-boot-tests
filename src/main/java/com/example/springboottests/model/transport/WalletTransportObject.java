package com.example.springboottests.model.transport;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
@Builder
public class WalletTransportObject {
    private Long id;
    private Currency currency;
    private BigDecimal cardinality;
}
