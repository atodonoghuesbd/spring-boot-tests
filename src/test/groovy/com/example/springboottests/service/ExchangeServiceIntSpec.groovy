package com.example.springboottests.service

import com.example.springboottests.SpringBootTestsApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = [SpringBootTestsApplication.class])
class ExchangeServiceIntSpec extends Specification {
    @Autowired
    ExchangeService exchangeService

    def "transaction updates wallet"() {
        // todo: implement me
    }

    def "source not found in data"() {
        // todo: implement me
    }

    def "target not found in data"() {
        // todo: implement me
    }
}
