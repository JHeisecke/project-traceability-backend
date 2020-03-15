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
    public static final String USER = BASE + "/users";
    public static final String ROL = BASE + "/roles";
    public static final String ROL_BY_ID = BASE + "/rol/{id}";
    public static final String ROL_BY_NOMBRE = BASE + "/rol/nombre/{nombre}";
}
