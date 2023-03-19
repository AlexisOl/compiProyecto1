package com.example.proyecto1_23.Vista;

import java.util.Random;

public enum TipoFiguraGeneral {
    ONLYSQUARE,
    SQUARE_SHAPED;

    private static final TipoFiguraGeneral[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static TipoFiguraGeneral getRandomTetramino() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}