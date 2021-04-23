package com.example.springboottests.service;

import com.example.springboottests.model.Transaction;
import com.example.springboottests.model.transport.PersonTransportObject;
import com.example.springboottests.service.data.PersonService;
import com.example.springboottests.service.data.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {
    private final PersonService personService;
    private final WalletService walletService;

    @Autowired
    public ExchangeService(PersonService personService, WalletService walletService) {
        this.personService = personService;
        this.walletService = walletService;
    }

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

    // todo: implement me
    public String exchange(Transaction transaction) {
        PersonTransportObject[] arr = { personService.getPerson(transaction.getSourcePersonId()),
        personService.getPerson(transaction.getTargetPersonId())};

        return "";
    }

}
