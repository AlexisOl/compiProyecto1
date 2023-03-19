package com.example.proyecto1_23.Vista;

import java.util.Random;

public enum TipoFiguraGeneral {
    ONLYSQUARE,
    SQUARE_SHAPED,
    T_SHAPED,
    L_SHAPED,
    LINE_SHAPED,
    Z_SHAPED,
    INV_L_SHAPED,
    HALLS,
    INV_Z_SHAPED;

    private static final TipoFiguraGeneral[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static TipoFiguraGeneral getRandomTetramino() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}