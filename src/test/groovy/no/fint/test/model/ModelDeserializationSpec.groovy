package no.fint.test.model

import com.fasterxml.jackson.databind.ObjectMapper
import no.fint.model.resource.profilbilde.ProfilbildeResource
import no.fint.model.resource.profilbilde.ProfilbildeResources

import spock.lang.Specification

class ModelDeserializationSpec extends Specification {
    def objectMapper

    void setup() {
        objectMapper = new ObjectMapper()
    }

    def "Read ProfilbildeResource from profilbilde.json"() {
        given:
        def input = getClass().getResourceAsStream("/profilbilde.json")

        when:
        def result = objectMapper.readValue(input, ProfilbildeResource.class)
        println(result)

        then:
        result
    }

    def "Read ProfilbildeResource from profilbilderesource.json"() {
        given:
        def input = getClass().getResourceAsStream("/profilbilderesource.json")

        when:
        def result = objectMapper.readValue(input, ProfilbildeResource.class)
        println(result)

        then:
        result
    }


    def "Read ProfilbildeResource from profilbilderesourcelinks.json"() {
        given:
        def input = getClass().getResourceAsStream("/profilbilderesourcelinks.json")

        when:
        def result = objectMapper.readValue(input, ProfilbildeResource.class)
        println(result)

        then:
        result
        result.filnavn
    }

    def "Read ProfilbildeResources from profilbilderesourceslinks.json"() {
        given:
        def input = getClass().getResourceAsStream("/profilbilderesourceslinks.json")

        when:
        def result = objectMapper.readValue(input, ProfilbildeResources.class)
        println(result)

        then:
        result
        result.getTotalItems() == 1
        result.links.self.size() == 1
        result.content[0].filnavn
    }
}
