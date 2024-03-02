package com.example.john.gestion_centro_educativo.controladores;

import java.util.List;
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

import com.example.john.gestion_centro_educativo.modelos.Profesor;
import com.example.john.gestion_centro_educativo.repos.RepoProfesor;

@Controller
@RequestMapping("/profesores")
public class ControllerProfesor {
    @Autowired
    private RepoProfesor repoProfesor;

   
    @GetMapping(path = "/")
    public String findAll(Model modelo) {
        List<Profesor> lProfesores = repoProfesor.findAll();
        modelo.addAttribute("profesores", lProfesores);
        return "profesores/profesores";
    }

    @GetMapping("")
    public String findAll2(Model modelo) {
        return findAll(modelo);
    }

    @GetMapping("/add")
    public String addProfesor(Model modelo) {
        modelo.addAttribute("profesores", new Profesor());
        return "profesores/add";
    }

    @PostMapping("/add")
    public String addProfesor(@ModelAttribute("profesor") @NonNull Profesor profesor) {
        repoProfesor.save(profesor);
        return "redirect:/profesores";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(Model modelo, @PathVariable("id") @NonNull Integer id) {
        Optional<Profesor> oProfesor = repoProfesor.findById(id);
        if (oProfesor.isPresent())
            modelo.addAttribute("profesor", oProfesor.get());
        else {
            modelo.addAttribute(
                "mensaje", "El Profesor consultado no existe.");
            return "error";
        }
        return "profesores/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteProfesor(@PathVariable("id") @NonNull Integer id) {
        repoProfesor.deleteById(id);
        return "redirect:/profesores";
    }

    @GetMapping("/edit/{id}")
    public String editProfesorForm(Model modelo, @PathVariable("id") @NonNull Integer id) {
        Optional <Profesor> oProfesor = repoProfesor.findById(id);
        if(oProfesor.isPresent()) {
            modelo.addAttribute( "profesor", oProfesor.get());
            return "profesores/edit";
        } else {
            modelo.addAttribute("mensaje", "El Profesor consultado no existe.");
            return "error";
        }
    }
    
}
