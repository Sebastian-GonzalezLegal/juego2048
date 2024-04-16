package TpV00;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Juego {
    private Tablero tablero;
    private int puntaje;
    private boolean gameOver;
    private int record;

    public Juego() {
        tablero = new Tablero(new int[4][4]);
        puntaje = 0;
        gameOver = false;
        record= this.leerTxtRecord();
        iniciarJuego();
    }
    
    //metodos publicos
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
                    	combinarCeldaArribaAbajo(fila, j, i);
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
                    	combinarCeldaArribaAbajo(fila, j, i);
                    } else {
                        // Mueve la celda hacia abajo
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
                    	combinarCeldaIzqDer(columna, j, i);
                    } else {
                        // Mueve la celda hacia la izquierda
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
                    	combinarCeldaIzqDer(columna, j, i);
                    } else {
                        // Mueve la celda hacia la derecha
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
    	setGameOver();
        return gameOver;
    }

    public boolean youWin() {
        return tablero.algunaCeldaLlegoa2048();
    }
    
    public int getRecord() {
    	return this.generarYGuardarRecord();
    }
    
    public int leerTxtRecord() {
   	 String ruta="src/Resources/record.txt";
        try (FileReader fr = new FileReader(ruta)) {
             BufferedReader br = new BufferedReader(fr);
             // Lectura del txt
             record = Integer.parseInt(br.readLine());
         }
          catch(Exception e){
             e.printStackTrace();
          }
        System.out.println(record);
        return record;
   }
   
    public void editarTxtRecord() {
    	try{
			PrintWriter writer = new PrintWriter(new FileWriter("src/Resources/record.txt",false));
			writer.append(String.valueOf(this.record));
			writer.close();
			System.out.println("Se escribió correctamente en el archivo.");
		}catch(Exception e){
			System.out.println("Error añadiendo datos al fichero");}
    }
    
    //Metodos Privados
    
    private void iniciarJuego() {
        // Inicializa la cuadrícula con dos números aleatorios al inicio del juego
        tablero.agregarNumero();
        tablero.agregarNumero();
    }
    
    private void combinarCeldaArribaAbajo(int fila, int j, int i) {
        tablero.setValorCelda(fila, j, 2 * tablero.valorCelda(i, j));
        puntaje += tablero.valorCelda(fila, j);
        tablero.setValorCelda(i, j, 0);
    }
    
    private void combinarCeldaIzqDer(int columna, int j, int i) {
        tablero.setValorCelda(i, columna, 2 * tablero.valorCelda(i, j));
        puntaje += tablero.valorCelda(i, columna);
        tablero.setValorCelda(i, j, 0);
    }
    
    //setea el gameOver segun la disponibilidad del tablero o las posibilidades de movimiento del jugador
    private void setGameOver() {
    	if(tablero.hayEspacioVacios() || tablero.hayMovPosible()) {
    		gameOver = false;
    	}else {
    		gameOver = true;
    	}
    }
    
    private int generarYGuardarRecord(){
    	if(this.record  < this.puntaje) {
    		this.record=this.puntaje;
            this.editarTxtRecord();
    	}
    	return this.record;
	} 

}
