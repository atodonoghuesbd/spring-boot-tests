package com.example.springboottests.model.transport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Currency;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletTransportObject {
    private Long id;
    private Currency currency;
    private BigDecimal cardinality;
}
