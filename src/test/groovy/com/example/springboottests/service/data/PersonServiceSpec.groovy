package com.example.springboottests.service.data

import com.example.springboottests.configuration.OrikaConfiguration
import com.example.springboottests.model.persistence.PersonEntity
import com.example.springboottests.model.persistence.WalletEntity
import com.example.springboottests.model.transport.PersonTransportObject
import com.example.springboottests.model.transport.WalletTransportObject
import com.example.springboottests.repository.PersonRepository
import spock.lang.Specification

class PersonServiceSpec extends Specification {
    PersonService personService
    PersonRepository personRepository
    PersonTransportObject person

    def "setup"() {
        personRepository = Mock()
        personService = new PersonService(OrikaConfiguration.mapperFacade(), personRepository)
    }


    def "getPeople"() {
        given:
        WalletEntity walletEntity = new WalletEntity()
        walletEntity.setCardinality(new BigDecimal(0l))
        walletEntity.setCurrency(Currency.getInstance(Locale.US))
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirst_name("Austin")
        personEntity.setLast_name("O'Donoghue")

        when:
        personService.getPeople()

        then:
        1 * personRepository.findAll() >> Collections.singletonList(personEntity)
    }

    def "getPerson"() {
        given:
        Long id = 0l
        WalletEntity walletEntity = new WalletEntity()
        walletEntity.setCardinality(new BigDecimal(0l))
        walletEntity.setCurrency(Currency.getInstance(Locale.US))
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirst_name("Austin")
        personEntity.setLast_name("O'Donoghue")

        when:
        personService.getPerson(id)

        then:
        1 * personRepository.findById(id) >> Optional.of(personEntity)
    }

    def "postPerson"() {
        given:
        person = PersonTransportObject
                .builder()
                .wallet(WalletTransportObject
                        .builder().build())
                .build()

        when:
        personService.postPerson(person)

        then:
        1 * personRepository.save(_ as PersonEntity)
    }

    def "savePerson"() {
        given:
        person = PersonTransportObject
                .builder()
                .wallet(WalletTransportObject
                        .builder().build())
                .build()

        when:
        personService.savePerson(person)

        then:
        1 * personRepository.save(_ as PersonEntity)
    }

}
