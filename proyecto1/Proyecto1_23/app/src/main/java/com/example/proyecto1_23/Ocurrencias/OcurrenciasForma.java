package com.example.proyecto1_23.Ocurrencias;


import java.io.Serializable;

public class OcurrenciasForma implements Serializable {

    private String operador;
    private int linea;
    private int columna;

    public OcurrenciasForma(String operador, int linea, int columna) {
        this.operador = operador;
        this.linea = linea;
        this.columna = columna;
    }


    public OcurrenciasForma(){    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public int getLinea() {
        return linea;
    }
    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }

}