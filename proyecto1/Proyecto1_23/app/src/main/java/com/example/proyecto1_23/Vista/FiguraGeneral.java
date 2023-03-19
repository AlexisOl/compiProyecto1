package com.example.proyecto1_23.Vista;

public class FiguraGeneral {
    Bloque[] blocks;
    TipoFiguraGeneral type;

    FiguraGeneral(TipoFiguraGeneral type, int tetraId) {
        Coordenada[] coordinates;

        switch (type) {
            case ONLYSQUARE:
                coordinates = new Coordenada[]{
                        new Coordenada(0, 0),
                };
                blocks = this.blocksGenerator(tetraId, 3, coordinates);
                break;
            case HALLS:
                coordinates = new Coordenada[] {
                        new Coordenada(0, 2)
                };
                blocks = this.blocksGenerator(tetraId, 5, coordinates);
                break;
            case SQUARE_SHAPED:
                coordinates = new Coordenada[]{
                        new Coordenada(0, 10),
                        new Coordenada(1, 10),
                        new Coordenada(1, 11),
                        new Coordenada(0, 11)
                };
                blocks = this.blocksGenerator(tetraId, 1, coordinates);
                break;
        }
    }

    private FiguraGeneral(Bloque[] blocks) {

        this.blocks = blocks;
    }

    private Bloque[] blocksGenerator(int tetraId, int colour, Coordenada[] coordinates) {
        Bloque[] blocks = new Bloque[coordinates.length];
        for (int itr = 0; itr < coordinates.length; itr++) {
            blocks[itr] = new Bloque(colour, tetraId, coordinates[itr], BloqueEstados.ON_TETRAMINO);
        }
        return blocks;
    }

    FiguraGeneral copy(int tetraId) {
        Bloque[] newBlocks = new Bloque[this.blocks.length];
        for (int itr = 0; itr < this.blocks.length; itr++) {
            newBlocks[itr] = this.blocks[itr].copy();
            newBlocks[itr].tetraId = tetraId;
        }
        return new FiguraGeneral(newBlocks);
    }


    //movimientos de figuras
    void moveDown() {
        for (Bloque block : blocks) {
            block.coordinate.y++;
        }
    }

    void moveUp() {
        for (Bloque block : blocks) {
            block.coordinate.y--;
        }
    }

    void moveLeft() {
        for (Bloque block : blocks) {
            block.coordinate.x--;
        }
    }
    void moveRight() {

        for (Bloque block : blocks) {
            block.coordinate.x++;
        }
    }
}
