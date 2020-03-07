package com.github.pol.una.traceability.web.controllers;

import com.github.pol.una.traceability.constants.ApiPaths;
import com.github.pol.una.traceability.web.response.HeartBeatResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 *
 * @author jvillagra
 *
 */
public abstract class BaseRestController {

    @RequestMapping(value = ApiPaths.ROOT_DIAGNOSTIC + ApiPaths.SUFFIX_HEART_BEAT, method = RequestMethod.GET)
    public ResponseEntity<HeartBeatResponseDTO> getHearbeat() {
        HeartBeatResponseDTO heartBeatResponseDTO = getHeartBeatStatus();
        return new ResponseEntity<>(heartBeatResponseDTO, heartBeatResponseDTO.getHttpStatus());
    }

    public HeartBeatResponseDTO getHeartBeatStatus() {
        String result = String.format("Service status: %s, date: %s", "OK", new Date());

        return HeartBeatResponseDTO.builder()
                .success(true)
                .message(result)
                .httpStatus(HttpStatus.OK)
                .build();
    }

}