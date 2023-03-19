package com.example.proyecto1_23.Reportes;

import android.content.Intent;
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
import com.example.proyecto1_23.Vista.MainActivity;

import java.util.ArrayList;

public class ReporteTablasOcurrencia   extends AppCompatActivity {
    TableLayout tablaLayout=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ocurrencia_tablas);
        tablaLayout = findViewById(R.id.tablaReporte2);
        Bundle objetoEnviado = getIntent().getExtras();

        agregarDatos(Juego.listaEjecuciones);


    }

    public void agregarDatos(ArrayList<movimientoObjetos> lista) {
        for (int i = -1; i < lista.size(); i++) {
            View registro = LayoutInflater.from(this).inflate(R.layout.tabla_individual, null, false);
            TextView itemOperador = registro.findViewById(R.id.itemOperador);
            TextView itemLinea = registro.findViewById(R.id.itemLineaOP);
            TextView itemColumna = registro.findViewById(R.id.itemColumnaOP);

            if (i == -1) {
                itemOperador.setText("Instrucción");
                itemOperador.setBackgroundColor(Color.BLACK);
                itemOperador.setTextColor(Color.WHITE);
                itemLinea.setText("Fila");
                itemLinea.setBackgroundColor(Color.BLACK);
                itemLinea.setTextColor(Color.WHITE);
                itemColumna.setText("Columna");
                itemColumna.setBackgroundColor(Color.BLACK);
                itemColumna.setTextColor(Color.WHITE);

            } else {
                itemOperador.setText(lista.get(i).getTipo());
                itemOperador.setBackgroundColor(Color.RED);
                itemOperador.setTextColor(Color.BLACK);
                itemLinea.setText(String.valueOf(lista.get(i).getFila()));
                itemLinea.setBackgroundColor(Color.RED);
                itemLinea.setTextColor(Color.BLACK);
                itemColumna.setText(String.valueOf(lista.get(i).getColumna()));
                itemColumna.setBackgroundColor(Color.RED);
                itemColumna.setTextColor(Color.BLACK);
            }

            tablaLayout.addView(registro);
        }
    }

}

