// Built from tag v2.7.0

package no.fint.model.resource.avatar;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

import no.fint.model.resource.AbstractCollectionResources;

public class AvatarResources extends AbstractCollectionResources<AvatarResource> {

    @Override
    public TypeReference<List<AvatarResource>> getTypeReference() {
        return new TypeReference<List<AvatarResource>>() {};
    }
}
