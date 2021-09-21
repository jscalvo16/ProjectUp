package com.projectup.beans;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(name = "Entregable")
public class Entregable {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )//auto incrementable
    @Column(name = "IdEntre")
    private int idEntre;

    @Column(name = "TituEntre")
    private String tituloEntre;

    @Column(name = "TrimEntre")
    private String trimEntre;

    @Column(name = "DescEntre")
    private String descEntre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FechIniEntre")
    private Date fechaInicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FechFin")
    private Date fechaFin;

    @Column(name = "ArchEntre")
    private String archivoEntre;

    @Column(name = "IdInstruSeg")
    private String InstSeg;

    // Relación con la entidad Fase
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "FkIdFase", referencedColumnName = "IdFase")
    private Fase fase;

    // Relación con la entidad Avance
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entregable")
    private List<Avance> listAvances;

    public int getIdEntre() {
        return idEntre;
    }

    public void setIdEntre(int idEntre) {
        this.idEntre = idEntre;
    }

    public String getTituloEntre() {
        return tituloEntre;
    }

    public void setTituloEntre(String tituloEntre) {
        this.tituloEntre = tituloEntre;
    }

    public String getTrimEntre() {
        return trimEntre;
    }

    public void setTrimEntre(String trimEntre) {
        this.trimEntre = trimEntre;
    }

    public String getDescEntre() {
        return descEntre;
    }

    public void setDescEntre(String descEntre) {
        this.descEntre = descEntre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getArchivoEntre() {
        return archivoEntre;
    }

    public void setArchivoEntre(String archivoEntre) {
        this.archivoEntre = archivoEntre;
    }

    public String getInstSeg() {
        return InstSeg;
    }

    public void setInstSeg(String instSeg) {
        InstSeg = instSeg;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public List<Avance> getListAvances() {
        return listAvances;
    }

    public void setListAvances(List<Avance> listAvances) {
        this.listAvances = listAvances;
    }
}
