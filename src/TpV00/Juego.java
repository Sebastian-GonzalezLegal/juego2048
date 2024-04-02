package TpV00;

public class Juego {
    private Tablero tablero;
    private int puntaje;
    private boolean gameOver;

    public Juego() {
        tablero = new Tablero(new int[4][4]);
        puntaje = 0;
        gameOver = false;
        iniciarJuego();
    }

    private void iniciarJuego() {
        // Inicializa la cuadrícula con dos números aleatorios al inicio del juego
        tablero.agregarNumero();
        tablero.agregarNumero();
    }

    public void moverArriba() {
        for (int j = 0; j < 4; j++) {
            // recorre las filas desde la primera fila a la ultima
            for (int i = 1; i < 4; i++) {
                if (tablero.valorCelda(i, j) != 0) {
                    int fila = i - 1;
                    while (fila >= 0 && tablero.valorCelda(fila, j) == 0) {
                        fila--;
                    }
                    // Comprueba si las celdas se pueden combinar
                    if (fila >= 0 && tablero.valorCelda(fila, j) == tablero.valorCelda(i, j)) {
                        // Combina las celdas y actualiza el puntaje
                        tablero.setValorCelda(fila, j, 2 * tablero.valorCelda(i, j));
                        if (puntaje < tablero.valorCelda(fila, j)) {
                            puntaje = tablero.valorCelda(fila, j);
                        }
                        tablero.setValorCelda(i, j, 0);
                    } else {
                        // Mueve la celda hacia arriba
                        tablero.setValorCelda(fila + 1, j, tablero.valorCelda(i, j));
                        if (fila + 1 != i) {
                            tablero.setValorCelda(i, j, 0);
                        }
                    }
                }
            }
        }
        tablero.agregarNumero();
    }

    public void moverAbajo() {
        for (int j = 0; j < 4; j++) {
            // recorre las filas desde la cuarta fila a la 1ra
            for (int i = 3; i >= 0; i--) {
                if (tablero.valorCelda(i, j) != 0) {
                    int fila = i + 1;
                    while (fila < 4 && tablero.valorCelda(fila, j) == 0) {
                        fila++;
                    }
                    // Comprueba si las celdas se pueden combinar
                    if (fila < 4 && tablero.valorCelda(fila, j) == tablero.valorCelda(i, j)) {
                        // Combina las celdas y actualiza el puntaje
                        tablero.setValorCelda(fila, j, 2 * tablero.valorCelda(i, j));
                        if (puntaje < tablero.valorCelda(fila, j)) {
                            puntaje = tablero.valorCelda(fila, j);
                        }
                        tablero.setValorCelda(i, j, 0);
                    } else {
                        // Mueve la celda hacia arriba
                        tablero.setValorCelda(fila - 1, j, tablero.valorCelda(i, j));
                        if (fila - 1 != i) {
                            tablero.setValorCelda(i, j, 0);
                        }
                    }
                }
            }
        }
        tablero.agregarNumero();
    }

    public void moverIzquierda() {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (tablero.valorCelda(i, j) != 0) {
                    int columna = j - 1;
                    while (columna >= 0 && tablero.valorCelda(i, columna) == 0) {
                        columna--;
                    }
                    // Comprueba si las celdas se pueden combinar
                    if (columna >= 0 && tablero.valorCelda(i, columna) == tablero.valorCelda(i, j)) {
                        // Combina las celdas y actualiza el puntaje
                        tablero.setValorCelda(i, columna, 2 * tablero.valorCelda(i, j));
                        if (puntaje < tablero.valorCelda(i, columna)) {
                            puntaje = tablero.valorCelda(i, columna);
                        }
                        tablero.setValorCelda(i, j, 0);
                    } else {
                        // Mueve la celda hacia arriba
                        tablero.setValorCelda(i, columna + 1, tablero.valorCelda(i, j));
                        if (columna + 1 != j) {
                            tablero.setValorCelda(i, j, 0);
                        }
                    }
                }
            }
        }
        tablero.agregarNumero();
    }

    public void moverDerecha() {
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j >= 0; j--) {
                if (tablero.valorCelda(i, j) != 0) {
                    int columna = j + 1;
                    while (columna < 4 && tablero.valorCelda(i, columna) == 0) {
                        columna++;
                    }
                    // Comprueba si las celdas se pueden combinar
                    if (columna < 4 && tablero.valorCelda(i, columna) == tablero.valorCelda(i, j)) {
                        // Combina las celdas y actualiza el puntaje
                        tablero.setValorCelda(i, columna, 2 * tablero.valorCelda(i, j));
                        if (puntaje < tablero.valorCelda(i, columna)) {
                            puntaje = tablero.valorCelda(i, columna);
                        }
                        tablero.setValorCelda(i, j, 0);
                    } else {
                        // Mueve la celda hacia arriba
                        tablero.setValorCelda(i, columna - 1, tablero.valorCelda(i, j));
                        if (columna - 1 != j) {
                            tablero.setValorCelda(i, j, 0);
                        }
                    }
                }
            }
        }
        tablero.agregarNumero();
    }

    public int valorCelda(int i, int j) {
        return tablero.valorCelda(i, j);
    }

    public int getPuntaje() {
        return puntaje;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean youWin() {
        return puntaje == 32;
    }

}
