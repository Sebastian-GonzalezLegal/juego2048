package TpV00;

import java.util.ArrayList;
import java.util.Random;

public class Tablero {
	private int[][] tablero;
	private Random random = new Random();
	
	public Tablero(int[][] tablero) {
		this.tablero = tablero;
	}
    public  void agregarNumero() {
        // Lista de todas las celdas vacías
        ArrayList<int[]> celdasVacias = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tablero[i][j] == 0) {
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
            tablero[fila][columna] = (random.nextDouble() < 0.8) ? 2 : 4; // Probabilidad del 80% para el 2 y 20% para el 4
        }
    }
    
    public int valorCelda(int i,int j) {
    	return tablero[i][j];
    }
    
    public void setValorCelda(int fila, int columna, int valor) {
    	tablero[fila][columna]=valor;
    }
}
