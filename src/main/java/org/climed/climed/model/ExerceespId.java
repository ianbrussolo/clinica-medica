package org.climed.climed.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class ExerceespId implements java.io.Serializable {
    private static final long serialVersionUID = -6744280059018077519L;
    @Column(name = "crm", nullable = false, length = 5)
    private String crm;

    @Column(name = "idesp", nullable = false)
    private Integer idesp;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Integer getIdesp() {
        return idesp;
    }

    public void setIdesp(Integer idesp) {
        this.idesp = idesp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ExerceespId entity = (ExerceespId) o;
        return Objects.equals(this.idesp, entity.idesp) &&
                Objects.equals(this.crm, entity.crm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idesp, crm);
    }

}