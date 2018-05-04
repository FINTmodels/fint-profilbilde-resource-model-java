package no.fint.test.model

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.json.JsonSlurper
import no.fint.model.resource.Link
import no.fint.model.resource.avatar.AvatarResource
import spock.lang.Specification

class ModelSerializationSpec extends Specification {
    def objectMapper
    def jsonSlurper

    void setup() {
        objectMapper = new ObjectMapper()
        jsonSlurper = new JsonSlurper()
    }

    def "Serialize AvatarResource with links"() {
        given:
        def person = new AvatarResource(
                filnavn: "dummy.jpg")
        person.addPerson(Link.with("/felles/kjonn/systemid/1"))
        person.addPersonalressurs(Link.with("/felles/land/systemid/no"))

        when:
        def result = objectMapper.writeValueAsString(person)
        println(result)
        def object = jsonSlurper.parseText(result)

        then:
        object
        object._links.person
    }

}
