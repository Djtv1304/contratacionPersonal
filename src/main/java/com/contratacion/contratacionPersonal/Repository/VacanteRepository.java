package com.contratacion.contratacionPersonal.Repository;

import com.contratacion.contratacionPersonal.Document.Vacante;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VacanteRepository extends MongoRepository<Vacante,String> {

    List<Vacante> findAll();

    Optional<Vacante> findById(String id);

    <S extends Vacante> S save(S Vacante);

    void deleteById(String id);


}
