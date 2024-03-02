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

import com.example.john.gestion_centro_educativo.modelos.Alumno;
import com.example.john.gestion_centro_educativo.repos.RepoAlumno;

@Controller
@RequestMapping("/alumnos")
public class ControllerAlumno {
    
    @Autowired
    RepoAlumno repoAlumno;

    // Método para obtener todos los alumnos de la BD
    @GetMapping("")
    public String findAll(Model modelo) {
        modelo.addAttribute(
            "alumnos", 
            repoAlumno.findAll());
        return "alumnos/alumnos";
    }

     @GetMapping("/add")
    public String addForm(Model modelo) {
        modelo.addAttribute("alumnos", repoAlumno.findAll());        
        return "alumnos/add";
    }

    @PostMapping("/add")
    public String postMethodName(
        @ModelAttribute("categoria") Alumno alumno)  {
        repoAlumno.save(alumno);
        return "redirect:/alumnos";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteForm(
            @PathVariable(name = "id") @NonNull Integer id, Model modelo) {
        try {
            Optional<Alumno> alumno = repoAlumno.findById(id);
            if (alumno.isPresent()){
                // si existe la categoria
                modelo.addAttribute(
                    "alumno", alumno.get());
                return "alumnos/delete";
            } else {
                return "error";
            }

        } catch (Exception e) {
            return "error";
        }
    }
    

    @PostMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") @NonNull Integer id) {
        try {
            repoAlumno.deleteById(id);    
        } catch (Exception e) {
            return "error";
        }
        
        return "redirect:/alumnos";
    }

    @GetMapping("/edit/{id}")
    public String editForm(
        @PathVariable @NonNull Integer id,Model modelo) {
            Optional<Alumno> alumno = repoAlumno.findById(id);
            List<Alumno> alumnos = repoAlumno.findAll();   
            if (alumno.isPresent()){
                modelo.addAttribute("alumno", alumno.get());
                modelo.addAttribute("alumnos", alumnos);
                return "alumnos/edit";
            } else {
                modelo.addAttribute(
                    "mensaje", "Alumno no encontrado");
                return "error";
            }
            
    }
}
