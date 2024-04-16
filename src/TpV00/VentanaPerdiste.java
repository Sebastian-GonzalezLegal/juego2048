package TpV00;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VentanaPerdiste {

    private JFrame ventana;
	private ClaseSonido sonido;
	private int record;
	private int puntaje;

    public VentanaPerdiste(int record, int puntaje) {
    	this.record=record;
    	this.puntaje=puntaje;
        ventana = new JFrame("Juego");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 200);
        ventana.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 

		sonido = new ClaseSonido("src/Resources/sonidoPerderWav.wav");
		sonido.play();

        JButton botonSi = new JButton("Sí");
        JButton botonNo = new JButton("No");

        // Establece un borde negro y fondo verde para los botones
        Border bordeNegro = BorderFactory.createLineBorder(Color.BLACK, 2);
        botonSi.setBorder(BorderFactory.createCompoundBorder(bordeNegro, BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        botonNo.setBorder(BorderFactory.createCompoundBorder(bordeNegro, BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        botonSi.setBackground(Color.GREEN);
        botonNo.setBackground(Color.GREEN);

        botonSi.addActionListener(e -> {
            ventana.dispose(); // Cierra la ventana actual
            iniciarJuego(); // Vuelve a iniciar el juego
        });

        botonNo.addActionListener(e -> {
            System.exit(0);
        });

        //añade un componente de relleno en la parte superior
        panel.add(Box.createVerticalGlue());

        //mensaje centrado
        JLabel PuntajeActual = new JLabel("Tu puntaje fue de: " + puntaje);
        panel.add(PuntajeActual);
        
        JLabel RecordActual = new JLabel("El record es de: " + record);
        panel.add(RecordActual);
        
        JLabel mensajeLabel_1 = new JLabel("Perdiste!, ¿Quieres volver a jugar?");
        panel.add(mensajeLabel_1);
        
        //espacio entre el mensaje y el primer botón
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        //botones centrados
        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        botonesPanel.add(botonSi);
        botonesPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Espacio horizontal entre botones
        botonesPanel.add(botonNo);
        panel.add(botonesPanel);

        //componente de relleno en la parte inferior
        panel.add(Box.createVerticalGlue());

        ventana.getContentPane().add(panel);
        ventana.setVisible(true);
    }


    public void mostrarVentana() {
        ventana.setVisible(true);
    }
    
    private void iniciarJuego() {
        // Cierra todas las ventanas
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            window.dispose();
        }

        // Abre una nueva instancia de InterfazGrafica
        InterfazGrafica window = new InterfazGrafica();
        window.setVisible(true);
    }
}

