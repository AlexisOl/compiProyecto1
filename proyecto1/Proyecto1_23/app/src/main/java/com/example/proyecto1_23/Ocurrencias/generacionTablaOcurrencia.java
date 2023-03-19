package com.example.proyecto1_23.Ocurrencias;

import java.io.Serializable;
import java.util.ArrayList;

public class generacionTablaOcurrencia implements Serializable {

    private ArrayList<OcurrenciasForma> lista = new ArrayList<>();

    public generacionTablaOcurrencia(ArrayList<OcurrenciasForma> lista) {
        this.lista = lista;
    }
    public generacionTablaOcurrencia() {}

    public ArrayList<OcurrenciasForma> getLista() {return lista;}


    public void agregarOcurrencia(String operador, int linea, int columna){
        OcurrenciasForma nueva_ocurrencia = new OcurrenciasForma(operador, linea, columna);
        lista.add(nueva_ocurrencia);
    }



}