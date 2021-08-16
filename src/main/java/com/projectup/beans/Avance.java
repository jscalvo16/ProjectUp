package com.projectup.beans;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(name = "Avance")
public class Avance {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )//auto incrementable
    @Column(name = "IdAvan")
    private int idAvance;

    @Column(name = "DescAvan")
    private String descAvance;

    @Column(name = "FechAvan")
    private Date fechaCarga;

    // Relación con la entidad Entregable
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "FkIdEntre", referencedColumnName = "IdEntre")
    private Entregable entregable;

    // Relación con la entidad Grupo
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "FkIdGrupo", referencedColumnName = "IdGrupo")
    private Grupo grupo;

    // Relación con la entidad Observacion
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avance")
    private List<Observacion> listObser;

    public int getIdAvance() {
        return idAvance;
    }

    public void setIdAvance(int idAvance) {
        this.idAvance = idAvance;
    }

    public String getDescAvance() {
        return descAvance;
    }

    public void setDescAvance(String descAvance) {
        this.descAvance = descAvance;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Entregable getEntregable() {
        return entregable;
    }

    public void setEntregable(Entregable entregable) {
        this.entregable = entregable;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Observacion> getListObser() {
        return listObser;
    }

    public void setListObser(List<Observacion> listObser) {
        this.listObser = listObser;
    }
}
