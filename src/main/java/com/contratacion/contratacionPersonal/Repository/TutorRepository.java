package com.contratacion.contratacionPersonal.Repository;

import com.contratacion.contratacionPersonal.Document.Tutor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends MongoRepository<Tutor, String> {

    List<Tutor> findAll();

    List<Tutor> findAllByUsuarioEstudiante(String usuarioEstudiante);

    List<Tutor> findAllByUsuarioEstudianteAndEstado(String usuarioEstudiante, String estado);

    List<Tutor> findAllByIdProfesor(ObjectId idProfesor);

    //Tutor updateByUsuarioEstudianteAndIdProfesor(String usuarioEstudiante, ObjectId idProfesor, String estado);

    //Tutor updateById(ObjectId idTutoria);

    <S extends Tutor> S save(S entity);

}
