package com.api;

public class SistemaEmergenciasFactory {
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
