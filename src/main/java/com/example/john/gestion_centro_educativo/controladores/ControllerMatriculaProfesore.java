package com.example.john.gestion_centro_educativo.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.john.gestion_centro_educativo.modelos.MatriculaProfesor;
import com.example.john.gestion_centro_educativo.modelos.Profesor;
import com.example.john.gestion_centro_educativo.repos.RepoAsignatura;
import com.example.john.gestion_centro_educativo.repos.RepoMatriculaProfesor;
import com.example.john.gestion_centro_educativo.repos.RepoProfesor;

@Controller
@RequestMapping("/matriculaProfesores")
public class ControllerMatriculaProfesore {
    @Autowired
    RepoMatriculaProfesor repoMatriculaProfesor;
   
    @Autowired
    RepoProfesor repoProfesor;

    @Autowired
    RepoAsignatura repoAsignatura;

    
    @GetMapping("")
    public String findAll(Model modelo) {
        modelo.addAttribute("matriculas", repoMatriculaProfesor.findAll());
        return "matriculaProfesores/matriculaProfesores";
    }


    @GetMapping("/delete/{id}")
    public String deleteAsignatura(@PathVariable("id") @NonNull Integer id) {
        repoMatriculaProfesor.deleteById(id);
        return "redirect:/matriculaProfesores";
    }

    @GetMapping("/edit/{id}")
    public String editMatricula(Model modelo, @PathVariable("id") @NonNull Integer id) {
        Optional <MatriculaProfesor> oMatricula = repoMatriculaProfesor.findById(id);
        if(oMatricula.isPresent()) {
            modelo.addAttribute( "matricula", oMatricula.get());
            modelo.addAttribute("asignaturas", repoAsignatura.findAll());
            return "matriculaProfesores/edit";
        } else {
            modelo.addAttribute("mensaje", "la Matricula consultada no existe.");
            return "error";
        }
    }

    @PostMapping("/edit/{id}")
    public String editMatricula( @PathVariable @NonNull Integer id,
    @ModelAttribute("matricula")  MatriculaProfesor matriculaAlumno, Model modelo) {
        Optional <MatriculaProfesor> oMatricula = repoMatriculaProfesor.findById(id);
        if(oMatricula.isPresent()) {
           MatriculaProfesor matricula = oMatricula.get();
           repoMatriculaProfesor.save(matricula);
           return "redirect:/matriculaProfesores";
       } else {
           modelo.addAttribute("mensaje", "La Matricula consultada no existe.");
           return "error";
       }
   }
    

    @GetMapping("/profesores/{idProfesor}")
    public String addMatricula(@PathVariable("idProfesor") 
    @NonNull Integer idProfesor, Model modelo) {
        Optional <Profesor> oProfesor = repoProfesor.findById(idProfesor);
        if(oProfesor.isPresent()) {
            modelo.addAttribute("profesor", oProfesor.get());
            modelo.addAttribute("profesores", repoProfesor.findAll());
            modelo.addAttribute("asignatura", new MatriculaProfesor());
            modelo.addAttribute("asignaturas", repoAsignatura.findAll());
            return "matriculaProfesores/profesores";
        } else {
            modelo.addAttribute("mensaje", "El Profesor consultado no existe.");
            return "error";
        }
        
    }

    @PostMapping("/profesores/{idProfesor}")
     public String addMatricula( @PathVariable @NonNull Integer idProfesor, 
     @ModelAttribute("asignatura") MatriculaProfesor matriculaProfesor, Model modelo) {
        Optional<Profesor> oProfesor = repoProfesor.findById(idProfesor);
        if (oProfesor.isPresent()) {
            Profesor profesor = oProfesor.get();
            matriculaProfesor.setProfesor(profesor);
            repoMatriculaProfesor.save(matriculaProfesor);
            return "redirect:/matriculaProfesores";
        } else {
            modelo.addAttribute("mensaje", "El Profesor consultado no existe.");
            return "error";
        }
    }

}
