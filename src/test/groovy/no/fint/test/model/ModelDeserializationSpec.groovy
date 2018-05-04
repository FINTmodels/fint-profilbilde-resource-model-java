package no.fint.test.model

import com.fasterxml.jackson.databind.ObjectMapper
import no.fint.model.resource.avatar.AvatarResource
import no.fint.model.resource.avatar.AvatarResources

//import AvatarResources
import spock.lang.Specification

class ModelDeserializationSpec extends Specification {
    def objectMapper

    void setup() {
        objectMapper = new ObjectMapper()
    }

    def "Read AvatarResource from avatar.json"() {
        given:
        def input = getClass().getResourceAsStream("/avatar.json")

        when:
        def result = objectMapper.readValue(input, AvatarResource.class)
        println(result)

        then:
        result
    }

    def "Read AvatarResource from avatarresource.json"() {
        given:
        def input = getClass().getResourceAsStream("/avatarresource.json")

        when:
        def result = objectMapper.readValue(input, AvatarResource.class)
        println(result)

        then:
        result
    }


    def "Read AvatarResource from avatarresourcelinks.json"() {
        given:
        def input = getClass().getResourceAsStream("/avatarresourcelinks.json")

        when:
        def result = objectMapper.readValue(input, AvatarResource.class)
        println(result)

        then:
        result
        result.filnavn
    }

    def "Read AvatarResources from avatarresourceslinks.json"() {
        given:
        def input = getClass().getResourceAsStream("/avatarresourceslinks.json")

        when:
        def result = objectMapper.readValue(input, AvatarResources.class)
        println(result)

        then:
        result
        result.getTotalItems() == 1
        result.links.self.size() == 1
        result.content[0].filnavn
    }
}
