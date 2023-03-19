package com.example.proyecto1_23.Ocurrencias;

public class operadoresMatematicos {
    private String operador;
    private int fila;
    private int columna;

    public operadoresMatematicos(){}
    public operadoresMatematicos(String operador, int fila, int columna) {
        this.operador = operador;
        this.fila = fila;
        this.columna = columna;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
