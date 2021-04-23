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
    }


    def "getPeople"() {
        given:
            personController = new PersonController(personService)

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
        // todo: implement me
    }

    def "postPerson"() {
        // todo: implement me
    }

}
