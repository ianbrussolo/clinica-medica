package org.climed.climed.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "diagnostico", schema = "climed")
public class Diagnostico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diagnostico_id_gen")
    @SequenceGenerator(name = "diagnostico_id_gen", sequenceName = "diagnostico_iddiagnostico_seq", allocationSize = 1)
    @Column(name = "iddiagnostico", nullable = false)
    private Integer id;

    @Column(name = "tratamentorecomendado", nullable = false, length = Integer.MAX_VALUE)
    private String tratamentorecomendado;

    @Column(name = "remediosreceitados", length = 100)
    private String remediosreceitados;

    @Column(name = "observacoes", length = Integer.MAX_VALUE)
    private String observacoes;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idcon", nullable = false)
    private Consulta idcon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTratamentorecomendado() {
        return tratamentorecomendado;
    }

    public void setTratamentorecomendado(String tratamentorecomendado) {
        this.tratamentorecomendado = tratamentorecomendado;
    }

    public String getRemediosreceitados() {
        return remediosreceitados;
    }

    public void setRemediosreceitados(String remediosreceitados) {
        this.remediosreceitados = remediosreceitados;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Consulta getIdcon() {
        return idcon;
    }

    public void setIdcon(Consulta idcon) {
        this.idcon = idcon;
    }

}