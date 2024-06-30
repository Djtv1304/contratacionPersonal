package com.contratacion.contratacionPersonal.Repository;

import com.contratacion.contratacionPersonal.Document.Profesor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProfesorRepository extends MongoRepository<Profesor, String> {

    List<Profesor> findAll();

    <S extends Profesor> S save(S Profesor);

    void delete(Profesor profesorParaEliminar);

    void deleteById(String id);

    Profesor findByCorreo(String correo);


}
