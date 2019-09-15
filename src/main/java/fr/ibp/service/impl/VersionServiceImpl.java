package fr.ibp.service.impl;

import fr.ibp.service.VersionService;
import fr.ibp.domain.Version;
import fr.ibp.repository.VersionRepository;
import fr.ibp.service.dto.VersionDTO;
import fr.ibp.service.mapper.VersionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Version}.
 */
@Service
@Transactional
public class VersionServiceImpl implements VersionService {

    private final Logger log = LoggerFactory.getLogger(VersionServiceImpl.class);

    private final VersionRepository versionRepository;

    private final VersionMapper versionMapper;

    public VersionServiceImpl(VersionRepository versionRepository, VersionMapper versionMapper) {
        this.versionRepository = versionRepository;
        this.versionMapper = versionMapper;
    }

    /**
     * Save a version.
     *
     * @param versionDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public VersionDTO save(VersionDTO versionDTO) {
        log.debug("Request to save Version : {}", versionDTO);
        Version version = versionMapper.toEntity(versionDTO);
        version = versionRepository.save(version);
        return versionMapper.toDto(version);
    }

    /**
     * Get all the versions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<VersionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Versions");
        return versionRepository.findAll(pageable)
            .map(versionMapper::toDto);
    }


    /**
     * Get one version by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<VersionDTO> findOne(Long id) {
        log.debug("Request to get Version : {}", id);
        return versionRepository.findById(id)
            .map(versionMapper::toDto);
    }

    /**
     * Delete the version by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Version : {}", id);
        versionRepository.deleteById(id);
    }
}
