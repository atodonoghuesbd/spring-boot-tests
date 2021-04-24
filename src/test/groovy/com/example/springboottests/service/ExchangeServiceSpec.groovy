package com.example.springboottests.service

import com.example.springboottests.exception.InvalidTransactionException
import com.example.springboottests.model.Transaction
import com.example.springboottests.model.transport.PersonTransportObject
import com.example.springboottests.model.transport.WalletTransportObject
import com.example.springboottests.service.data.PersonService
import spock.lang.Specification

class ExchangeServiceSpec extends Specification {
    PersonService personService
    ExchangeService exchangeService

    def "setup"() {
        personService = Stub()
        exchangeService = new ExchangeService(personService)
    }

    def "successful transaction"() {

        given:
        float value = 1_000.00f
        def cardinality = new BigDecimal(value)
        long sourceId = 0l;
        long targetId = 1l;
        Locale locale = Locale.US;
        Currency currency = Currency.getInstance(locale)

        def source = PersonTransportObject
                .builder()
                .wallet(WalletTransportObject
                        .builder()
                        .cardinality(cardinality)
                        .currency(currency)
                        .build())
                .id(sourceId)
                .build()

        def target = PersonTransportObject
                .builder()
                .wallet(WalletTransportObject
                        .builder()
                        .cardinality(new BigDecimal(0l))
                        .currency(currency)
                        .build())
                .id(targetId)
                .build()

        Transaction transaction = Transaction
                .builder()
                .sourcePersonId(sourceId)
                .targetPersonId(targetId)
                .currency(currency)
                .cardinality(cardinality)
                .build()

        personService.getPerson(sourceId) >> source
        personService.getPerson(targetId) >> target

        when:
        def returnString = exchangeService.exchange(transaction)

        then:
        returnString == ExchangeService.SUCCESS
    }

    def "insufficient funds"() {

        given:
        float value = 1_000.00f
        def cardinality = new BigDecimal(value)
        long sourceId = 0l;
        long targetId = 1l;
        Locale locale = Locale.US;
        Currency currency = Currency.getInstance(locale)

        def source = PersonTransportObject
                .builder()
                .wallet(WalletTransportObject
                        .builder()
                        .cardinality(new BigDecimal(0l))
                        .currency(currency)
                        .build())
                .id(sourceId)
                .build()

        def target = PersonTransportObject
                .builder()
                .wallet(WalletTransportObject
                        .builder()
                        .cardinality(new BigDecimal(0l))
                        .currency(currency)
                        .build())
                .id(targetId)
                .build()

        Transaction transaction = Transaction
                .builder()
                .sourcePersonId(sourceId)
                .targetPersonId(targetId)
                .currency(currency)
                .cardinality(cardinality)
                .build()

        personService.getPerson(sourceId) >> source
        personService.getPerson(targetId) >> target

        when:

        exchangeService.exchange(transaction)

        then:

        InvalidTransactionException thrown = thrown()
        thrown.getMessage() == ExchangeService.INSUFFICIENT_FUNDS
    }

    def "invalid source currency"() {

        given:
        float value = 0.0f
        def cardinality = new BigDecimal(value)
        long sourceId = 0l
        long targetId = 1l
        Locale locale = Locale.US
        Locale sourceLocale = Locale.ITALY
        Currency currency = Currency.getInstance(locale)
        Currency sourceCurrency = Currency.getInstance(sourceLocale)

        def source = PersonTransportObject
                .builder()
                .wallet(WalletTransportObject
                        .builder()
                        .cardinality(new BigDecimal(0l))
                        .currency(sourceCurrency)
                        .build())
                .id(sourceId)
                .build()

        def target = PersonTransportObject
                .builder()
                .wallet(WalletTransportObject
                        .builder()
                        .cardinality(new BigDecimal(0l))
                        .currency(currency)
                        .build())
                .id(targetId)
                .build()

        Transaction transaction = Transaction
                .builder()
                .sourcePersonId(sourceId)
                .targetPersonId(targetId)
                .currency(currency)
                .cardinality(cardinality)
                .build()

        personService.getPerson(sourceId) >> source
        personService.getPerson(targetId) >> target

        when:
        exchangeService.exchange(transaction)

        then:
        InvalidTransactionException thrown = thrown()
        thrown.getMessage() == ExchangeService.INVALID_SOURCE_CURRENCY
    }

    def "invalid target currency"() {

        given:

        float value = 0.0f
        def cardinality = new BigDecimal(value)
        long sourceId = 0l
        long targetId = 1l
        Locale locale = Locale.US
        Locale targetLocale = Locale.ITALY
        Currency currency = Currency.getInstance(locale)
        Currency targetCurrency = Currency.getInstance(targetLocale)

        def source = PersonTransportObject
                .builder()
                .wallet(WalletTransportObject
                        .builder()
                        .cardinality(new BigDecimal(0l))
                        .currency(currency)
                        .build())
                .id(sourceId)
                .build()

        def target = PersonTransportObject
                .builder()
                .wallet(WalletTransportObject
                        .builder()
                        .cardinality(new BigDecimal(0l))
                        .currency(targetCurrency)
                        .build())
                .id(targetId)
                .build()

        Transaction transaction = Transaction
                .builder()
                .sourcePersonId(sourceId)
                .targetPersonId(targetId)
                .currency(currency)
                .cardinality(cardinality)
                .build()

        personService.getPerson(sourceId) >> source
        personService.getPerson(targetId) >> target

        when:
        exchangeService.exchange(transaction)

        then:
        InvalidTransactionException thrown = thrown()
        thrown.getMessage() == ExchangeService.INVALID_TARGET_CURRENCY
    }
}
