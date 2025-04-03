//  @ Hoja de trabajo 8
//  @ File Name : SistemaEmergenciasFactory.java
//  @ Date : 02/04/2025
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//

package com.api;

/**
 * Factory class to create instances of SistemaEmergenciasInterface.
 */
public class SistemaEmergenciasFactory {

    /**
     * Returns an instance of SistemaEmergenciasInterface based on the specified type.
     *
     * @param tipo The type of implementation ("JCF" or "HEAP").
     * @return An instance of SistemaEmergenciasInterface.
     * @throws IllegalArgumentException if the type is invalid.
     */
    public static SistemaEmergenciasInterface getSistema(String tipo) {
        if (tipo.equalsIgnoreCase("JCF")) {
            return new SistemaEmergenciasJCF();
        } else if (tipo.equalsIgnoreCase("HEAP")) {
            return new SistemaEmergenciasHeap();
        } else {
            throw new IllegalArgumentException("Opción inválida. Use 'JCF' o 'HEAP'.");
        }
    }
}
