package com.example.proyecto1_23.Ocurrencias;


import java.io.Serializable;

public class OcurrenciasForma implements Serializable {

    private String operador;
    private int linea;
    private int columna;
    private String ejemplo;

    public OcurrenciasForma(String operador, int linea, int columna, String ejemplo) {
        this.operador = operador;
        this.linea = linea;
        this.columna = columna;
        this.ejemplo = ejemplo;
    }
    public OcurrenciasForma(String operadorMatematico, int linea, int columna){
        this.operador = operadorMatematico;
        this.linea = linea;
        this.columna = columna;

    }

    public OcurrenciasForma(){

    }

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

    public String getEjemplo() {
        return ejemplo;
    }

    public void setEjemplo(String ejemplo) {
        this.ejemplo = ejemplo;
    }
}