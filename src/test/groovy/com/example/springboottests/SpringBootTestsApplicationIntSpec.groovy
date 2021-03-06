package com.example.springboottests


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = [SpringBootTestsApplication.class])
class SpringBootTestsApplicationIntSpec extends Specification {

    @Autowired
    ApplicationContext applicationContext

    def "context loads"() {
        when:
        SpringBootTestsApplication.main(new String[]{})
        then:
        applicationContext != null
    }
}
