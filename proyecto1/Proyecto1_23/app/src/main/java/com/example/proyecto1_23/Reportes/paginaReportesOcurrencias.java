package com.example.proyecto1_23.Reportes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto1_23.Ocurrencias.movimientoObjetos;
import com.example.proyecto1_23.R;
import com.example.proyecto1_23.Vista.Juego;

public class paginaReportesOcurrencias extends AppCompatActivity {
    Button SendInfo;
    Button botonCantidad;
    Button botonMatematicas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.generacion_pagina_ocurrencias);
        SendInfo=findViewById(R.id.boton1);
        botonCantidad=findViewById(R.id.boton2);
        botonMatematicas=findViewById(R.id.boton3);
        SendInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    irReporteInstrucciones();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        botonCantidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    irReporteCantidad();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        botonMatematicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    irReporteOperadores();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }




   public void irReporteCantidad(){
       Intent intent = new Intent(paginaReportesOcurrencias.this, ReporteCantidadOcurrencias.class);
       startActivity(intent);
   }
    public void irReporteInstrucciones(){
        Intent intent = new Intent(paginaReportesOcurrencias.this, ReporteTablasOcurrencia.class);
        startActivity(intent);
    }
    public void irReporteOperadores(){
        Intent intent = new Intent(paginaReportesOcurrencias.this, paginaReporteMatematico.class);
        startActivity(intent);
    }
}
