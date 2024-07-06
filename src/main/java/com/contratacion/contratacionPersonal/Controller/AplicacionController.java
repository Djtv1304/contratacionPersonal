package com.contratacion.contratacionPersonal.Controller;

import com.contratacion.contratacionPersonal.Document.Aplicacion;
import com.contratacion.contratacionPersonal.Service.AplicacionService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contratacionPersonal")
public class AplicacionController {

    AplicacionService aplicacionService;

    @Autowired
    public AplicacionController(AplicacionService aplicacionService) {

        this.aplicacionService = aplicacionService;

    }

    @GetMapping("/aplicaciones/all")
    public List<Aplicacion> getAllAplicaciones() {

        return aplicacionService.findAll();

    }

    @GetMapping("/aplicaciones/{idProfesor}")
    public List<Aplicacion> getAllByIdProfesor(@PathVariable String idProfesor) {

        ObjectId objectIdFromString = new ObjectId(idProfesor);

        return aplicacionService.findAllByIdProfesor(objectIdFromString);

    }

    @GetMapping("/aplicaciones/allByEstado/{estado}")
    public List<Aplicacion> getAllByEstado(@PathVariable String estado) {

        return aplicacionService.findAllByEstado(estado);

    }

    @PostMapping("/aplicaciones")
    public Aplicacion saveAplicacion(@RequestBody Aplicacion nuevaAplicacion) {

        if ( nuevaAplicacion.getId() == null || nuevaAplicacion.getId().isEmpty() ) {
            nuevaAplicacion.setId(new ObjectId().toHexString());
        }

        return aplicacionService.save(nuevaAplicacion);

    }

    @PutMapping("/aplicaciones/updateEstadoAplicacion/{idAplicacion}/{nuevoEstado}")
    public Aplicacion updateEstadoAplicacionById(@PathVariable String idAplicacion, @PathVariable String nuevoEstado) {

        ObjectId objectIdFromString = new ObjectId(idAplicacion);

        return aplicacionService.updateById(objectIdFromString,nuevoEstado);

    }
}
