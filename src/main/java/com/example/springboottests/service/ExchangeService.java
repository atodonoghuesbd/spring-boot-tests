package com.example.springboottests.service;

import com.example.springboottests.model.Transaction;
import com.example.springboottests.model.transport.PersonTransportObject;
import com.example.springboottests.service.data.PersonService;
import com.example.springboottests.service.data.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class ExchangeService {
    private final PersonService personService;
    private final WalletService walletService;

    @Autowired
    public ExchangeService(PersonService personService, WalletService walletService) {
        this.personService = personService;
        this.walletService = walletService;
    }

    public String exchange(Transaction transaction) {
        PersonTransportObject[] arr = { personService.getPerson(transaction.getSourcePersonId()),
          personService.getPerson(transaction.getTargetPersonId())};
        if (arr[0]


        return "";
    }
    // todo: implement me

    /**
     * version one:
     *
     * This service should accept a Transaction request, containing the IDs of a target and source.
     *
     * If the IDs map to users with differing currencies the transaction should fail. An appropriate failure message
     * should be returned.
     *
     * If the source's currency cardinality is exceeded by the transaction cardinality the transaction should fail. An
     * appropriate failure message should be returned.
     *
     * If the transaction is otherwise valid it should report a message of success.
     *
     * version two:
     *
     * failures should throw custom exceptions and be handled with Controller Advice
     */
}
