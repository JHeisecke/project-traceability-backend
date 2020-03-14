package com.github.pol.una.traceability.web.response;

import org.springframework.http.HttpStatus;

/**
 * @author bsandoval
 */
public class ObjectResponseDTO<T> extends BaseResponseDTO {

    private T dto;

    public ObjectResponseDTO() {
    }

    public ObjectResponseDTO(T dto) {
        this.dto = dto;
    }

    public ObjectResponseDTO(boolean success, HttpStatus httpStatus, T dto) {
        super(success, httpStatus);
        this.dto = dto;
    }

    public T getDto() {
        return dto;
    }

    public void setDto(T dto) {
        this.dto = dto;
    }

    public static ObjectResponseDTO success(Object dto) {
        return new ObjectResponseDTO(true, HttpStatus.OK, dto);
    }

}
