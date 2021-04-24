package com.example.springboottests.controller

import com.example.springboottests.model.transport.PersonTransportObject
import com.example.springboottests.model.transport.WalletTransportObject
import com.example.springboottests.service.data.PersonService
import spock.lang.Specification

class PersonControllerSpec extends Specification {
    PersonController personController
    PersonService personService
    PersonTransportObject person

    def "setup"() {
        personService = Mock()
        personController = new PersonController(personService)
    }


    def "getPeople"() {
        given:
        person = PersonTransportObject
                .builder()
                .wallet(WalletTransportObject
                        .builder().build())
                .build()

        when:
        personController.getPeople()

        then:
        1 * personService.getPeople() >> Collections.singletonList(person)
    }

    def "getPerson"() {
        given:
        Long id = 0l

        when:
        personController.getPerson(id)

        then:
        1 * personService.getPerson(id)

    }

    def "postPerson"() {
        given:
        person = PersonTransportObject
                .builder()
                .wallet(WalletTransportObject
                        .builder().build())
                .build()

        when:
        personController.postPerson(person)

        then:
        1 * personService.postPerson(person)
    }

}
