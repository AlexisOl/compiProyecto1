package com.example.proyecto1_23.Vista;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class socket extends AsyncTask<String, Void, Void> {
    Socket menssajeSocket;
    DataOutputStream infoEnvio;
    PrintWriter pw;
    void enviarInfo(String texto){
        System.out.println(texto);
    }

    @Override
    protected Void doInBackground(String... voids) {
        try {
            String mensajes = voids[0];
            menssajeSocket = new Socket("190.148.128.166", 6000);
            pw = new PrintWriter(menssajeSocket.getOutputStream());
            pw.write(mensajes);
            pw.flush();
            pw.close();
            menssajeSocket.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
