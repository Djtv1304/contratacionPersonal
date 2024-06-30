package com.contratacion.contratacionPersonal.Service;

import com.contratacion.contratacionPersonal.Document.Tutor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import com.contratacion.contratacionPersonal.Repository.TutorRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

@Service
public class TutorService {

    private TutorRepository tutorRepository;

    private MongoTemplate mongoTemplate;

    @Autowired
    public TutorService(TutorRepository tutorRepository, MongoTemplate mongoTemplate) {

        this.tutorRepository = tutorRepository;
        this.mongoTemplate = mongoTemplate;

    }

    public List<Tutor> findAll() {

        return tutorRepository.findAll();

    }

    public List<Tutor> findAllByUsuarioEstudiante(String usuarioEstudiante) {

        return tutorRepository.findAllByUsuarioEstudiante(usuarioEstudiante);

    }

    public List<Tutor> findAllByUsuarioEstudianteAndEstado(String usuarioEstudiante, String estado){

        return tutorRepository.findAllByUsuarioEstudianteAndEstado(usuarioEstudiante, estado);

    }

    public List<Tutor> findAllByIdProfesor(ObjectId idProfesor) {

        return tutorRepository.findAllByIdProfesor(idProfesor);

    }

    public Tutor updateByUsuarioEstudianteAndIdProfesor(String usuarioEstudiante, ObjectId idProfesor, String estado) {
        Query query = new Query();
        query.addCriteria(Criteria.where("usuarioEstudiante").is(usuarioEstudiante).and("idProfesor").is(idProfesor));

        Update update = new Update();
        update.set("estado", estado);

        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Tutor.class);
    }

    public Tutor updateById(ObjectId id, String estado) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));

        Update update = new Update();
        update.set("estado", estado);

        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Tutor.class);
    }


    public <S extends Tutor> S save(S tutoria) {

        return tutorRepository.save(tutoria);

    }
}
