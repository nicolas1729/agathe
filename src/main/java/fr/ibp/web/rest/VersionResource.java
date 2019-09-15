package fr.ibp.web.rest;

import fr.ibp.service.VersionService;
import fr.ibp.web.rest.errors.BadRequestAlertException;
import fr.ibp.service.dto.VersionDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link fr.ibp.domain.Version}.
 */
@RestController
@RequestMapping("/api")
public class VersionResource {

    private final Logger log = LoggerFactory.getLogger(VersionResource.class);

    private static final String ENTITY_NAME = "version";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final VersionService versionService;

    public VersionResource(VersionService versionService) {
        this.versionService = versionService;
    }

    /**
     * {@code POST  /versions} : Create a new version.
     *
     * @param versionDTO the versionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new versionDTO, or with status {@code 400 (Bad Request)} if the version has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/versions")
    public ResponseEntity<VersionDTO> createVersion(@RequestBody VersionDTO versionDTO) throws URISyntaxException {
        log.debug("REST request to save Version : {}", versionDTO);
        if (versionDTO.getId() != null) {
            throw new BadRequestAlertException("A new version cannot already have an ID", ENTITY_NAME, "idexists");
        }
        VersionDTO result = versionService.save(versionDTO);
        return ResponseEntity.created(new URI("/api/versions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /versions} : Updates an existing version.
     *
     * @param versionDTO the versionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated versionDTO,
     * or with status {@code 400 (Bad Request)} if the versionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the versionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/versions")
    public ResponseEntity<VersionDTO> updateVersion(@RequestBody VersionDTO versionDTO) throws URISyntaxException {
        log.debug("REST request to update Version : {}", versionDTO);
        if (versionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        VersionDTO result = versionService.save(versionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, versionDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /versions} : get all the versions.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of versions in body.
     */
    @GetMapping("/versions")
    public ResponseEntity<List<VersionDTO>> getAllVersions(Pageable pageable) {
        log.debug("REST request to get a page of Versions");
        Page<VersionDTO> page = versionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /versions/:id} : get the "id" version.
     *
     * @param id the id of the versionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the versionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/versions/{id}")
    public ResponseEntity<VersionDTO> getVersion(@PathVariable Long id) {
        log.debug("REST request to get Version : {}", id);
        Optional<VersionDTO> versionDTO = versionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(versionDTO);
    }

    /**
     * {@code DELETE  /versions/:id} : delete the "id" version.
     *
     * @param id the id of the versionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/versions/{id}")
    public ResponseEntity<Void> deleteVersion(@PathVariable Long id) {
        log.debug("REST request to delete Version : {}", id);
        versionService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
