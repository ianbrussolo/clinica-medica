package org.climed.climed.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class DiagnosticaId implements java.io.Serializable {
    private static final long serialVersionUID = 1717558243543193185L;
    @Column(name = "iddiagnostico", nullable = false)
    private Integer iddiagnostico;

    @Column(name = "iddoenca", nullable = false)
    private Integer iddoenca;

    public Integer getIddiagnostico() {
        return iddiagnostico;
    }

    public void setIddiagnostico(Integer iddiagnostico) {
        this.iddiagnostico = iddiagnostico;
    }

    public Integer getIddoenca() {
        return iddoenca;
    }

    public void setIddoenca(Integer iddoenca) {
        this.iddoenca = iddoenca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DiagnosticaId entity = (DiagnosticaId) o;
        return Objects.equals(this.iddoenca, entity.iddoenca) &&
                Objects.equals(this.iddiagnostico, entity.iddiagnostico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddoenca, iddiagnostico);
    }

}