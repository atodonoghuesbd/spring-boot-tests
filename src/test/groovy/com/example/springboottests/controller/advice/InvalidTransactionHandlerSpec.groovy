package com.example.springboottests.controller.advice

import com.example.springboottests.exception.InvalidTransactionException
import org.springframework.http.HttpStatus
import org.springframework.web.context.request.WebRequest
import spock.lang.Specification

class InvalidTransactionHandlerSpec extends Specification {
    InvalidTransactionHandler invalidTransactionHandler = new InvalidTransactionHandler()

    def "test invalid transaction"() {
        given:
        String message = "message"
        InvalidTransactionException invalidTransactionException = new InvalidTransactionException(message)
        WebRequest webRequest = Stub()

        when:
        def result = invalidTransactionHandler.handleConflict(invalidTransactionException, webRequest)

        then:
        result.getStatusCode() == HttpStatus.BAD_REQUEST
        result.getBody() == message
    }
}
