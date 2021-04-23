package com.example.springboottests.service;

import com.example.springboottests.model.Transaction;
import com.example.springboottests.model.transport.PersonTransportObject;
import com.example.springboottests.service.data.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Currency;

@Service
public class ExchangeService {
    protected static final String INVALID_SOURCE_CURRENCY = "No exchange transacted, transaction currency and source currency mismatch.";
    protected static final String INVALID_TARGET_CURRENCY = "No exchange transacted, transaction currency and target currency mismatch.";
    protected static final String INSUFFICIENT_FUNDS = "Insufficient source cardinality for transaction.";
    protected static final String SUCCESS = "Exchange transacted successfully.";
    private final PersonService personService;

    @Autowired
    public ExchangeService(PersonService personService) {
        this.personService = personService;
    }

    /**
     * version one:
     * <p>
     * This service should accept a Transaction request, containing the IDs of a target and source.
     * <p>
     * If the IDs map to users with differing currencies the transaction should fail. An appropriate failure message
     * should be returned.
     * <p>
     * If the source's currency cardinality is exceeded by the transaction cardinality the transaction should fail. An
     * appropriate failure message should be returned.
     * <p>
     * If the transaction is otherwise valid it should report a message of success.
     * <p>
     * version two:
     * <p>
     * failures should throw custom exceptions and be handled with Controller Advice
     */

    // todo: implement me
    public String exchange(Transaction transaction) {

        Long sourceId = transaction.getSourcePersonId();
        Long targetId = transaction.getTargetPersonId();

        PersonTransportObject source = personService.getPerson(sourceId);
        PersonTransportObject target = personService.getPerson(targetId);

        Currency sourceCurrency = source.getWallet().getCurrency();
        Currency targetCurrency = target.getWallet().getCurrency();
        Currency currency = transaction.getCurrency();

        BigDecimal sourceCardinality = source.getWallet().getCardinality();
        BigDecimal cardinality = transaction.getCardinality();


        if (validateSourceCurrency(sourceCurrency, currency))
            return INVALID_SOURCE_CURRENCY;

        if (validateTargetCurrency(targetCurrency, currency))
            return INVALID_TARGET_CURRENCY;

        if (validateFunds(sourceCardinality, cardinality))
            return INSUFFICIENT_FUNDS;

        executeTransaction(source, target, cardinality);

        return SUCCESS;
    }

    private boolean validateSourceCurrency(Currency sourceCurrency, Currency currency) {
        return sourceCurrency != currency;
    }

    private boolean validateTargetCurrency(Currency targetCurrency, Currency currency) {
        return targetCurrency != currency;
    }

    private boolean validateFunds(BigDecimal sourceCardinality, BigDecimal cardinality) {
        return 0 < cardinality.compareTo(sourceCardinality);
    }

    @Transactional
    protected void executeTransaction(PersonTransportObject source, PersonTransportObject target, BigDecimal cardinality) {
        source.getWallet().setCardinality(source.getWallet().getCardinality().subtract(cardinality));
        target.getWallet().setCardinality(target.getWallet().getCardinality().add(cardinality));

        personService.savePerson(source);
        personService.savePerson(target);
    }
}
