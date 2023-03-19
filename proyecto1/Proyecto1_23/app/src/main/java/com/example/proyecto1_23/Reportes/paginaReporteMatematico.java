package com.example.proyecto1_23.Reportes;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto1_23.Ocurrencias.movimientoObjetos;
import com.example.proyecto1_23.Ocurrencias.operadoresMatematicos;
import com.example.proyecto1_23.R;
import com.example.proyecto1_23.Vista.Juego;

import java.util.ArrayList;

public class paginaReporteMatematico extends AppCompatActivity {

    TableLayout tablaLayout=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ocurrencia_matematica);
        tablaLayout = findViewById(R.id.tablaReporteMatematica);
        agregarDatos(Juego.operadoresMatematicos);
    }
    public void agregarDatos(ArrayList<operadoresMatematicos> listaMatematica) {
        for (int i = -1; i < listaMatematica.size(); i++) {
            View registro = LayoutInflater.from(this).inflate(R.layout.tabla_matematica, null, false);
            TextView itemOperador = registro.findViewById(R.id.OcurrenciaMatematica);
            TextView itemLinea = registro.findViewById(R.id.fila);
            TextView itemColumna = registro.findViewById(R.id.columna);
            if (i == -1) {
                itemOperador.setText("Ocurrencia");
                itemOperador.setBackgroundColor(Color.BLACK);
                itemOperador.setTextColor(Color.WHITE);
                itemLinea.setText("Fila");
                itemLinea.setBackgroundColor(Color.BLACK);
                itemLinea.setTextColor(Color.WHITE);
                itemColumna.setText("Columna");
                itemColumna.setBackgroundColor(Color.BLACK);
                itemColumna.setTextColor(Color.WHITE);
            } else {
                itemOperador.setText(listaMatematica.get(i).getOperador());
                itemOperador.setBackgroundColor(Color.RED);
                itemOperador.setTextColor(Color.BLACK);
                itemLinea.setText(String.valueOf(listaMatematica.get(i).getFila()));
                itemLinea.setBackgroundColor(Color.RED);
                itemLinea.setTextColor(Color.BLACK);
                itemColumna.setText(String.valueOf(listaMatematica.get(i).getColumna()));
                itemColumna.setBackgroundColor(Color.RED);
                itemColumna.setTextColor(Color.BLACK);
            }
            tablaLayout.addView(registro);
        }
    }
}
