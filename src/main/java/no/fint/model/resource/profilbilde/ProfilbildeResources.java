// Built from tag v2.7.0

package no.fint.model.resource.profilbilde;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

import no.fint.model.resource.AbstractCollectionResources;

public class ProfilbildeResources extends AbstractCollectionResources<ProfilbildeResource> {

    @Override
    public TypeReference<List<ProfilbildeResource>> getTypeReference() {
        return new TypeReference<List<ProfilbildeResource>>() {};
    }
}
