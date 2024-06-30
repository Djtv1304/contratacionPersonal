package com.contratacion.contratacionPersonal.Repository;

import com.contratacion.contratacionPersonal.Document.Aplicacion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AplicacionRepository extends MongoRepository<Aplicacion, String> {

    List<Aplicacion> findAll();

    List<Aplicacion> findAllByIdProfesor(ObjectId idProfesor);

    List<Aplicacion> findAllByEstado(String estado);

    <S extends Aplicacion> S save(S Aplicacion);


}
