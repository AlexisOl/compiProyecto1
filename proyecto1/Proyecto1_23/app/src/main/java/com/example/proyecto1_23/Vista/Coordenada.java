package com.example.proyecto1_23.Vista;

public class Coordenada {
    int y, x;

    Coordenada(int r, int c) {
        this.y = r;
        this.x = c;
    }

    static Coordenada add(Coordenada A, Coordenada B) {
        return new Coordenada(A.y + B.y, A.x + B.x);
    }

    static Coordenada sub(Coordenada A, Coordenada B) {
        return new Coordenada(A.y - B.y, A.x - B.x);
    }

    static Coordenada rotateAntiClock(Coordenada X) {

        return new Coordenada(-X.x, X.y);
    }

    static boolean isEqual(Coordenada A, Coordenada B) {

        return A.y == B.y && A.x == B.x;
    }
}
