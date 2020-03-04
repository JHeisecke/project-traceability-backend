package com.github.pol.una.traceability.service;

/**
 * @author jvillagra
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
