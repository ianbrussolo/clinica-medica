package org.climed.climed.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "especialidade", schema = "climed")
public class Especialidade {
    @Id
    @Column(name = "idesp", nullable = false)
    private Integer id;

    @Column(name = "nomee", nullable = false, length = 20)
    private String nomee;

    @Column(name = "indice", nullable = false)
    private Integer indice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomee() {
        return nomee;
    }

    public void setNomee(String nomee) {
        this.nomee = nomee;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

}