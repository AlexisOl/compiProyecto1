package com.example.proyecto1_23.Ocurrencias;

public class movimientoObjetos {

    private String tipo;
    private Double valor;
    private int fila;
    private int columna;


    public movimientoObjetos(String tipo, Double valor){
        this.tipo=tipo;
        this.valor=valor;
    }
    public movimientoObjetos(String tipo, int fila, int columna ) {
        this.tipo=tipo;
        this.fila=fila;
        this.columna=columna;
    }

    public movimientoObjetos(){}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {   return columna;}

    public void setColumna(int columna) {this.columna = columna;}

    public int getFila() {return fila;}
}
