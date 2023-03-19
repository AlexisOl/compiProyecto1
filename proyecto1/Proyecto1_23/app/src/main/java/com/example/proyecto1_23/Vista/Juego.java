package com.example.proyecto1_23.Vista;
import java.io.StringReader;

import com.example.proyecto1_23.Ocurrencias.movimientoObjetos;
import  com.example.proyecto1_23.Parser.*;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto1_23.R;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class Juego extends AppCompatActivity implements View.OnClickListener {

    //socket
    private Socket usaurioSocket;
    private PrintWriter pw;
    public static final String IP= "192.168.1.102";
    public static final int PUERTO = 6001;
    private String mensajeSocket;
    private  String mensajeUnico="";
    private String mensajeUnificadoFinal="";
    //------------------

    DibujoTablero drawView;
    JuegoMovimiento gameState;
    RelativeLayout gameButtons;
    RelativeLayout gameTextArea;
    EditText textAreaSpecific;

    //Botones
    Button left;
    Button right;
    Button up;
    Button down;
    Button SendInfo;


    FrameLayout game;
    Button pause;
    TextView score;
    Button difficultyToggle;
    Handler handler;
    Runnable loop;
    int delayFactor;
    int delay;
    int delayLowerLimit;

    // Elementos prubea
    private ArrayList<movimientoObjetos> moviminetosPruba = new ArrayList<movimientoObjetos>();
    public  ArrayList<String> nombreTiposLista = new ArrayList<>();;
    public  ArrayList<Double> nombreValoresLista = new ArrayList<>();;
    private  movimientoObjetos tipoIngreso = new movimientoObjetos();
    private Thread hiloMovimiento = new Thread();
    private boolean mover = false;


    //ELEMENTOS MOVIMIENTOS FINALES
    private ArrayList<movimientoObjetos> movimientosHilo = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //generacion de tipo de elemento
        gameState = new JuegoMovimiento(24, 24, TipoFiguraGeneral.ONLYSQUARE);

        //vista del juego
        drawView = new DibujoTablero(this, gameState);
        drawView.setBackgroundColor(Color.WHITE);
// cuadro de texto


        game = new FrameLayout(this);
        gameButtons = new RelativeLayout(this);

        delay = 500;
        delayLowerLimit = 200;
        delayFactor = 2;


        //generacion de botones y atributos
        left = new Button(this);
        left.setText(R.string.left);
        left.setId(R.id.left);

        right = new Button(this);
        right.setText(R.string.right);
        right.setId(R.id.right);

        up = new Button(this);
        up.setText(R.string.up);
        up.setId(R.id.up);

        down = new Button(this);
        down.setText(R.string.down);
        down.setId(R.id.down);

        SendInfo = new Button(this);
        SendInfo.setText(R.string.sendInfo);
        SendInfo.setId(R.id.sendInfo);

        pause = new Button(this);
        pause.setText(R.string.pause);
        pause.setId(R.id.pause);

        score = new TextView(this);
        score.setText(R.string.score);
        score.setId(R.id.score);
        score.setTextSize(30);

        difficultyToggle = new Button(this);
        difficultyToggle.setText(R.string.easy);
        difficultyToggle.setId(R.id.difficulty);


        //areas de texto
        gameTextArea = new RelativeLayout(this);
        textAreaSpecific = new EditText(this);
        textAreaSpecific.setText(R.string.ingrese_Texto);
        textAreaSpecific.setId(R.id.textArea);

        RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams rl2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams leftButton = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams rightButton = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams upButton = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams downRealButton = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams areaTextLayout = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams sendInfoButon = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams pausebutton = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams scoretext = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams speedbutton = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        gameButtons.setLayoutParams(rl);
        gameButtons.addView(left);
        gameButtons.addView(right);
        gameButtons.addView(up);
        gameButtons.addView(down);
        gameButtons.addView(textAreaSpecific);
        //----------------------------
        //gameTextArea.setLayoutParams(rl2);
        //gameTextArea.addView(textAreaSpecific);
        gameButtons.addView(SendInfo);
       // gameButtons.addView(pause);
        //gameButtons.addView(score);
        //gameButtons.addView(difficultyToggle);

        //----------------------------------------------------------------------------------

        //movimiento
        leftButton.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        leftButton.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);

        rightButton.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        rightButton.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);

        upButton.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        upButton.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

        downRealButton.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        downRealButton.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);

        areaTextLayout.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        areaTextLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        //----------------------------------------------------------------------------------
        sendInfoButon.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        sendInfoButon.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);

      //  pausebutton.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
      //  pausebutton.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);

      //  scoretext.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
       // scoretext.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);

        //  speedbutton.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        // speedbutton.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);

        //----------------------------------------------------------------------------------
        left.setLayoutParams(leftButton);
        right.setLayoutParams(rightButton);
        up.setLayoutParams(upButton);
        down.setLayoutParams(downRealButton);
        SendInfo.setLayoutParams(sendInfoButon);
        //pause.setLayoutParams(pausebutton);
        //score.setLayoutParams(scoretext);
        //difficultyToggle.setLayoutParams(speedbutton);
        textAreaSpecific.setLayoutParams(areaTextLayout);
        game.addView(drawView);
        game.addView(gameButtons);
        //game.addView(gameTextArea);
        setContentView(game);

        View leftButtonListener = findViewById(R.id.left);
        leftButtonListener.setOnClickListener(this);

        View rightButtonListener = findViewById(R.id.right);
        rightButtonListener.setOnClickListener(this);

        View upButtonListener = findViewById(R.id.up);
        upButtonListener.setOnClickListener(this);

        View downButtonListener = findViewById(R.id.down);
        downButtonListener.setOnClickListener(this);

        View sendInfoListener = findViewById(R.id.sendInfo);
        sendInfoListener.setOnClickListener(this);
        //----------------------------------------------------
     //   View textAreaListerner = findViewById(R.id.textArea);

       // View rotateACButtonListener = findViewById(R.id.rotate_ac);
        //rotateACButtonListener.setOnClickListener(this);

      //  View pauseButtonListener = findViewById(R.id.pause);
        //pauseButtonListener.setOnClickListener(this);

       // View speedButtonListener = findViewById(R.id.difficulty);
      //  speedButtonListener.setOnClickListener(this);


        // metodo para determinar el flujo del moviminento
        handler = new Handler(Looper.getMainLooper());
        loop = new Runnable() {
            public void run() {
                if (gameState.status) {
                    if (!gameState.pause) {
                        boolean success = true;
                        if (!success) {
                            //gameState.paintTetramino(new Tetramino(TetraminoType.SQUARE_SHAPED, 12222));
                            gameState.paintTetramino(new FiguraGeneral(TipoFiguraGeneral.ONLYSQUARE, 100000000));
                            // esta en 4, 6

                            //ingreso de coordenadas


                            //vreacion de paredes
                            FiguraGeneral tetramnino1 = new FiguraGeneral(TipoFiguraGeneral.HALLS, 8000);
                            Coordenada coordenas1 = new Coordenada(1, 10 );

                            //forma de pintar
                            gameState.paintWallsCoordinates(tetramnino1, coordenas1);

                            //pintar elemento movimiento
                            gameState.paintTetramino(gameState.falling);


                            System.out.println("aaaaaaaaaa");
                            System.out.println("a" + JuegoMovimiento.isTetraPresent(coordenas1, gameState.falling));
                            gameState.lineRemove();

                            //ingresa nuevos --------------------------------------------------------------------------------------------------------
                            gameState.pushNewTetramino(TipoFiguraGeneral.getRandomTetramino());
//----------------------------------------------------------------------------------------------------------------------------------
                            if (gameState.score % 10 == 9 && delay >= delayLowerLimit) {
                                delay = delay / delayFactor + 1;
                            }
                            gameState.incrementScore();
                        }
                        drawView.invalidate();
                        handler.postDelayed(this, delay);
                    } else {
                        handler.postDelayed(this, delay);
                    }
                } else {
                    pause.setText(R.string.start_new_game);
                }
            }

        };
        loop.run();


        SendInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                   // runAnaly();
                    //textAreaSpecific.setText("");
                    ingresoMoviminetos();
                    moviminetosPruba.clear();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //analisis
    public void runAnaly() throws Exception {
            System.out.println("analyze"+ "iniciando el analise");
            lexer lexema = new lexer(new StringReader(textAreaSpecific.getText().toString()));
            parser sintac = new parser(lexema);
            sintac.parse();
            try {
                System.out.println("prueba");
                for (int i =0; i < sintac.getListaMovimientos().size(); i++) {
                    double valoresMovimiento = sintac.getListaCantidadMovimientos().get(i);
                    movimientosHilo.add(new movimientoObjetos(sintac.getListaMovimientos().get(i),valoresMovimiento));
                    moviminetosPruba.add(movimientosHilo.get(i));
                   // System.out.println("tipo:"+sintac.getListMoveGame().get(i).getTipo());
                    //System.out.println("fila:"+sintac.getListMoveGame().get(i).getFila()+"columna:"+sintac.getListMoveGame().get(i).getColumna());
                }
                for (int i = 0; i <sintac.getListaMovimientos().size(); i++) {
                    System.out.println("tipo:"+sintac.getListaMovimientos().get(i));
                    System.out.println("tipo:"+sintac.getListaCantidadMovimientos().get(i));
                }
            } catch (Exception e ){
                e.printStackTrace();
            }

    }


    //metodo para la generacion del movimiento general

    public void ingresoMoviminetos(){
         //tipoIngreso =  new movimientoObjetos("down", 3);


        nombreValoresLista.add(4.0);
    //    nombreValoresLista.add(2.0);
        //nombreTiposLista.add(new String("down"));
        nombreTiposLista.add("right");
        moviminetosPruba.add(new movimientoObjetos("down", 1.0));
        //  tipoIngreso =  new movimientoObjetos("right", 2);
        moviminetosPruba.add(new movimientoObjetos("right", 2.0));
        movimientoObjetos(moviminetosPruba);
        //movimientosFInalesObjetos( nombreTiposLista, nombreValoresLista);
       // movimientosFInalesObjetosDefinitivo("down", 3.0);
      //  movimientosFInalesObjetosDefinitivo("right", 3.0);

       // movimientosFInalesObjetos(nombreTiposLista, nombreValoresLista);
      //  movimientosFInalesObjetosDefinitivo("down", 1.0);
       // movimientoObjetos(moviminetosPruba);


    }
//prueba


    public void movimientosFInalesObjetosDefinitivo(String tipo, Double valor) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        switch (tipo) {
                            case "up":
                                // ahora la cantidad de veces que se repite
                                for (int j =0 ;j < valor; j++) {
                                    gameState.moveFallingTetraminoUp();
                                    Thread.sleep(1000);
                                }
                                break;
                            case "down":
                                for (int j =0 ; j < valor; j++) {
                                    gameState.moveFallingTetraminoDown();
                                    Thread.sleep(1000);

                                }
                                break;
                            case "left":
                                for (int j =0 ; j <valor; j++) {
                                    gameState.moveFallingTetraminoLeft();
                                    Thread.sleep(1000);
                                }
                                break;
                            case "right":
                                for (int j =0 ; j < valor; j++) {
                                    gameState.moveFallingTetraminoRight();
                                    Thread.sleep(1000);
                                }
                                break;
                        }
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
        }).start();
    }

    //metodo para generar el movimiento de los objetos -------------------------------------
    public void movimientosFInalesObjetos(ArrayList<String> tipo, ArrayList<Double> valor) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0 ; i < tipo.size(); i++){
                    try {
                        switch (tipo.get(i)) {
                            case "up":
                                // ahora la cantidad de veces que se repite
                                for (int j =0 ;j < valor.size(); j++) {
                                    gameState.moveFallingTetraminoUp();
                                    Thread.sleep(1000);
                                }
                                break;
                            case "down":
                                for (int j =0 ; j < valor.size(); j++) {
                                    gameState.moveFallingTetraminoDown();
                                    Thread.sleep(1000);

                                }
                                break;
                            case "left":
                                for (int j =0 ; j <valor.size(); j++) {
                                    gameState.moveFallingTetraminoLeft();
                                    Thread.sleep(1000);
                                }
                                break;
                            case "right":
                                for (int j =0 ; j < valor.size(); j++) {
                                    gameState.moveFallingTetraminoRight();
                                    Thread.sleep(1000);
                                }
                                break;
                        }
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }
    public void movimientoObjetos(ArrayList<movimientoObjetos> movimientos) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (movimientoObjetos todosMovimientos: movimientos) {
                    try {
                        switch (todosMovimientos.getTipo()) {
                            case "up":
                                // ahora la cantidad de veces que se repite
                                for (int i =0 ; i < todosMovimientos.getValor(); i++) {
                                    gameState.moveFallingTetraminoUp();
                                    Thread.sleep(1000);
                                }
                                break;
                            case "down":
                                for (int i =0 ; i < todosMovimientos.getValor(); i++) {
                                    gameState.moveFallingTetraminoDown();
                                    Thread.sleep(1000);

                                }
                                break;
                            case "left":
                                for (int i =0 ; i < todosMovimientos.getValor(); i++) {
                                    gameState.moveFallingTetraminoLeft();
                                    Thread.sleep(1000);
                                }
                                break;
                            case "right":
                                for (int i =0 ; i < todosMovimientos.getValor(); i++) {
                                    gameState.moveFallingTetraminoRight();
                                    Thread.sleep(1000);
                                }
                                break;
                        }
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }

    //metodo para enviar info socket
    public void enviarInfoSocket(String texto) {
        socket enviarTextoInfo = new socket();
        enviarTextoInfo.execute(texto);
    }


    /// metodos de click
    @Override
    public void onClick(View action) {

        //ingresoMoviminetos();

        if (action == left) {
            gameState.moveFallingTetraminoLeft();
        } else if (action == right) {
            gameState.moveFallingTetraminoRight();
        } else if (action == up) {
            moviminetosPruba.add(new movimientoObjetos("down", 3.0));
            //  tipoIngreso =  new movimientoObjetos("right", 2);
            moviminetosPruba.add(new movimientoObjetos("right", 5.0));
            movimientoObjetos(moviminetosPruba);

        } else if (action == down) {
            gameState.moveFallingTetraminoDown();
        }

    }
}
