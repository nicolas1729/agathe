package fr.ibp.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Version.
 */
@Entity
@Table(name = "version")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Version implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "version_communautaire")
    private String versionCommunautaire;

    @Column(name = "commentaire")
    private String commentaire;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Version nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDate() {
        return date;
    }

    public Version date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getVersionCommunautaire() {
        return versionCommunautaire;
    }

    public Version versionCommunautaire(String versionCommunautaire) {
        this.versionCommunautaire = versionCommunautaire;
        return this;
    }

    public void setVersionCommunautaire(String versionCommunautaire) {
        this.versionCommunautaire = versionCommunautaire;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public Version commentaire(String commentaire) {
        this.commentaire = commentaire;
        return this;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Version)) {
            return false;
        }
        return id != null && id.equals(((Version) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Version{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", date='" + getDate() + "'" +
            ", versionCommunautaire='" + getVersionCommunautaire() + "'" +
            ", commentaire='" + getCommentaire() + "'" +
            "}";
    }
}
