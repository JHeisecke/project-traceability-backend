package com.github.pol.una.traceability.constants;

/**
 * Contiene los paths para el ApiRestController
 * @author jvillagra
 */
public class ApiPaths {

    public static final String API_PATTERN = "/api/.*";
    public static final String BASE = "/api";
    public static final String ROOT_DIAGNOSTIC = "/diagnostic";
    public static final String SUFFIX_HEART_BEAT = "/heartbeat";
    public static final String API_SECURE = "/api/secure";

    public static final String LOGIN = BASE + "/login";

    public static final String USER = BASE + "/usuario";
    public static final String USER_DELETE = USER + "/delete/{username}";
    public static final String USER_SAVE = USER + "/save";
    public static final String USERS_BY_ROLE = BASE + "/rol/usuarios/{id}";
    public static final String USER_ALL = BASE + "/usuarios";

    public static final String ROLES = BASE + "/roles";
    public static final String ROL_BY_ID = BASE + "/rol/{id}";
    public static final String ROL_BY_NOMBRE = BASE + "/rol/nombre/{nombre}";
    public static final String ROL = BASE + "/rol";
    public static final String ROL_SAVE = ROL + "/save";
    public static final String ROL_DELETE = ROL + "/delete/{id}";

    public static final String PROJECT = BASE + "/proyecto";
    public static final String PROJECT_SAVE = PROJECT + "/save";
    public static final String PROJECT_DELETE = PROJECT + "/delete/{id}";
    public static final String PROJECT_ALL = BASE + "/proyectos";
    public static final String PROJECT_BY_ID = BASE + "/proyecto/{id}";

    public static final String ITEM = BASE + "/item";
    public static final String ITEM_SAVE = ITEM + "/save";
    public static final String ITEMS_BY_PROJECT = ITEM + "/{idProyecto}";
    public static final String ITEM_DELETE = ITEM + "/delete/{id}";
    public static final String ITEMS_BY_LINEABASE = ITEM + "/linea-base/{idLineaBase}";
    public static final String ITEMS_BY_PROYECTO_FASE = ITEMS_BY_PROJECT + "/{idFase}";
    public static final String ITEM_ASIGN_LINEA_BASE = ITEM + "/linea-base/asignar";

    public static final String PERMISOS_ALL = BASE + "/permisos";

    public static final String RECURSOS_ALL = BASE + "/recursos";

    public static final String LINEABASE = BASE + "/linea-base";
    public static final String LINEABASE_SAVE = LINEABASE + "/save";
    public static final String LINEABASE_DELETE = LINEABASE + "/delete/{id}";
    public static final String LINEABASE_ALL = BASE + "/lineas-base";
    public static final String LINEABASE_BY_ID = LINEABASE + "/linea-base/{id}";
    public static final String LINEABASE_BY_PROJECT = LINEABASE + "/{idProyecto}";

    public static final String FASE = BASE + "/fase";
    public static final String FASE_SAVE = FASE + "/save";
    public static final String FASE_BY_ID = FASE + "/{id}";
    public static final String FASE_BY_PROJECT = FASE + "/proyecto/{idProyecto}";
}
