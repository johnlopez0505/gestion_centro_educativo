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

import com.example.john.gestion_centro_educativo.modelos.Asignatura;
import com.example.john.gestion_centro_educativo.repos.RepoAsignatura;


@Controller
@RequestMapping("/asignaturas")
public class ControllerAsignatura {

    @Autowired
    private RepoAsignatura repoAsignatura;

   
    @GetMapping(path = "/")
    public String findAll(Model modelo) {
        List<Asignatura> lAsignaturas = repoAsignatura.findAll();
        modelo.addAttribute("asignaturas", lAsignaturas);
        return "asignaturas/asignaturas";
    }

    @GetMapping("")
    public String findAll2(Model modelo) {
        return findAll(modelo);
    }

    @GetMapping("/add")
    public String addAsignatura(Model modelo) {
        modelo.addAttribute("asignaturas", new Asignatura());
        return "asignaturas/add";
    }

    @PostMapping("/add")
    public String addASignatura(@ModelAttribute("asignatura") @NonNull Asignatura asignatura) {
        repoAsignatura.save(asignatura);
        return "redirect:/asignaturas";
    }

    @GetMapping("/delete/{id}")
    public String deleteAsignaturaForm(Model modelo, @PathVariable("id") @NonNull Integer id) {
        Optional<Asignatura> oAsignatura = repoAsignatura.findById(id);
        if (oAsignatura.isPresent())
            modelo.addAttribute(
            "asignatura", oAsignatura.get());
        else {
            modelo.addAttribute(
                "mensaje", "La Asignatura consultada no existe.");
            return "error";
        }
        return "asignaturas/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteAsignatura(@PathVariable("id") @NonNull Integer id) {
        repoAsignatura.deleteById(id);
        return "redirect:/asignaturas";
    }

    @GetMapping("/edit/{id}")
    public String editAsignaturaForm(Model modelo, @PathVariable("id") @NonNull Integer id) {
        Optional <Asignatura> oAsignatura = repoAsignatura.findById(id);
        if(oAsignatura.isPresent()) {
            modelo.addAttribute(
            "asignatura", oAsignatura.get());
            return "asignaturas/edit";
        } else {
            modelo.addAttribute("mensaje", "La Asignatura consultada no existe.");
            return "error";
        }
    }
    
}
