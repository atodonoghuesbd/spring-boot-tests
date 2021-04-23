package com.example.springboottests.controller

import com.example.springboottests.model.Transaction
import com.example.springboottests.service.ExchangeService
import spock.lang.Specification

class ExchangeControllerSpec extends Specification {
    ExchangeController exchangeController
    ExchangeService exchangeService = Mock()

    def "setup"() {
        exchangeController = new ExchangeController(exchangeService)
    }

    def "exchange"() {
        when:

            exchangeController.exchange(Transaction.builder().build())

        then:

            1 * exchangeService.exchange(_ as Transaction) >> new String()
    }
}
