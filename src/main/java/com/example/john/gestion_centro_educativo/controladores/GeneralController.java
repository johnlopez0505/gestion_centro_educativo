package com.example.john.gestion_centro_educativo.controladores;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@ControllerAdvice
public class GeneralController {

    @GetMapping("/ayuda")
    public String showAyuda() {
        return "ayuda";
    }

    @GetMapping("/acerca")
    public String showAcerca() {
        return "acerca";
    }

    @GetMapping("/error")
    public String showError() {
        return "error";
    }

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    // @GetMapping("/login")
    // public String showlogin() {
    //     return "login";
    // }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleDataIntegrityViolationException(DataIntegrityViolationException ex, Model model) {
        model.addAttribute("mensaje", "Este correo electrónico ya está en uso.");
        return "error"; 
    }

}
