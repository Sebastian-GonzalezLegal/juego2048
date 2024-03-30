package TpV00;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego {
    public int[][] cuadricula;
    private int puntaje;
    private boolean gameOver;
    private Random random;

    public Juego() {
        cuadricula = new int[4][4];
        puntaje = 0;
        gameOver = false;
        random = new Random();
        iniciarJuego();
    }

    private void iniciarJuego() {
        // Inicializa la cuadrícula con dos números aleatorios al inicio del juego
        agregarNumero();
        agregarNumero();
    }

    public  void agregarNumero() {
        // Lista de todas las celdas vacías
        List<int[]> celdasVacias = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (cuadricula[i][j] == 0) {
                    celdasVacias.add(new int[]{i, j});
                }
            }
        }

        // Si hay celdas vacías, elige una aleatoriamente y agrega un nuevo número (2 o 4)
        if (!celdasVacias.isEmpty()) {
            int indiceAleatorio = random.nextInt(celdasVacias.size());
            int[] celda = celdasVacias.get(indiceAleatorio);
            int fila = celda[0];
            int columna = celda[1];
            cuadricula[fila][columna] = (random.nextDouble() < 0.9) ? 2 : 4; // Probabilidad del 90% para el 2 y 10% para el 4
        }
    }

    public void moverArriba() {
        // Implementa la lógica para mover los números hacia arriba
        // ...
    }

    public void moverAbajo() {
        // Implementa la lógica para mover los números hacia abajo
        // ...
    }

    public void moverIzquierda() {
        // Implementa la lógica para mover los números hacia la izquierda
        // ...
    }

    public void moverDerecha() {
        // Implementa la lógica para mover los números hacia la derecha
        // ...
    }

    public int[][] getCuadricula() {
        return cuadricula;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public boolean isGameOver() {
        return gameOver;
    }

}
