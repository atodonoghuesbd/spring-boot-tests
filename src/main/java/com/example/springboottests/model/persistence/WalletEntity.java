package com.example.springboottests.model.persistence;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.Currency;

@Data
@Builder
@Table("wallet")
public class WalletEntity {
    @Id
    @Column
    private Long id;
    @Column
    @OneToOne(targetEntity = PersonEntity.class)
    private PersonEntity owner;
    @Column
    private Currency currency;
    @Column
    private BigDecimal cardinality;
}
