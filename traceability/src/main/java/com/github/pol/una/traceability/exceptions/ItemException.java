package com.github.pol.una.traceability.exceptions;

public class ItemException  extends BusinessException {
    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "item.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";

    public ItemException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a Rol Not Found Exception
     *
     * @param itemId item id
     * @return userException
     */
    public static ItemException notFound(Long itemId) {
        return new ItemException(NOT_FOUND, String.format("Resource %s not found" , itemId));
    }
}