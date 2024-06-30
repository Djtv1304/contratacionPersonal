package com.contratacion.contratacionPersonal.Repository;

import com.contratacion.contratacionPersonal.Document.Tutor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;


public interface TutorRepository extends MongoRepository<Tutor, String> {

    List<Tutor> findAll();

    List<Tutor> findAllByUsuarioEstudiante(String usuarioEstudiante);

    List<Tutor> findAllByUsuarioEstudianteAndEstado(String usuarioEstudiante, String estado);

    List<Tutor> findAllByIdProfesor(ObjectId idProfesor);

}
