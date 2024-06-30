package com.contratacion.contratacionPersonal.Service;

import com.contratacion.contratacionPersonal.Document.Profesor;
import com.contratacion.contratacionPersonal.Repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.FindAndModifyOptions;

import java.util.List;

@Service
public class ProfesorService {

    ProfesorRepository profesorRepository;

    MongoTemplate mongoTemplate;

    @Autowired
    public ProfesorService(ProfesorRepository profesorRepository, MongoTemplate mongoTemplate) {

        this.profesorRepository = profesorRepository;
        this.mongoTemplate = mongoTemplate;

    }

    public List<Profesor> findAll() {

        return profesorRepository.findAll();

    }

    /*  */

    /**
     *
     * @param Profesor
     * @return Este método creará un nuevo documento si el objeto proporcionado no tiene un ID,
     *           o reemplazará completamente el documento existente con el mismo ID si ya existe.
     *           Retorna un objeto de Profesor.
     * @param <S>
     */
    public <S extends Profesor> S save(S Profesor) {
        // Comprobar si ya existe un profesor con el mismo correo
        Profesor existingProfesor = profesorRepository.findByCorreo(Profesor.getCorreo());
        if (existingProfesor != null) {
            // Lanzar una excepción o devolver un error
            throw new RuntimeException("Ya existe un profesor con el correo: " + Profesor.getCorreo());
        }

        // Si no existe, guardar el nuevo profesor
        return profesorRepository.save(Profesor);
    }

    public void delete(Profesor profesorParaEliminar) {

        profesorRepository.delete(profesorParaEliminar);

    }

    public void deleteById(String id) {

        profesorRepository.deleteById(id);

    }

    public Profesor updateEstado(String id, String estado) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(new ObjectId(id)));

        Update update = new Update();
        update.set("estado", estado);

        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Profesor.class);
    }

    public Profesor updateEsTutor(String id, boolean esTutor) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(new ObjectId(id)));

        Update update = new Update();
        update.set("esTutor", esTutor);

        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Profesor.class);
    }

    public Profesor updateEstadoByCorreo(String correo, String estado) {
        Query query = new Query();
        query.addCriteria(Criteria.where("correo").is(correo));

        Update update = new Update();
        update.set("estado", estado);

        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Profesor.class);
    }

    public Profesor updateEsTutorByCorreo(String correo, boolean esTutor) {
        Query query = new Query();
        query.addCriteria(Criteria.where("correo").is(correo));

        Update update = new Update();
        update.set("esTutor", esTutor);

        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Profesor.class);
    }

}
