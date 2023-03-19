package com.example.proyecto1_23.Vista;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Envio extends AsyncTask<String, Void, Void> {
    Socket socket;
    DataOutputStream dt;
    PrintWriter pw;

    @Override
    protected Void doInBackground(String... strings) {
        String mensajes = strings[0];
        try{
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
