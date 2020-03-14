package com.github.pol.una.traceability.exceptions;

public class RolException  extends BusinessException {
    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "rol.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";

    public RolException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a Rol Not Found Exception
     *
     * @param rolId rol id
     * @return userException
     */
    public static RolException notFound(Long rolId) {
        return new RolException(NOT_FOUND, String.format("Resource %s not found" , rolId));
    }
}
