package com.contratacion.contratacionPersonal.Service;

import com.contratacion.contratacionPersonal.Document.Aplicacion;
import com.contratacion.contratacionPersonal.Repository.AplicacionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AplicacionService {

    AplicacionRepository aplicacionRepository;

    MongoTemplate mongoTemplate;

    @Autowired
    public AplicacionService(AplicacionRepository aplicacionRepository, MongoTemplate mongoTemplate) {

        this.aplicacionRepository = aplicacionRepository;
        this.mongoTemplate = mongoTemplate;

    }

    public List<Aplicacion> findAll() {

        return aplicacionRepository.findAll();

    }

    public List<Aplicacion> findAllByIdProfesor(ObjectId idProfesor) {

        return aplicacionRepository.findAllByIdProfesor(idProfesor);

    }

    public List<Aplicacion> findAllByEstado(String estado) {

        return aplicacionRepository.findAllByEstado(estado);

    }

    public <S extends Aplicacion> S save(S Aplicacion) {

        return aplicacionRepository.save(Aplicacion);

    }

    public Aplicacion updateById(ObjectId id, String estado) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));

        Update update = new Update();
        update.set("estado", estado);

        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Aplicacion.class);
    }
}
