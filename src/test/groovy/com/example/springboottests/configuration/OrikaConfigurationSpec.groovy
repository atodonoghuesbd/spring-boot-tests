package com.example.springboottests.configuration

import com.example.springboottests.model.persistence.PersonEntity
import com.example.springboottests.model.transport.PersonTransportObject
import ma.glasnost.orika.MapperFacade
import org.jeasy.random.EasyRandom
import spock.lang.Specification

class OrikaConfigurationSpec extends Specification {
    EasyRandom easyRandom
    MapperFacade mapperFacade

    def "setup"() {
        mapperFacade = OrikaConfiguration.mapperFacade()
        easyRandom = new EasyRandom()
    }

    def "person entity to person transport object"() {
        given:
        PersonEntity personEntity = easyRandom.nextObject(PersonEntity.class)

        when:
        PersonTransportObject personTransportObject = mapperFacade.map(personEntity, PersonTransportObject.class)

        then:
        personEntity.first_name == personTransportObject.firstName
        personEntity.last_name == personTransportObject.lastName
        personEntity.wallet.cardinality == personTransportObject.wallet.cardinality
        personEntity.wallet.currency == personTransportObject.wallet.currency
    }

    def "person transport object to person entity"() {
        given:
        PersonTransportObject personTransportObject = easyRandom.nextObject(PersonTransportObject.class)

        when:
        PersonEntity personEntity = mapperFacade.map(personTransportObject, PersonEntity.class)

        then:
        personEntity.first_name == personTransportObject.firstName
        personEntity.last_name == personTransportObject.lastName
        personEntity.wallet.cardinality == personTransportObject.wallet.cardinality
        personEntity.wallet.currency == personTransportObject.wallet.currency
    }
}
