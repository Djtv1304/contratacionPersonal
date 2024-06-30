package com.contratacion.contratacionPersonal.Document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tutores")
public class Tutor {

    @Id
    private ObjectId id;

    private String usuarioEstudiante;
    private ObjectId idProfesor;
    private String fecha_contratacion;
    private String estado;

    // Getters and Setters

    public String getId() {
        return id != null ? id.toHexString() : null;
    }

    public void setId(String id) {
        this.id = id != null ? new ObjectId(id) : null;
    }

    public String getUsuarioEstudiante() {
        return usuarioEstudiante;
    }

    public void setUsuarioEstudiante(String usuarioEstudiante) {
        this.usuarioEstudiante = usuarioEstudiante;
    }

    public String getIdProfesor() {
        return idProfesor != null ? idProfesor.toHexString() : null;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor != null ? new ObjectId(idProfesor) : null;
    }

    public String getFechaContratacion() {
        return fecha_contratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fecha_contratacion = fechaContratacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
