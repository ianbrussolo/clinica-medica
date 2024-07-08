package org.climed.climed.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "consulta", schema = "climed")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consulta_id_gen")
    @SequenceGenerator(name = "consulta_id_gen", sequenceName = "consulta_idcon_seq", allocationSize = 1)
    @Column(name = "idcon", nullable = false)
    private Integer id;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "horainiccon")
    private LocalTime horainiccon;

    @Column(name = "horafimcon")
    private LocalTime horafimcon;

    @Column(name = "pagou", nullable = false)
    private Boolean pagou = false;

    @Column(name = "valorpago")
    private Integer valorpago;

    @Column(name = "formapagamento", length = 8)
    private String formapagamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorainiccon() {
        return horainiccon;
    }

    public void setHorainiccon(LocalTime horainiccon) {
        this.horainiccon = horainiccon;
    }

    public LocalTime getHorafimcon() {
        return horafimcon;
    }

    public void setHorafimcon(LocalTime horafimcon) {
        this.horafimcon = horafimcon;
    }

    public Boolean getPagou() {
        return pagou;
    }

    public void setPagou(Boolean pagou) {
        this.pagou = pagou;
    }

    public Integer getValorpago() {
        return valorpago;
    }

    public void setValorpago(Integer valorpago) {
        this.valorpago = valorpago;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

}