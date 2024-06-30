package com.contratacion.contratacionPersonal.Document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Aplicaciones")
public class Aplicacion {

    @Id
    private ObjectId id;
    private ObjectId idProfesor;
    private ObjectId idVacante;
    private String fechaAplicacion;
    private String estado;

    // Getters and Setters

    public String getId() {
        return id != null ? id.toHexString() : null;
    }

    public void setId(String id) {
        this.id = id != null ? new ObjectId(id) : null;
    }

    public String getIdProfesor() {
        return idProfesor != null ? idProfesor.toHexString() : null;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor != null ? new ObjectId(idProfesor) : null;
    }

    public String getIdVacante() {
        return idVacante != null ? idVacante.toHexString() : null;
    }

    public void setIdVacante(String idVacante) {
        this.idVacante = idVacante != null ? new ObjectId(idVacante) : null;
    }

    public String getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(String fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

