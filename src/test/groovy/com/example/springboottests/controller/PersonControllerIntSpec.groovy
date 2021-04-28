package com.example.springboottests.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class PersonControllerIntSpec extends Specification {
    @Autowired
    protected MockMvc mvc

    def "when get is performed then the response has status 200"() {
        given:
        def request = MockMvcRequestBuilders
                .get("/person/")
                .contentType(MediaType.APPLICATION_JSON)

        when:
        def result = mvc.perform(request)

        then:
        result.andExpect(MockMvcResultMatchers
                .status()
                .isOk())

    }
}
