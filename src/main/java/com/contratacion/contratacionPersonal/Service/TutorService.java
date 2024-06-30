package com.contratacion.contratacionPersonal.Service;

import com.contratacion.contratacionPersonal.Document.Tutor;
import com.contratacion.contratacionPersonal.Repository.TutorRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    TutorRepository tutorRepository;

    @Autowired
    public TutorService(TutorRepository tutorRepository) {

        this.tutorRepository = tutorRepository;

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
}
