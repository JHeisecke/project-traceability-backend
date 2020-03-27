package com.github.pol.una.traceability.web.controllers;

import com.github.pol.una.traceability.constants.ApiPaths;
import com.github.pol.una.traceability.dto.ProyectoDTO;
import com.github.pol.una.traceability.dto.ItemDTO;
import com.github.pol.una.traceability.dto.RolDTO;
import com.github.pol.una.traceability.dto.UsuarioDTO;
import com.github.pol.una.traceability.exceptions.ProjectException;
import com.github.pol.una.traceability.exceptions.ItemException;
import com.github.pol.una.traceability.exceptions.RolException;
import com.github.pol.una.traceability.exceptions.UserException;
import com.github.pol.una.traceability.service.ProyectoService;
import com.github.pol.una.traceability.service.RolService;
import com.github.pol.una.traceability.service.ItemService;
import com.github.pol.una.traceability.service.UsuarioService;
import com.github.pol.una.traceability.web.response.ListResponseDTO;
import com.github.pol.una.traceability.web.response.ObjectResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ApiController extends BaseRestController{

    @Autowired
    private ProyectoService proyectoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RolService rolService;

    @Autowired
    private ItemService itemService;

    @PostMapping(ApiPaths.LOGIN)
    public ResponseEntity<ObjectResponseDTO<UsuarioDTO>> login(@RequestBody UsuarioDTO usuario) throws UserException {
        return ResponseEntity.ok(ObjectResponseDTO.success(usuarioService.login(usuario)));
    }

    @GetMapping(ApiPaths.USER_ALL)
    public ResponseEntity<ListResponseDTO> getUsuariosExistentes() {
        List<UsuarioDTO> users = usuarioService.getAll();
        return ResponseEntity.ok(ListResponseDTO.success(users));
    }

    @PostMapping(ApiPaths.USER_SAVE)
    public ResponseEntity<ObjectResponseDTO<UsuarioDTO>> saveUser(@RequestBody UsuarioDTO user){
        return ResponseEntity.ok(ObjectResponseDTO.success(usuarioService.saveUser(user)));
    }

    @GetMapping(ApiPaths.ROL)
    public ResponseEntity<ListResponseDTO> getRolesExistentes(){
        List<RolDTO> roles = rolService.getAll();
        return ResponseEntity.ok(ListResponseDTO.success(roles));
    }

    @GetMapping(ApiPaths.ROL_BY_ID)
    public ResponseEntity<ObjectResponseDTO<RolDTO>> getRolById(@PathVariable Long id) throws RolException{
        return ResponseEntity.ok(ObjectResponseDTO.success(rolService.getRolById(id)));
    }

    @GetMapping(ApiPaths.ROL_BY_NOMBRE)
    public ResponseEntity<ObjectResponseDTO<RolDTO>> getRolByNombre(@PathVariable String nombre) throws RolException{
        return ResponseEntity.ok(ObjectResponseDTO.success(rolService.getRolByNombre(nombre)));
    }

    @GetMapping(ApiPaths.USER)
    public ResponseEntity<ObjectResponseDTO<UsuarioDTO>> getUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(ObjectResponseDTO.success(usuarioService.findByUsername(usuarioDTO.getUsername())));
    }

    @DeleteMapping(ApiPaths.USER_DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable String username) throws UserException {
        try {
            usuarioService.deleteUser(username);
            return ResponseEntity.ok().build();
        }catch (UserException e) {
            throw e;
        }
    }
    @PostMapping(ApiPaths.PROJECT_SAVE)
    public ResponseEntity<ObjectResponseDTO<ProyectoDTO>> saveProject(@RequestBody ProyectoDTO proyecto){
        return ResponseEntity.ok(ObjectResponseDTO.success(proyectoService.saveProject(proyecto)));
    }

    @GetMapping(ApiPaths.PROJECT_ALL)
    public ResponseEntity<ListResponseDTO> getAllProjects(){
        List<ProyectoDTO> projects = proyectoService.getAllProjects();
        return ResponseEntity.ok(ListResponseDTO.success(projects));
    }

    @GetMapping(ApiPaths.PROJECT_BY_ID)
    public ResponseEntity<ObjectResponseDTO<ProyectoDTO>> getProjectById(@PathVariable Long id) throws ProjectException {
        return ResponseEntity.ok(ObjectResponseDTO.success(proyectoService.getProjectById(id)));
    }

    @DeleteMapping(ApiPaths.PROJECT_DELETE)
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) throws ProjectException {
        try {
            proyectoService.deleteProject(id);
            return ResponseEntity.ok().build();
        }catch (ProjectException e) {
            throw e;
        }
    }

    @GetMapping(ApiPaths.ITEMS_BY_PROJECT)
    public ResponseEntity<ListResponseDTO<ItemDTO>> getItemsByProjectId(@PathVariable Long idProyecto) throws ItemException {
        List<ItemDTO> items = (List<ItemDTO>) itemService.getItemsByProyectoId(idProyecto);
        return ResponseEntity.ok(ListResponseDTO.success(items ));
    }
}
