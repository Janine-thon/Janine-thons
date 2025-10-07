package com.example.revisao.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UniversidadeFederativa {
        BAHIA("BA"),
        SAOPAULO("SP"),
        RIODEJANEIRO("RJ");

        private final String sigla;

        UniversidadeFederativa(String sigla) {
            this.sigla = sigla;
        }

        @JsonValue
        public String getSigla() {
            return sigla;
        }

        @JsonCreator
        public static UniversidadeFederativa fromSigla(String sigla) {
            for (UniversidadeFederativa uf : UniversidadeFederativa.values()) {
                if (uf.getSigla().equalsIgnoreCase(sigla)) {
                    return uf;
                }
            }
            throw new IllegalArgumentException("Sigla inválida: " + sigla);
        }
}
