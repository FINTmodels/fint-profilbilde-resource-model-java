// Built from tag v2.7.0

package no.fint.model.resource.avatar;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import no.fint.model.FintMainObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;
import no.fint.model.resource.felles.kompleksedatatyper.AdresseResource;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.kompleksedatatyper.Personnavn;
import no.fint.model.resource.felles.basisklasser.AktorResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AvatarResource implements FintMainObject, FintLinks {
    // Attributes
    @NonNull
    private Identifikator systemId;
    @NonNull
    private String filnavn;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        

    @JsonIgnore
    public List<Link> getPerson() {
        return getLinks().getOrDefault("person", Collections.emptyList());
    }
    public void addPerson(Link link) {
        addLink("person", link);
    }

    @JsonIgnore
    public List<Link> getPersonalressurs() {
        return getLinks().getOrDefault("personalressurs", Collections.emptyList());
    }
    public void addPersonalressurs(Link link) {
        addLink("personalressurs", link);
    }

    @JsonIgnore
    public List<Link> getElev() {
        return getLinks().getOrDefault("elev", Collections.emptyList());
    }
    public void addElev(Link link) {
        addLink("elev", link);
    }
}
