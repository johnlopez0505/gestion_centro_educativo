package com.example.john.gestion_centro_educativo.controladores;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.john.gestion_centro_educativo.repos.RepoAlumno;
import com.example.john.gestion_centro_educativo.repos.RepoAsignatura;
import com.example.john.gestion_centro_educativo.repos.RepoMatriculaAlumno;
import com.example.john.gestion_centro_educativo.repos.RepoUser;

@Controller
@RequestMapping("/detalleAlumno")
public class ControllerDetalleAlumno {
     @Autowired
    RepoMatriculaAlumno repoMatriculaAlumno;
   
    @Autowired
    RepoAlumno repoAlumno;

    @Autowired
    RepoAsignatura repoAsignatura;

    @Autowired
    RepoUser repoUser;

    
    @GetMapping("")
    public String findAll(Model modelo) {
        // List<MatriculaAlumno> oMatricula = repoMatriculaAlumno.findAll();
        //modelo.addAttribute("alumno", repoAlumno.finByUsuario("Juan"));
        // modelo.addAttribute("matricula", repoMatriculaAlumno.findAll());
        return "/detalleAlumno/detalleAlumno";
    }


  
}
