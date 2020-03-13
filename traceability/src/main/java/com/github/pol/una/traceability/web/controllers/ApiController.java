package com.github.pol.una.traceability.web.controllers;

import com.github.pol.una.traceability.constants.ApiPaths;
import com.github.pol.una.traceability.dto.RolDTO;
import com.github.pol.una.traceability.dto.UsuarioDTO;
import com.github.pol.una.traceability.entities.Usuario;
import com.github.pol.una.traceability.exceptions.RolException;
import com.github.pol.una.traceability.exceptions.UserException;
import com.github.pol.una.traceability.service.RolService;
import com.github.pol.una.traceability.service.UsuarioService;
import com.github.pol.una.traceability.web.response.BaseResponseDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@Controller
@RequestMapping("/")
public class ApiController extends BaseRestController{

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @PostMapping(ApiPaths.LOGIN)
    public ResponseEntity<Usuario> login(@RequestBody UsuarioDTO usuario) throws UserException {
        return ResponseEntity.ok(usuarioService.login(usuario));
    }

    @GetMapping(ApiPaths.ROL)
    public List<RolDTO> getRolesExistentes(){
        return rolService.getAll();
    }

    @GetMapping(ApiPaths.ROL_BY_ID)
    public RolDTO getRolById(@PathVariable Long id) throws RolException{
        return rolService.getRolById(id);
    }

    @GetMapping(ApiPaths.ROL_BY_NOMBRE)
    public RolDTO getRolByNombre(@PathVariable String nombre) throws RolException{
        return rolService.getRolByNombre(nombre);
    }
}
