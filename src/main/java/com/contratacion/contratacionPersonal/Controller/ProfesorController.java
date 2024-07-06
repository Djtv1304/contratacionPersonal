package com.contratacion.contratacionPersonal.Controller;

import com.contratacion.contratacionPersonal.Document.Profesor;
import com.contratacion.contratacionPersonal.Service.ProfesorService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contratacionPersonal")
public class ProfesorController {

    ProfesorService profesorService;

    @Autowired
    public ProfesorController(ProfesorService profesorService) {

        this.profesorService = profesorService;

    }

    @GetMapping("/profesores/all")
    public List<Profesor> getAllProfesores() {

        return profesorService.findAll();

    }

    @PostMapping("/profesores")
    public Profesor saveProfesor(@RequestBody Profesor profesorNuevo) {

        if ( profesorNuevo.getId() == null || profesorNuevo.getId().isEmpty() ) {
            profesorNuevo.setId(new ObjectId().toHexString());
        }

        return profesorService.save(profesorNuevo);

    }

    @DeleteMapping("/profesores/deleteByProfesor")
    public String deleteProfesor(@RequestBody Profesor profesorParaEliminar) {

        profesorService.delete(profesorParaEliminar);

        return "Verificar si se ha eliminado correctamente";

    }

    @DeleteMapping("/profesores/deleteByProfesorId/{profesorId}")
    public String deleteProfesorById(@PathVariable String profesorId) {

        profesorService.deleteById(profesorId);

        return "Verificar si se ha eliminado correctamente el profesor por ID";

    }

    @PutMapping("/profesores/updateEstadoById/{idProfesor}/{estadoNuevo}")
    public Profesor updateEstadoProfesorById(@PathVariable String idProfesor, @PathVariable String estadoNuevo) {

        return profesorService.updateEstado(idProfesor, estadoNuevo);

    }

    @PutMapping("/profesores/updateEsTutorById/{idProfesor}")
    public Profesor updateEsTutorProfesorById(@PathVariable String idProfesor, @RequestBody Boolean esTutor) {

        return profesorService.updateEsTutor(idProfesor, esTutor);

    }

    @PutMapping("/profesores/updateEstadoByCorreo")
    public Profesor updateEstadoProfesorByCorreo(@RequestBody Map<String, String> body) {
        String correoProfesor = body.get("correoProfesor");
        String estadoNuevo = body.get("estadoNuevo");
        return profesorService.updateEstadoByCorreo(correoProfesor, estadoNuevo);
    }

    @PutMapping("/profesores/updateEsTutorByCorreo")
    public Profesor updateEsTutorProfesorByCorreo(@RequestBody Map<String, Object> body) {
        String correoProfesor = (String) body.get("correoProfesor");
        Boolean esTutor = (Boolean) body.get("esTutor");
        return profesorService.updateEsTutorByCorreo(correoProfesor, esTutor);
    }


}
