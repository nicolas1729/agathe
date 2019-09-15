package fr.ibp.service;

import fr.ibp.service.dto.VersionDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link fr.ibp.domain.Version}.
 */
public interface VersionService {

    /**
     * Save a version.
     *
     * @param versionDTO the entity to save.
     * @return the persisted entity.
     */
    VersionDTO save(VersionDTO versionDTO);

    /**
     * Get all the versions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<VersionDTO> findAll(Pageable pageable);


    /**
     * Get the "id" version.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<VersionDTO> findOne(Long id);

    /**
     * Delete the "id" version.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
