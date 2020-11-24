package com.mindfirelabs.curso.util;

public class GestionStrings {
    
    public String validarCadena(String cadena) {
        if(cadena.isEmpty()) {
            return "El campo no puede estar vacio";
        }
        if(cadena.trim().isEmpty()) {
            return "No se permiten solo espacios en blanco";
        }
        return null;
    }
    
}
