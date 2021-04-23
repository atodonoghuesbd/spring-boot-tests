package com.example.springboottests.model.transport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonTransportObject {
    private Long id;
    private String firstName;
    private String lastName;
    private WalletTransportObject wallet;
}
