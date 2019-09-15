package fr.ibp.service.mapper;

import fr.ibp.domain.*;
import fr.ibp.service.dto.VersionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Version} and its DTO {@link VersionDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VersionMapper extends EntityMapper<VersionDTO, Version> {



    default Version fromId(Long id) {
        if (id == null) {
            return null;
        }
        Version version = new Version();
        version.setId(id);
        return version;
    }
}
