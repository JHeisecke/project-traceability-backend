package com.github.pol.una.traceability.web.controllers;

import com.github.pol.una.traceability.constants.ApiPaths;
import com.github.pol.una.traceability.dto.*;
import com.github.pol.una.traceability.exceptions.ProjectException;
import com.github.pol.una.traceability.exceptions.ItemException;
import com.github.pol.una.traceability.exceptions.RolException;
import com.github.pol.una.traceability.exceptions.UserException;
import com.github.pol.una.traceability.service.*;
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
    private PermisoRolService permisoRolService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private PermisoService permisoService;
    @Autowired
    private RecursoService recursoService;

    @PostMapping(ApiPaths.LOGIN)
    public ResponseEntity<ObjectResponseDTO<UsuarioDTO>> login(@RequestBody UsuarioDTO usuario) throws UserException {
        return ResponseEntity.ok(ObjectResponseDTO.success(usuarioService.login(usuario)));
    }

    /**
     * USER ENDPOINTS
     *
     */
    @GetMapping(ApiPaths.USER_ALL)
    public ResponseEntity<ListResponseDTO> getUsuariosExistentes() {
        List<UsuarioDTO> users = usuarioService.getAll();
        return ResponseEntity.ok(ListResponseDTO.success(users));
    }

    @PostMapping(ApiPaths.USER_SAVE)
    public ResponseEntity<ObjectResponseDTO<UsuarioDTO>> saveUser(@RequestBody UsuarioDTO user){
        return ResponseEntity.ok(ObjectResponseDTO.success(usuarioService.saveUser(user)));
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

    @GetMapping(ApiPaths.USERS_BY_ROLE)
    public ResponseEntity<ListResponseDTO> getUsuariosByRol(@PathVariable Long id){
        return ResponseEntity.ok(ListResponseDTO.success(permisoRolService.getAllPermisosByRol(id)));
    }

    /**
     * PROJECT ENDPOINTS
     *
     */
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

    /**
     * ITEMS ENDPOINTS
     *
     */

    @GetMapping(ApiPaths.ITEMS_BY_PROJECT)
    public ResponseEntity<ListResponseDTO<ItemDTO>> getItemsByProjectId(@PathVariable Long idProyecto) throws ItemException {
        List<ItemDTO> items = (List<ItemDTO>) itemService.getItemsByProyectoId(idProyecto);
        return ResponseEntity.ok(ListResponseDTO.success(items ));
    }

    @PostMapping(ApiPaths.ITEM_SAVE)
    public ResponseEntity<ObjectResponseDTO<ItemDTO>> saveItem(@RequestBody ItemDTO item) throws ItemException {
        return ResponseEntity.ok(ObjectResponseDTO.success(itemService.saveItem(item)));
    }

    @DeleteMapping(ApiPaths.ITEM_DELETE)
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) throws ItemException {
        try {
            itemService.deleteItem(id);
            return ResponseEntity.ok().build();
        }catch (ItemException e) {
            throw e;
        }
    }

    /**
     * ROLES ENDPOINTS
     *
     */
    @GetMapping(ApiPaths.ROLES)
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

    @PostMapping(ApiPaths.ROL_SAVE)
    public ResponseEntity<ObjectResponseDTO<RolDTO>> saveRol(@RequestBody RolDTO rol){
        return ResponseEntity.ok(ObjectResponseDTO.success(rolService.save(rol)));
    }

    @DeleteMapping(ApiPaths.ROL_DELETE)
    public ResponseEntity<Void> deleteRol(@PathVariable Long id){
        rolService.deleteRol(id);
        return ResponseEntity.ok().build();
    }

    /**
     * PERMISOS ENDPOINTS
     *
     */
    @GetMapping(ApiPaths.PERMISOS_ALL)
    public ResponseEntity<ListResponseDTO> getPermisosExistentes(){
        List<PermisoDTO> permisos = permisoService.getAllPermisos();
        return ResponseEntity.ok(ListResponseDTO.success(permisos));
    }
    /**
     * RECURSOS ENDPOINTS
     *
     */
    @GetMapping(ApiPaths.RECURSOS_ALL)
    public ResponseEntity<ListResponseDTO> getRecursosExistentes(){
        List<RecursoDTO> recursos = recursoService.getAllRecursos();
        return ResponseEntity.ok(ListResponseDTO.success(recursos));
    }
}
