package TpV00;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class InterfazGrafica extends JFrame {

    private JPanel contentPane;
    private JTextField celda5;
    private JTextField celda1;
    private JTextField celda2;
    private JTextField celda3;
    private JTextField celda4;
    private JTextField celda7;
    private JTextField celda6;
    private JTextField celda10;
    private JTextField celda8;
    private JTextField celda9;
    private JTextField celda11;
    private JTextField celda13;
    private JTextField celda12;
    private JTextField celda14;
    private JTextField celda15;
    private JTextField celda16;
    private Juego juego;
    private JMenuBar menuBar;
    private JTextField puntaje;
    private JTextField textField_1;

    public InterfazGrafica() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 785, 494);

        iniciarComponentes();
        juego = new Juego(); // Inicializa el juego
        actualizarInterfaz(); // Actualiza la interfaz gráfica inicial

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == 'w' && !(juego.youWin())) {
                    juego.moverArriba();
                } else if (e.getKeyChar() == 's' && !(juego.youWin())) {
                    juego.moverAbajo();
                } else if (e.getKeyChar() == 'a' && !(juego.youWin())) {
                    juego.moverIzquierda();
                } else if (e.getKeyChar() == 'd' && !(juego.youWin())) {
                    juego.moverDerecha();
                }

                // Actualiza la interfaz gráfica después de mover
                actualizarInterfaz();
            }
        });
        this.setFocusable(true);
    }

    private void iniciarComponentes() {

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        puntaje = new JTextField();
        puntaje.setText("Puntos: ");
        puntaje.setHorizontalAlignment(SwingConstants.CENTER);
        puntaje.setEditable(false);
        puntaje.setFont(new Font("Tahoma", Font.PLAIN, 22));
        menuBar.add(puntaje);
        puntaje.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setEditable(false);
        menuBar.add(textField_1);
        textField_1.setColumns(10);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(4, 4, 10, 10));

        celda1 = new JTextField();
        celda1.setBackground(new Color(192, 192, 192));
        celda1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda1.setHorizontalAlignment(SwingConstants.CENTER);
        celda1.setEditable(false);
        celda1.setColumns(10);
        contentPane.add(celda1);

        celda2 = new JTextField();
        celda2.setBackground(new Color(192, 192, 192));
        celda2.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda2.setHorizontalAlignment(SwingConstants.CENTER);
        celda2.setEditable(false);
        celda2.setColumns(10);
        contentPane.add(celda2);

        celda3 = new JTextField();
        celda3.setBackground(new Color(192, 192, 192));
        celda3.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda3.setHorizontalAlignment(SwingConstants.CENTER);
        celda3.setEditable(false);
        celda3.setColumns(10);
        contentPane.add(celda3);

        celda4 = new JTextField();
        celda4.setBackground(new Color(192, 192, 192));
        celda4.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda4.setHorizontalAlignment(SwingConstants.CENTER);
        celda4.setEditable(false);
        celda4.setColumns(10);
        contentPane.add(celda4);

        celda5 = new JTextField();
        celda5.setBackground(new Color(192, 192, 192));
        celda5.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda5.setHorizontalAlignment(SwingConstants.CENTER);
        celda5.setEditable(false);
        contentPane.add(celda5);
        celda5.setColumns(10);

        celda6 = new JTextField();
        celda6.setBackground(new Color(192, 192, 192));
        celda6.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda6.setHorizontalAlignment(SwingConstants.CENTER);
        celda6.setEditable(false);
        celda6.setColumns(10);
        contentPane.add(celda6);

        celda7 = new JTextField();
        celda7.setBackground(new Color(192, 192, 192));
        celda7.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda7.setHorizontalAlignment(SwingConstants.CENTER);
        celda7.setEditable(false);
        celda7.setColumns(10);
        contentPane.add(celda7);

        celda8 = new JTextField();
        celda8.setBackground(new Color(192, 192, 192));
        celda8.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda8.setHorizontalAlignment(SwingConstants.CENTER);
        celda8.setEditable(false);
        celda8.setColumns(10);
        contentPane.add(celda8);

        celda9 = new JTextField();
        celda9.setBackground(new Color(192, 192, 192));
        celda9.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda9.setHorizontalAlignment(SwingConstants.CENTER);
        celda9.setEditable(false);
        celda9.setColumns(10);
        contentPane.add(celda9);

        celda10 = new JTextField();
        celda10.setBackground(new Color(192, 192, 192));
        celda10.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda10.setHorizontalAlignment(SwingConstants.CENTER);
        celda10.setEditable(false);
        celda10.setColumns(10);
        contentPane.add(celda10);

        celda11 = new JTextField();
        celda11.setBackground(new Color(192, 192, 192));
        celda11.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda11.setHorizontalAlignment(SwingConstants.CENTER);
        celda11.setEditable(false);
        celda11.setColumns(10);
        contentPane.add(celda11);

        celda12 = new JTextField();
        celda12.setBackground(new Color(192, 192, 192));
        celda12.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda12.setHorizontalAlignment(SwingConstants.CENTER);
        celda12.setEditable(false);
        celda12.setColumns(10);
        contentPane.add(celda12);

        celda13 = new JTextField();
        celda13.setBackground(new Color(192, 192, 192));
        celda13.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda13.setHorizontalAlignment(SwingConstants.CENTER);
        celda13.setEditable(false);
        celda13.setColumns(10);
        contentPane.add(celda13);

        celda14 = new JTextField();
        celda14.setBackground(new Color(192, 192, 192));
        celda14.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda14.setHorizontalAlignment(SwingConstants.CENTER);
        celda14.setEditable(false);
        celda14.setColumns(10);
        contentPane.add(celda14);

        celda15 = new JTextField();
        celda15.setBackground(new Color(192, 192, 192));
        celda15.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda15.setHorizontalAlignment(SwingConstants.CENTER);
        celda15.setEditable(false);
        celda15.setColumns(10);
        contentPane.add(celda15);

        celda16 = new JTextField();
        celda16.setBackground(new Color(192, 192, 192));
        celda16.setFont(new Font("Tahoma", Font.PLAIN, 22));
        celda16.setHorizontalAlignment(SwingConstants.CENTER);
        celda16.setEditable(false);
        celda16.setColumns(10);
        contentPane.add(celda16);
    }

    private void actualizarInterfaz() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int valor = juego.valorCelda(i, j);
                // Calcula el índice correspondiente en la lista de JTextFields
                int indice = i * 4 + j;
                // Obtiene el JTextField correspondiente
                JTextField textField = (JTextField) contentPane.getComponent(indice);
                // Actualiza el texto del JTextField con el valor de la cuadrícula
                if (valor != 0) {
                    textField.setText(String.valueOf(valor));
                } else {
                    textField.setText(""); // Muestra una cadena vacía en lugar de 0
                }
            }
        }

        int puntos = juego.getPuntaje();
        puntaje.setText("Puntos: " + String.valueOf(puntos));
        if (juego.youWin()) {
            JOptionPane.showMessageDialog(null, "GANASTE!", "Pantalla de victoria", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
