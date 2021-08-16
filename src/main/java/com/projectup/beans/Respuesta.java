package com.projectup.beans;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("ALL")
@Entity
@Table(name = "Respuesta")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdResp")
    private int idResp;

    @Column(name = "ContResp")
    private String comentarioR;

    @Column(name = "FechResp")
    private Date fechaResp;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "FkIdObser", referencedColumnName = "IdObser")
    private Observacion observacion;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name =  "FkIdUsua", referencedColumnName = "IdUsua")
    private User userR;

    public int getIdResp() {
        return idResp;
    }

    public void setIdResp(int idResp) {
        this.idResp = idResp;
    }

    public String getComentarioR() {
        return comentarioR;
    }

    public void setComentarioR(String comentarioR) {
        this.comentarioR = comentarioR;
    }

    public Date getFechaResp() {
        return fechaResp;
    }

    public void setFechaResp(Date fechaResp) {
        this.fechaResp = fechaResp;
    }

    public Observacion getObservacion() {
        return observacion;
    }

    public void setObservacion(Observacion observacion) {
        this.observacion = observacion;
    }

    public User getUserR() {
        return userR;
    }

    public void setUserR(User userR) {
        this.userR = userR;
    }
}
