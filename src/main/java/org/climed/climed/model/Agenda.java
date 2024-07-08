package org.climed.climed.model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "agenda", schema = "climed")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agenda_id_gen")
    @SequenceGenerator(name = "agenda_id_gen", sequenceName = "agenda_idagenda_seq", allocationSize = 1)
    @Column(name = "idagenda", nullable = false)
    private Integer id;

    @Column(name = "diasemana", nullable = false, length = 3)
    private String diasemana;

    @Column(name = "horainicio", nullable = false)
    private LocalTime horainicio;

    @Column(name = "horafim", nullable = false)
    private LocalTime horafim;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiasemana() {
        return diasemana;
    }

    public void setDiasemana(String diasemana) {
        this.diasemana = diasemana;
    }

    public LocalTime getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(LocalTime horainicio) {
        this.horainicio = horainicio;
    }

    public LocalTime getHorafim() {
        return horafim;
    }

    public void setHorafim(LocalTime horafim) {
        this.horafim = horafim;
    }

}