package org.climed.climed.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "exerceesp", schema = "climed")
public class Exerceesp {
    @EmbeddedId
    private ExerceespId id;

    @MapsId("idesp")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idesp", nullable = false)
    private Especialidade idesp;

    public ExerceespId getId() {
        return id;
    }

    public void setId(ExerceespId id) {
        this.id = id;
    }

    public Especialidade getIdesp() {
        return idesp;
    }

    public void setIdesp(Especialidade idesp) {
        this.idesp = idesp;
    }

}