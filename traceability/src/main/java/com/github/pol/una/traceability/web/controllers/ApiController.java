package com.github.pol.una.traceability.web.controllers;

import com.github.pol.una.traceability.constants.ApiPaths;
import com.github.pol.una.traceability.dto.UsuarioDTO;
import com.github.pol.una.traceability.entities.Usuario;
import com.github.pol.una.traceability.exceptions.UserException;
import com.github.pol.una.traceability.service.UsuarioService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@Controller
@RequestMapping("/")
public class ApiController extends BaseRestController{

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(ApiPaths.LOGIN)
    public ResponseEntity<UsuarioDTO> login(@RequestBody UsuarioDTO usuario) throws UserException {
        return ResponseEntity.ok(usuarioService.login(usuario));
    }

    @GetMapping({ApiPaths.BASE})
    public String welcome(Model model) {
        return "welcome";
    }
}
