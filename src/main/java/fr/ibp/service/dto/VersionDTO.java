package fr.ibp.service.dto;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link fr.ibp.domain.Version} entity.
 */
public class VersionDTO implements Serializable {

    private Long id;

    private String nom;

    private LocalDate date;

    private String versionCommunautaire;

    private String commentaire;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getVersionCommunautaire() {
        return versionCommunautaire;
    }

    public void setVersionCommunautaire(String versionCommunautaire) {
        this.versionCommunautaire = versionCommunautaire;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VersionDTO versionDTO = (VersionDTO) o;
        if (versionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), versionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VersionDTO{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", date='" + getDate() + "'" +
            ", versionCommunautaire='" + getVersionCommunautaire() + "'" +
            ", commentaire='" + getCommentaire() + "'" +
            "}";
    }
}
