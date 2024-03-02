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

import com.example.john.gestion_centro_educativo.modelos.Rol;
import com.example.john.gestion_centro_educativo.modelos.User;
import com.example.john.gestion_centro_educativo.repos.RepoRol;
import com.example.john.gestion_centro_educativo.repos.RepoUser;

@Controller
@RequestMapping("/usuarios")
public class ControllerUser {

    @Autowired
    private RepoUser repoUser;

    @Autowired
    private RepoRol repoRol;
    
    @GetMapping(path = "/")
    public String findAll(Model modelo) {
        List<User> lUsuario = repoUser.findAll();
        modelo.addAttribute("usuarios", lUsuario);
        return "usuarios/usuarios";
    }

    @GetMapping("")
    public String findAll2(Model modelo) {
        return findAll(modelo);
    }

    @GetMapping("/add")
    public String addUsuario(Model modelo) {
        List<Rol> roles = repoRol.findAll();
        modelo.addAttribute("usuario", new User());
        modelo.addAttribute("roles", roles);
        return "usuarios/add";
    }

    @PostMapping("/add")
    public String addUsuario(@ModelAttribute("usuario") @NonNull User usuario) {
        repoUser.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/delete/{id}")
    public String deleteUsuarioForm(Model modelo, @PathVariable("id") @NonNull Integer id) {
        Optional<User> oUsuario = repoUser.findById(id);
        if (oUsuario.isPresent())
            modelo.addAttribute(
            "usuario", oUsuario.get());
        else {
            modelo.addAttribute(
                "mensaje", "El usuario consultado no existe.");
            return "error";
        }
        return "usuarios/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable("id") @NonNull Integer id) {
        repoUser.deleteById(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/edit/{id}")
    public String editUsuarioForm(Model modelo, @PathVariable("id") @NonNull Integer id) {
        Optional <User> oUsuario = repoUser.findById(id);
        if(oUsuario.isPresent()) {
            modelo.addAttribute(
            "usuario", oUsuario.get());
            modelo.addAttribute(
                "roles", repoRol.findAll());
            return "usuarios/edit";
        } else {
            modelo.addAttribute("mensaje", "El usuario consultado no existe.");
            return "error";
        }
    }

}
