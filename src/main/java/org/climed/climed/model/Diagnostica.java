package org.climed.climed.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "diagnostica", schema = "climed")
public class Diagnostica {
    @SequenceGenerator(name = "diagnostica_id_gen", sequenceName = "consulta_idcon_seq", allocationSize = 1)
    @EmbeddedId
    private DiagnosticaId id;

    public DiagnosticaId getId() {
        return id;
    }

    public void setId(DiagnosticaId id) {
        this.id = id;
    }

}