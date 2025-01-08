package com.webapp.banca.demo.expose.util;

import lombok.Getter;

@Getter
public enum Operation {


    WITHDRAWAL("W", "RETIRO DINERO DE CUENTA"),
    DEPOSIT("D", "DEPOSITO DINERO EN CUENTA");

    private final String code;
    private final String description;


    // Constructor
    Operation(String code, String description) {
        this.code = code;
        this.description = description;
    }


    // Method to get enum by code
    public static Operation fromCode(String code) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equalsIgnoreCase(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("No enum constant with code " + code);
    }

}
