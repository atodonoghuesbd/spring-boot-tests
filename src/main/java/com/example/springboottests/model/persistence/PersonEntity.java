package com.example.springboottests.model.persistence;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.OneToOne;

@Data
@Builder
@Table("person")
public class PersonEntity {
    @Id
    @Column
    private Long id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    @OneToOne(targetEntity = WalletEntity.class)
    private WalletEntity walletEntity;
}
