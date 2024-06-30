package com.contratacion.contratacionPersonal.Service;

import com.contratacion.contratacionPersonal.Document.Vacante;
import com.contratacion.contratacionPersonal.Repository.VacanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacanteService{

    private VacanteRepository vacanteRepository;

    @Autowired
    public VacanteService(VacanteRepository vacanteRepository) {
        this.vacanteRepository = vacanteRepository;
    }


    public List<Vacante> findAll() {
        return vacanteRepository.findAll();
    }

    public Optional<Vacante> findById(String id) {
        return vacanteRepository.findById(id);
    }

    public <S extends Vacante> S save(S vacante) {
        return vacanteRepository.save(vacante);
    }

    public String deleteById(String id) {

        vacanteRepository.deleteById(id);

        return "Supongo que se eliminó correctamente";
    }
}
