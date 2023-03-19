package com.example.proyecto1_23.Ocurrencias;

import java.io.Serializable;
import java.util.ArrayList;

public class generacionTablaOcurrencia implements Serializable {

    private ArrayList<OcurrenciasForma> lista = new ArrayList<>();

    /**
     * Constructor de la clase TablaDeOcurrencia
     * @param lista La lista de ocurrencias
     */
    public generacionTablaOcurrencia(ArrayList<OcurrenciasForma> lista) {
        this.lista = lista;
    }

    /**
     * Contructor vacio de la tabla de ocurrencias
     */
    public generacionTablaOcurrencia() {
    }

    /**
     * Devuelve la lista de ocurrencias
     * @return La lista de ocurrencias
     */
    public ArrayList<OcurrenciasForma> getLista() {
        return lista;
    }

    /**
     * Obtiene la lista de ocurrencias
     * @param lista La lista de ocurrencias
     */
    public void setLista(ArrayList<OcurrenciasForma> lista) {
        this.lista = lista;
    }

    /**
     * Agrega una ocurrencia a la lista de ocurrencias
     * @param operador El operador de la ocurrencia
     * @param linea La linea de ocurrencia
     * @param columna La columna de la ocurrencia
     * @param ejemplo El ejemplo de la ocurrencia
     */
    public void agregarOcurrencia(String operador, int linea, int columna, String ejemplo){
        OcurrenciasForma nueva_ocurrencia = new OcurrenciasForma(operador, linea, columna, ejemplo);
        lista.add(nueva_ocurrencia);
    }

    /**
     * Reinicia la lista de ocurrencias
     */
    public void reiniciarLista(){
        lista.clear();
    }
}