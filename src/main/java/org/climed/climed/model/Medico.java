package org.climed.climed.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medico", schema = "climed")
public class Medico {
    @Id
    @Column(name = "crm", nullable = false, length = 5)
    private String crm;

    @Column(name = "nomem", nullable = false, length = 20)
    private String nomem;

    @Column(name = "telefonem", nullable = false, length = 15)
    private String telefonem;

    @Column(name = "percentual", nullable = false)
    private Integer percentual;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNomem() {
        return nomem;
    }

    public void setNomem(String nomem) {
        this.nomem = nomem;
    }

    public String getTelefonem() {
        return telefonem;
    }

    public void setTelefonem(String telefonem) {
        this.telefonem = telefonem;
    }

    public Integer getPercentual() {
        return percentual;
    }

    public void setPercentual(Integer percentual) {
        this.percentual = percentual;
    }

}