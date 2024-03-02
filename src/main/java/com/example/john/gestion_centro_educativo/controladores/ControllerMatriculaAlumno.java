package com.example.john.gestion_centro_educativo.controladores;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        List<Object[]> alumnosMatriculados = repoMatriculaAlumno.obtenerAlumnosMatriculados();
        modelo.addAttribute("alumnosMatriculados", alumnosMatriculados);
        return "matriculaAlumnos/matriculaAlumnos";
    }



}
