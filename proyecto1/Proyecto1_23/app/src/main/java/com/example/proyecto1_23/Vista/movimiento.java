package com.example.proyecto1_23.Vista;

import com.example.proyecto1_23.Ocurrencias.movimientoObjetos;
//import com.example.proyecto1_23.ReporteErrores.*;

import java.io.Serializable;
import java.util.ArrayList;

public class movimiento implements Serializable {

    //listas de almacenamineto
    private ArrayList<Double> enteros = new ArrayList<Double>();
    private ArrayList<Double> numeros = new ArrayList<>();
    private ArrayList<String> tipoMovimiento = new ArrayList<>();
//    private ArrayList<ReportedeErrores> errores = new ArrayList<>();
    private ArrayList<movimientoObjetos> movimientosLista = new ArrayList<movimientoObjetos>();

    private int ejecuciones=0;

    public movimiento(){}

    public ArrayList<movimientoObjetos> getMovimientosLista(){
        return movimientosLista;
    }

    public void agregarMovimiento(String tipo, Double cantidad) {
        movimientosLista.add(new movimientoObjetos(tipo, cantidad));
    }
    public void agregarTipo(String tipo) {
        tipoMovimiento.add(tipo);
    }

    public void agregarCantidad(Double valor) {
        enteros.add(valor);
    }

    public void mostrarIndividual(){
        for (String objetosTotales1: tipoMovimiento) {
            System.out.println(objetosTotales1);
        }
        for (Double objetosTotales2: enteros) {
            System.out.println(objetosTotales2);
        }
    }
    public void mostrarMovimientos(){
        for (movimientoObjetos objetosTotales: movimientosLista) {
            System.out.println(objetosTotales);
        }
    }

}
