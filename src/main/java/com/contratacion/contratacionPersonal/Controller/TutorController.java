package com.contratacion.contratacionPersonal.Controller;

import com.contratacion.contratacionPersonal.Document.Tutor;
import com.contratacion.contratacionPersonal.Service.TutorService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contratacionPersonal")
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

    @PutMapping("/tutorias/updateByUsuarioAndProfesor/{usuarioEstudiante}/{idProfesor}/{estado}")
    public Tutor updateByUsuarioEstudianteAndIdProfesor(@PathVariable String usuarioEstudiante, @PathVariable String idProfesor, @PathVariable String estado){

        ObjectId objectIdFromString = new ObjectId(idProfesor);

        return tutorService.updateByUsuarioEstudianteAndIdProfesor(usuarioEstudiante, objectIdFromString, estado);

    }

    @PutMapping("/tutorias/updateTutoriaEstadoById/{idTutoria}/{estado}")
    public Tutor updateTutoriaEstadoById(@PathVariable String idTutoria, @PathVariable String estado) {

        ObjectId objectIdFromString = new ObjectId(idTutoria);

        return tutorService.updateById(objectIdFromString, estado);

    }

    @PostMapping("/tutorias")
    public Tutor saveTutoria(@RequestBody Tutor nuevaTutoria) {

        if ( nuevaTutoria.getId() == null || nuevaTutoria.getId().isEmpty() ) {
            nuevaTutoria.setId(new ObjectId().toHexString());
        }

        return tutorService.save(nuevaTutoria);

    }
}
