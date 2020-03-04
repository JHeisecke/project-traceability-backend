package com.github.pol.una.traceability.web.controllers;

import com.github.pol.una.traceability.constants.ApiPaths;
import com.github.pol.una.traceability.service.SecurityService;
import com.github.pol.una.traceability.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class ApiController extends BaseRestController{

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SecurityService securityService;


    @GetMapping(ApiPaths.LOGIN)
    public String getLogin(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "login";
    }

    @GetMapping({ApiPaths.API_PATTERN})
    public String welcome(Model model) {
        return "welcome";
    }
}
