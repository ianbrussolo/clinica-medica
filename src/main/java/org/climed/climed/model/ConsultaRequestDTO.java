package org.climed.climed.model;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultaRequestDTO {

    private Integer id;

    @NotBlank
    private String crm;

    private Integer idEsp;

    @NotBlank
    private String cpf;

    @NotNull
    private LocalDate data;

    @NotNull
    private String horaInicCon;

    @NotNull
    private String horaFimCon;

    private boolean pagou;

    private Integer valorPago;

    private String formaPagamento;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Integer getIdEsp() {
        return idEsp;
    }

    public void setIdEsp(Integer idEsp) {
        this.idEsp = idEsp;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getHoraInicCon() {
        return horaInicCon;
    }

    public void setHoraInicCon(String horaInicCon) {
        this.horaInicCon = horaInicCon;
    }

    public String getHoraFimCon() {
        return horaFimCon;
    }

    public void setHoraFimCon(String horaFimCon) {
        this.horaFimCon = horaFimCon;
    }

    public boolean isPagou() {
        return pagou;
    }

    public void setPagou(boolean pagou) {
        this.pagou = pagou;
    }

    public Integer getValorPago() {
        return valorPago;
    }

    public void setValorPago(Integer valorPago) {
        this.valorPago = valorPago;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
