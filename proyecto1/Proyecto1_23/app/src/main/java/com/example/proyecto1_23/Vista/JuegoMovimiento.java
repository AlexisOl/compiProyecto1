package com.example.proyecto1_23.Vista;

import android.util.SparseArray;

public class JuegoMovimiento {

    boolean status;
    int score;
    boolean pause;
    Bloque[][] board;

    // tetramino
    FiguraGeneral falling;


    //generacion de tetraminos
    FiguraGeneral[] paredes;


    boolean difficultMode;

    // elementos de tamanio
    private int rows;
    private int columns;
    private Integer ctr;
    private SparseArray<FiguraGeneral> tetraminos;

    JuegoMovimiento(int rows, int columns, TipoFiguraGeneral fallingTetraminoType) {

        this.rows = rows;
        this.columns = columns;
        this.pause = false;
        ctr = 0;
        score = 0;
        this.status = true;
        difficultMode = false;


        //generacion de canvas
        board = new Bloque[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                board[row][column] = new Bloque(row, column);
            }
        }

        tetraminos = new SparseArray<>();
        falling = new FiguraGeneral(fallingTetraminoType, this.ctr);
        tetraminos.put(this.ctr, falling);
    }

    //metodo de elemento base
    private Bloque getCoordinateBlock(Coordenada coordinate) {
        return this.board[coordinate.y][coordinate.x];
    }

    //metodo hay problemas
    private boolean isConflicting(Coordenada coordinate) {
        if (coordinate.x < 0 || coordinate.x >= this.columns || coordinate.y < 0 || coordinate.y >= this.rows)
            return true;
        return this.getCoordinateBlock(coordinate).state == BloqueEstados.ON_TETRAMINO;

    }

    // se puede trasladar
    private boolean canTetraminoDisplace(FiguraGeneral tetramino, Coordenada displacement) {

        for (Bloque block : tetramino.blocks) {
            if (block.state == BloqueEstados.ON_TETRAMINO) {
                Coordenada shifted = Coordenada.add(block.coordinate, displacement);
                if (isConflicting(shifted)) {
                    return false;
                }
            }
        }
        return true;
    }


    //MOVIMIENTOS -----------------------------------------
    boolean moveFallingTetraminoDown() {

        if (canTetraminoDisplace(falling, new Coordenada(1, 0))) {
            falling.moveDown();
            return true;
        } else {
            return false;
        }

    }
    boolean moveFallingTetraminoUp() {

        if (canTetraminoDisplace(falling, new Coordenada(-1, 0))) {
            falling.moveUp();
            return true;
        } else {
            return false;
        }
    }

    boolean moveFallingTetraminoLeft() {
// para momiviente continuo solo hacer loop de n veces
        if (canTetraminoDisplace(falling, new Coordenada(0, -1))) {
            falling.moveLeft();
            return true;
        } else {
            return false;
        }
    }

    boolean moveFallingTetraminoRight() {

        if (canTetraminoDisplace(falling, new Coordenada(0, 1))) {
            falling.moveRight();
            return true;
        } else {
            return false;
        }
    }
    //-------------------------------------


//-------------------------------------

    //pinta el tetramino fjio individual
    void paintWallsCoordinates(FiguraGeneral tetramino, Coordenada coordinates){
        for (Bloque block: tetramino.blocks) {
            if (block.state == BloqueEstados.ON_EMPTY) {
                continue;
            }
            this.getCoordinateBlock(coordinates).set(block);
        }
    }

    //etodo para generar un tetramino ahora como tenemos coordenadas solo verificar si no es pared
    void paintTetramino(FiguraGeneral tetramino) {
        for (Bloque block : tetramino.blocks) {
            if (block.state == BloqueEstados.ON_EMPTY)
                continue;
            this.getCoordinateBlock(block.coordinate).set(block);
        }
    }

    void pushNewTetramino(TipoFiguraGeneral tetraminoType) {
        this.ctr++;

        falling = new FiguraGeneral(tetraminoType, this.ctr);
        this.tetraminos.put(this.ctr, falling);
        for (Bloque block : falling.blocks) {
            if (this.getCoordinateBlock(block.coordinate).state == BloqueEstados.ON_TETRAMINO)
                this.status = false;
        }
    }

    void incrementScore() {
        this.score++;
    }


    void elementosTetraminos(Coordenada[] coordenadas){
        //ingreso de elementos de matriz
        for (int rows =0; rows< this.rows; rows++){
            for (int column =0; column < this.columns; column++){

            }
        }
    }
    //moviemiento de linea

    void lineRemove() {
        boolean removeLines;
        do {
            removeLines = false;
            for (int row = this.rows - 1; row >= 0; row--) {
                boolean rowIsALine = true;
                for (int column = 0; column < this.columns; column++) {
                    if (this.board[row][column].state != BloqueEstados.ON_TETRAMINO) {
                        rowIsALine = false;
                        break;
                    }
                }
                if (!rowIsALine) {
                    continue;
                }

                for (int column = 0; column < this.columns; column++) {
                    FiguraGeneral tetramino = this.tetraminos.get((this.board[row][column].tetraId));

                    Bloque blockToClear = this.board[row][column];
                    blockToClear.setEmptyBlock(blockToClear.coordinate);

                    if (tetramino == null) {
                        continue;
                    }

                    for (Bloque block : tetramino.blocks) {
                        if (block.state == BloqueEstados.ON_EMPTY) {
                            continue;
                        }

                        if (block.coordinate.y == row && block.coordinate.x == column) {
                            block.state = BloqueEstados.ON_EMPTY;

                            this.ctr++;
                            FiguraGeneral upperTetramino = tetramino.copy(this.ctr);
                            this.tetraminos.put(this.ctr, upperTetramino);
                            for (Bloque upperBlock : upperTetramino.blocks) {
                                if (upperBlock.coordinate.y >= block.coordinate.y) {
                                    upperBlock.state = BloqueEstados.ON_EMPTY;
                                } else {
                                    this.getCoordinateBlock(upperBlock.coordinate).tetraId = upperBlock.tetraId;
                                }
                            }

                            this.ctr++;
                            FiguraGeneral lowerTetramino = tetramino.copy(this.ctr);
                            this.tetraminos.put(this.ctr, lowerTetramino);
                            for (Bloque lowerBlock : lowerTetramino.blocks) {
                                if (lowerBlock.coordinate.y <= block.coordinate.y) {
                                    lowerBlock.state = BloqueEstados.ON_EMPTY;
                                } else {
                                    this.getCoordinateBlock(lowerBlock.coordinate).tetraId = lowerBlock.tetraId;
                                }
                            }

                            this.tetraminos.remove(block.tetraId);
                            break;
                        }
                    }
                }
                this.adjustTheMatrix();
                this.incrementScore();
                removeLines = true;
                break;
            }
        } while (removeLines);
    }

    public void determinarBordes() {

    }

    private void adjustTheMatrix() {
        for (int row = this.rows - 1; row >= 0; row--) {
            for (int column = 0; column < this.columns; column++) {
                FiguraGeneral T = (this.tetraminos).get((this.board[row][column].tetraId));

                if (T != null)
                    this.shiftTillBottom(T);
            }
        }
    }

    private void shiftTillBottom(FiguraGeneral tetramino) {
        boolean shiftTillBottom;
        do {
            boolean shouldShiftDown = true;
            shiftTillBottom = false;


            /// para todos los bloques si no tienen nada
            for (Bloque block : tetramino.blocks) {
                if (block.state == BloqueEstados.ON_EMPTY)
                    continue;

                Coordenada newCoordinate = Coordenada.add(block.coordinate, new Coordenada(1, 0));

                if (isTetraPresent(newCoordinate, tetramino))
                    continue;

                if (isConflicting(newCoordinate))
                    shouldShiftDown = false;
            }

            if (shouldShiftDown) {
                for (Bloque block : tetramino.blocks) {
                    if (block.state == BloqueEstados.ON_EMPTY)
                        continue;

                    this.getCoordinateBlock(block.coordinate).setEmptyBlock(block.coordinate);


                    block.coordinate.y++;
                }

                for (Bloque block : tetramino.blocks) {
                    if (block.state == BloqueEstados.ON_EMPTY)
                        continue;

                    this.getCoordinateBlock(block.coordinate).set(block);

                }
                shiftTillBottom = true;
            }
        } while (shiftTillBottom);
    }

    //metod que determine coodernaass de paredes


    //determina si hay algo presente
    public static boolean isTetraPresent(Coordenada coordinate, FiguraGeneral tetramino) {
        for (Bloque block : tetramino.blocks) {
            if (block.state == BloqueEstados.ON_EMPTY)
                continue;
            if (Coordenada.isEqual(block.coordinate, coordinate)){
                System.out.println("si hat");
                return true;
            }
        }
        return false;
    }
}
