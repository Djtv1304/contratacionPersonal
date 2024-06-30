package com.contratacion.contratacionPersonal.Controller;

import com.contratacion.contratacionPersonal.Document.Tutor;
import com.contratacion.contratacionPersonal.Document.Vacante;
import com.contratacion.contratacionPersonal.Service.TutorService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TutorController {

    TutorService tutorService;

    @Autowired
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping("/tutorias/all")
    public List<Tutor> getAllTutorias() {

        return tutorService.findAll();

    }

    @GetMapping("/tutorias/allByUsuario/{usuarioEstudiante}")
    public List<Tutor> getTutoriasByUsuario(@PathVariable String usuarioEstudiante) {

        return tutorService.findAllByUsuarioEstudiante(usuarioEstudiante);

    }

    @GetMapping("/tutorias/allByUsuario/{usuarioEstudiante}/{estado}")
    public List<Tutor> getTutoriasByUsuarioAndEstado(@PathVariable String usuarioEstudiante, @PathVariable String estado) {

        return tutorService.findAllByUsuarioEstudianteAndEstado(usuarioEstudiante, estado);

    }

    @GetMapping("/tutorias/allByProfesor/{idProfesor}")
    public List<Tutor> getTutoriasByIdProfesor(@PathVariable String idProfesor) {

        ObjectId objectIdFromString = new ObjectId(idProfesor);

        return tutorService.findAllByIdProfesor(objectIdFromString);

    }
}
