package com.github.pol.una.traceability.exceptions;

public class LineaBaseException extends BusinessException {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "lineabase.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";

    public LineaBaseException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a Rol Not Found Exception
     *
     * @param lineabaseId item id
     * @return userException
     */
    public static ItemException notFound(Long lineabaseId) {
        return new ItemException(NOT_FOUND, String.format("Resource %s not found" , lineabaseId));
    }
}
