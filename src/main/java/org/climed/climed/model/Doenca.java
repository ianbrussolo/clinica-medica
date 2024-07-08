package org.climed.climed.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doenca", schema = "climed")
public class Doenca {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doenca_id_gen")
    @SequenceGenerator(name = "doenca_id_gen", sequenceName = "doenca_iddoenca_seq", allocationSize = 1)
    @Column(name = "iddoenca", nullable = false)
    private Integer id;

    @Column(name = "nomed", nullable = false, length = 20)
    private String nomed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomed() {
        return nomed;
    }

    public void setNomed(String nomed) {
        this.nomed = nomed;
    }

}