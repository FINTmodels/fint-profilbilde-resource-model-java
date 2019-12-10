package no.fint.model.resource.profilbilde;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ProfilbildeResource implements FintMainObject, FintLinks {
    // Attributes

    /**
     * Permanent identifikator til bildet.
     */
    @NonNull
    private Identifikator systemId;

    /**
     * URL til bildefil.
     */
    @NonNull
    private String filnavn;

    /**
     * Innhold i <pre>Authorization:</pre> header for å hente bilde.
     */
    private String autorisasjon;

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
