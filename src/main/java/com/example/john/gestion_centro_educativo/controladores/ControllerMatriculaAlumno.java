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

import com.example.john.gestion_centro_educativo.modelos.Alumno;
import com.example.john.gestion_centro_educativo.modelos.MatriculaAlumno;
import com.example.john.gestion_centro_educativo.repos.RepoAlumno;
import com.example.john.gestion_centro_educativo.repos.RepoAsignatura;
import com.example.john.gestion_centro_educativo.repos.RepoMatriculaAlumno;


@Controller
@RequestMapping("/matriculaAlumnos")
public class ControllerMatriculaAlumno {

    @Autowired
    RepoMatriculaAlumno repoMatriculaAlumno;
   
    @Autowired
    RepoAlumno repoAlumno;

    @Autowired
    RepoAsignatura repoAsignatura;

    
    @GetMapping("")
    public String findAll(Model modelo) {
        modelo.addAttribute("matriculas", repoMatriculaAlumno.findAll());
        return "matriculaAlumnos/matriculaAlumnos";
    }


    @GetMapping("/delete/{id}")
    public String deleteAsignatura(@PathVariable("id") @NonNull Integer id) {
        repoMatriculaAlumno.deleteById(id);
        return "redirect:/matriculaAlumnos";
    }

    @GetMapping("/edit/{id}")
    public String editMatricula(Model modelo, @PathVariable("id") @NonNull Integer id) {
        Optional <MatriculaAlumno> oMatricula = repoMatriculaAlumno.findById(id);
        if(oMatricula.isPresent()) {
            modelo.addAttribute( "matricula", oMatricula.get());
            modelo.addAttribute("asignaturas", repoAsignatura.findAll());
            return "matriculaAlumnos/edit";
        } else {
            modelo.addAttribute("mensaje", "la Matricula consultada no existe.");
            return "error";
        }
    }

    @PostMapping("/edit/{id}")
    public String editMatricula( @PathVariable @NonNull Integer id,
    @ModelAttribute("matricula")  MatriculaAlumno matriculaAlumno, Model modelo) {
        Optional <MatriculaAlumno> oMatricula = repoMatriculaAlumno.findById(id);
        if(oMatricula.isPresent()) {
           MatriculaAlumno matricula = oMatricula.get();
           repoMatriculaAlumno.save(matricula);
           return "redirect:/matriculaAlumnos";
       } else {
           modelo.addAttribute("mensaje", "La Matricula consultada no existe.");
           return "error";
       }
   }
    

    @GetMapping("/alumnos/{idAlumno}")
    public String addMatricula(@PathVariable("idAlumno") 
    @NonNull Integer idAlumno, Model modelo) {
        Optional <Alumno> oAlumno = repoAlumno.findById(idAlumno);
        if(oAlumno.isPresent()) {
            modelo.addAttribute("alumno", oAlumno.get());
            modelo.addAttribute("alumnos", repoAlumno.findAll());
            modelo.addAttribute("asignatura", new MatriculaAlumno());
            modelo.addAttribute("asignaturas", repoAsignatura.findAll());
            return "matriculaAlumnos/alumnos";
        } else {
            modelo.addAttribute("mensaje", "El Alumno consultado no existe.");
            return "error";
        }
        
    }

    @PostMapping("/alumnos/{idAlumno}")
     public String addMatricula( @PathVariable @NonNull Integer idAlumno, 
     @ModelAttribute("asignatura") MatriculaAlumno matriculaAlumno, Model modelo) {
        Optional<Alumno> oAlumno = repoAlumno.findById(idAlumno);
        if (oAlumno.isPresent()) {
            Alumno alumno = oAlumno.get();
            matriculaAlumno.setAlumno(alumno);
            repoMatriculaAlumno.save(matriculaAlumno);
            return "redirect:/matriculaAlumnos";
        } else {
            modelo.addAttribute("mensaje", "El Alumno consultado no existe.");
            return "error";
        }
    }

}
