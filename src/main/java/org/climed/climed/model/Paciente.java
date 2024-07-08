package org.climed.climed.model;

import jakarta.persistence.*;

@Entity
@Table(name = "paciente", schema = "climed")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_id_gen")
    @SequenceGenerator(name = "paciente_id_gen", sequenceName = "paciente_idpac_seq", allocationSize = 1)
    @Column(name = "idpac", nullable = false)
    private Integer id;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "nomep", nullable = false, length = 20)
    private String nomep;

    @Column(name = "telefonepac", nullable = false, length = 15)
    private String telefonepac;

    @Column(name = "endereco", length = 100)
    private String endereco;

    @Column(name = "idade", nullable = false)
    private Integer idade;

    @Column(name = "sexo", nullable = false, length = 1)
    private String sexo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomep() {
        return nomep;
    }

    public void setNomep(String nomep) {
        this.nomep = nomep;
    }

    public String getTelefonepac() {
        return telefonepac;
    }

    public void setTelefonepac(String telefonepac) {
        this.telefonepac = telefonepac;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}