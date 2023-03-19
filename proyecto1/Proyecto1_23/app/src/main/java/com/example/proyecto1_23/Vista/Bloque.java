package com.example.proyecto1_23.Vista;

public class Bloque {

    int colour;
    int tetraId;
    Coordenada coordinate;
    BloqueEstados state;

    Bloque(int row, int column) {
        this.colour = -1;
        this.tetraId = -1;
        this.coordinate = new Coordenada(row, column);
        this.state = BloqueEstados.ON_EMPTY;
    }

    Bloque(int colour, int tetraId, Coordenada coordinate, BloqueEstados state) {
        this.colour = colour;
        this.tetraId = tetraId;
        this.coordinate = coordinate;
        this.state = state;

    }

    Bloque copy() {

        return new Bloque(colour, tetraId, coordinate, state);
    }

    void set(Bloque B) {
        this.colour = B.colour;
        this.tetraId = B.tetraId;
        this.coordinate.y = B.coordinate.y;
        this.coordinate.x = B.coordinate.x;
        this.state = B.state;

    }

    void setEmptyBlock(Coordenada coordinate) {
        this.colour = -1;
        this.tetraId = -1;
        this.coordinate.x = coordinate.x;
        this.coordinate.y = coordinate.y;
        this.state = BloqueEstados.ON_EMPTY;

    }

    public Coordenada getCoordinate() {
        return coordinate;
    }
}