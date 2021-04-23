package com.example.springboottests.model.transport;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonTransportObject {
    private Long id;
    private String firstName;
    private String lastName;
    private WalletTransportObject wallet;
}
