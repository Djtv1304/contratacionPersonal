package com.contratacion.contratacionPersonal.Controller;

import com.contratacion.contratacionPersonal.Document.Vacante;
import com.contratacion.contratacionPersonal.Service.VacanteService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VacanteController {

    VacanteService vacanteService;

    @Autowired
    public VacanteController(VacanteService vacanteService) {
        this.vacanteService = vacanteService;
    }

    @GetMapping("/vacante/all")
    public List<Vacante> getAllVacantes() {

        return vacanteService.findAll();

    }

    @GetMapping("/vacante/{vacanteId}")
    public Optional<Vacante> getVacanteById(@PathVariable String vacanteId) {

        return vacanteService.findById(vacanteId);

    }

    @PostMapping("/vacante")
    public Vacante saveVacante(@RequestBody Vacante vacanteNueva) {

        if ( vacanteNueva.getId() == null || vacanteNueva.getId().isEmpty() ) {
            vacanteNueva.setId(new ObjectId().toHexString());
        }

        return vacanteService.save(vacanteNueva);

    }
    
    @DeleteMapping("/vacante/{vacanteIdToDelete}")
    public String deleteVacanteById(@PathVariable String vacanteIdToDelete) {
        
        return vacanteService.deleteById(vacanteIdToDelete);
        
    }
}
