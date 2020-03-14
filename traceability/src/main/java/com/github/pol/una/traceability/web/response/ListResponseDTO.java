package com.github.pol.una.traceability.web.response;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author bsandoval
 */
public class ListResponseDTO<T> extends BaseResponseDTO {

    private List<T> list;

    public ListResponseDTO(List<T> list) {
        this.list = list;
    }

    public ListResponseDTO(boolean success, HttpStatus httpStatus, List<T> list) {
        super(success, httpStatus);
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static ListResponseDTO success(List<?> list) {
        return new ListResponseDTO(true, HttpStatus.OK, list);
    }
}
