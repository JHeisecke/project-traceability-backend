package com.github.pol.una.traceability.exceptions;

public class ProjectException extends BusinessException {
    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "proyecto.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";

    public ProjectException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a Project Not Found Exception
     *
     * @param projectId Project id
     * @return ProjectException
     */
    public static ProjectException notFound(Long projectId) {
        return new ProjectException(NOT_FOUND, String.format("Project %s not found" , projectId));
    }
}
