package com.projectup.beans;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(name = "Observacion")
public class Observacion {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )//auto incrementable
    @Column(name = "IdObser")
    private int idObser;

    @Column(name = "ContObser")
    private String comentario;

    @Column(name = "FechObser")
    private Date fechaComentario;

    // Relación con la entidad User
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "FkIdUsua", referencedColumnName = "IdUsua")
    private User user;

    // Relación con la entidad Avance
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "FkIdAvan", referencedColumnName = "IdAvan")
    private Avance avance;

    // Relación con la entidad Respuesta
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "observacion")
    private List<Respuesta> listResp;

    public int getIdObser() {
        return idObser;
    }

    public void setIdObser(int idObser) {
        this.idObser = idObser;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Avance getAvance() {
        return avance;
    }

    public void setAvance(Avance avance) {
        this.avance = avance;
    }

    public List<Respuesta> getListResp() {
        return listResp;
    }

    public void setListResp(List<Respuesta> listResp) {
        this.listResp = listResp;
    }
}
