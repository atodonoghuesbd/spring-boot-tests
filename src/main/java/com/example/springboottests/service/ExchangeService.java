package com.example.springboottests.service;

import com.example.springboottests.exception.InvalidTransactionException;
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

        PersonTransportObject source = getPerson(transaction.getSourcePersonId());
        PersonTransportObject target = getPerson(transaction.getTargetPersonId());

        Currency sourceCurrency = getCurrency(source);
        Currency targetCurrency = getCurrency(target);
        Currency currency = getCurrency(transaction);

        BigDecimal sourceCardinality = getCardinality(source);
        BigDecimal cardinality = getCardinality(transaction);

        if (validateSourceCurrency(sourceCurrency, currency))
            throw new InvalidTransactionException(INVALID_SOURCE_CURRENCY);

        if (validateTargetCurrency(targetCurrency, currency))
            throw new InvalidTransactionException(INVALID_TARGET_CURRENCY);

        if (validateFunds(sourceCardinality, cardinality))
            throw new InvalidTransactionException(INSUFFICIENT_FUNDS);

        executeTransaction(source, target, cardinality);

        return SUCCESS;
    }

    private PersonTransportObject getPerson(Long id) {
        return personService.getPerson(id);
    }

    private static BigDecimal getCardinality(PersonTransportObject personTransportObject) {
        return personTransportObject.getWallet().getCardinality();
    }

    private static BigDecimal getCardinality(Transaction transaction) {
        return transaction.getCardinality();
    }

    private static Currency getCurrency(PersonTransportObject personTransportObject) {
        return personTransportObject.getWallet().getCurrency();
    }

    private static Currency getCurrency(Transaction transaction) {
        return transaction.getCurrency();
    }

    private static boolean validateSourceCurrency(Currency sourceCurrency, Currency currency) {
        return sourceCurrency != currency;
    }

    private static boolean validateTargetCurrency(Currency targetCurrency, Currency currency) {
        return targetCurrency != currency;
    }

    private static boolean validateFunds(BigDecimal sourceCardinality, BigDecimal cardinality) {
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
