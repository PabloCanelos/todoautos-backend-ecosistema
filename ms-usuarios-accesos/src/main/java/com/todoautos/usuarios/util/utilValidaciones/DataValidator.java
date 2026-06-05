package com.todoautos.usuarios.util.utilValidaciones;

import org.springframework.stereotype.Component;

@Component
public class DataValidator {
    // Expresión regular para formatos estrictos (Letras mayúsculas y guiones bajos)
    private static final String REGEX_SNAKE_UPPERCASE = "^[A-Z_]+$";

    /**
     * Valida de manera genérica el formato estricto de nombres/identificadores (Roles o Permisos)
     */
    public void validateFormatName(String name, String fieldName) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo " + fieldName + " es obligatorio.");
        }
        if (name.trim().length() < 2) {
            throw new IllegalArgumentException("El campo " + fieldName + " debe tener al menos 2 caracteres.");
        }
        if (!name.trim().matches(REGEX_SNAKE_UPPERCASE)) {
            throw new IllegalArgumentException("El formato de " + fieldName + " es inválido. Debe usar solo letras mayúsculas y guiones bajos (Ej: CREAR_ORDEN).");
        }
    }

    /**
     * Valida descripciones genéricas de cualquier entidad del microservicio
     */
    public void validateDescription(String description, int min, int max) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción es obligatoria.");
        }
        int length = description.trim().length();
        if (length < min || length > max) {
            throw new IllegalArgumentException("La descripción debe tener entre " + min + " y " + max + " caracteres.");
        }
    }
}

