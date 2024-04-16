package TpV00;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game2048 extends JFrame implements ActionListener {
    RoundButton botonJugar, botonSalir;

    public Game2048() {
        setTitle("Juego"); //nombre de la ventana
        setSize(400, 400); // tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setResizable(false); 
        
        // Panel para colocar la imagen de fondo
        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar la imagen desde el paquete Resources	
                ImageIcon imagen = new ImageIcon(getClass().getResource("/Resources/fondo.jpg"));
                g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelFondo.setLayout(null); 

        botonJugar = new RoundButton("Jugar");
        botonJugar.setBounds(140, 158, 100, 30); // (x, y, ancho, alto)
        botonJugar.setBackground(Color.GREEN);
        botonJugar.addActionListener(this);
        botonJugar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonJugar.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonJugar.setBackground(Color.GREEN);
            }
        });

        botonSalir = new RoundButton("Salir");
        botonSalir.setBounds(140, 223, 100, 30); // (x, y, ancho, alto)
        botonSalir.setBackground(Color.GREEN);
        botonSalir.addActionListener(this);
        botonSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonSalir.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonSalir.setBackground(Color.GREEN);
            }
        });

        panelFondo.add(botonJugar);
        panelFondo.add(botonSalir);

        getContentPane().add(panelFondo);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonJugar) {
            // Acción al hacer clic en "Jugar"
            InterfazGrafica window = new InterfazGrafica();
            window.setVisible(true);
            dispose(); // Cierra la ventana actual
        } else if (e.getSource() == botonSalir) {
            // Acción al hacer clic en "Salir"
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Game2048 ventana = new Game2048();
        ventana.setVisible(true);
    }
}

class RoundButton extends JButton {
    public RoundButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.GREEN.darker());
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }
}

