package com.example.proyecto1_23.Reportes;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto1_23.Ocurrencias.movimientoObjetos;
import com.example.proyecto1_23.R;
import com.example.proyecto1_23.Vista.Juego;

import java.util.ArrayList;

public class ReporteCantidadOcurrencias extends AppCompatActivity {
    TableLayout tablaLayout=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ocurrencia_cantidad);
        tablaLayout = findViewById(R.id.tablaReporteCantidad);
        agregarDatos(Juego.listaEjecuciones);

    }

    public void agregarDatos(ArrayList<movimientoObjetos> lista) {
        int cantidadDerecha=0;
        int cantidadArriba=0;
        int cantidadAbajo=0;
        int cantidadIzquierda=0;

        //determinar cantidades;
        for (int i =0; i < lista.size(); i++) {
            switch (lista.get(i).getTipo()) {
                case "up":
                        cantidadArriba++;
                    break;
                case "down":
                        cantidadAbajo++;

                    break;
                case "left":
                        cantidadIzquierda++;
                    break;
                case "right":
                        cantidadDerecha++;
                    break;
            }
        }

        for (int i = -1; i < 4; i++) {
            View registro = LayoutInflater.from(this).inflate(R.layout.tabla_cantidad, null, false);
            TextView ocurrencia = registro.findViewById(R.id.itemOcurrencia);
            TextView itemLinea = registro.findViewById(R.id.itemCantidad);
            if (i == -1) {
                ocurrencia.setText("Instrucción");
                ocurrencia.setBackgroundColor(Color.DKGRAY);
                ocurrencia.setTextColor(Color.WHITE);
                itemLinea.setText("Cantidad");
                itemLinea.setBackgroundColor(Color.DKGRAY);
                itemLinea.setTextColor(Color.WHITE);
            } else if(i == 0){
                ocurrencia.setText("left");
                ocurrencia.setBackgroundColor(Color.RED);
                ocurrencia.setTextColor(Color.BLACK);
                itemLinea.setText(String.valueOf(cantidadIzquierda));
                itemLinea.setBackgroundColor(Color.RED);
                itemLinea.setTextColor(Color.BLACK);
            } else if(i == 1){
                ocurrencia.setText("DOWN");
                ocurrencia.setBackgroundColor(Color.RED);
                ocurrencia.setTextColor(Color.BLACK);
                itemLinea.setText(String.valueOf(cantidadAbajo));
                itemLinea.setBackgroundColor(Color.RED);
                itemLinea.setTextColor(Color.BLACK);
            } else if(i == 2){
                ocurrencia.setText("RIGHT");
                ocurrencia.setBackgroundColor(Color.RED);
                ocurrencia.setTextColor(Color.BLACK);
                itemLinea.setText(String.valueOf(cantidadDerecha));
                itemLinea.setBackgroundColor(Color.RED);
                itemLinea.setTextColor(Color.BLACK);
            } else if(i == 3){
                ocurrencia.setText("UP");
                ocurrencia.setBackgroundColor(Color.RED);
                ocurrencia.setTextColor(Color.BLACK);
                itemLinea.setText(String.valueOf(cantidadArriba));
                itemLinea.setBackgroundColor(Color.RED);
                itemLinea.setTextColor(Color.BLACK);
            }

            tablaLayout.addView(registro);
        }
    }
}
