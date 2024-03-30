package TpV00;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class InterfazGrafica extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JTextField textField_15;
    private Juego juego;

    public InterfazGrafica() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 670, 461);
        
        
        iniciarComponentes(); 
        juego = new Juego(); // Inicializa el juego
        actualizarInterfaz(); // Actualiza la interfaz gráfica inicial
    }
    
    private void iniciarComponentes() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(4, 4, 5, 5));
        
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
        textField_1.setEditable(false);
        textField_1.setColumns(10);
        contentPane.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_2.setHorizontalAlignment(SwingConstants.CENTER);
        textField_2.setEditable(false);
        textField_2.setColumns(10);
        contentPane.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_3.setHorizontalAlignment(SwingConstants.CENTER);
        textField_3.setEditable(false);
        textField_3.setColumns(10);
        contentPane.add(textField_3);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_4.setHorizontalAlignment(SwingConstants.CENTER);
        textField_4.setEditable(false);
        textField_4.setColumns(10);
        contentPane.add(textField_4);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setEditable(false);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_6.setHorizontalAlignment(SwingConstants.CENTER);
        textField_6.setEditable(false);
        textField_6.setColumns(10);
        contentPane.add(textField_6);
        
        textField_5 = new JTextField();
        textField_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_5.setHorizontalAlignment(SwingConstants.CENTER);
        textField_5.setEditable(false);
        textField_5.setColumns(10);
        contentPane.add(textField_5);
        
        textField_8 = new JTextField();
        textField_8.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_8.setHorizontalAlignment(SwingConstants.CENTER);
        textField_8.setEditable(false);
        textField_8.setColumns(10);
        contentPane.add(textField_8);
        
        textField_9 = new JTextField();
        textField_9.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_9.setHorizontalAlignment(SwingConstants.CENTER);
        textField_9.setEditable(false);
        textField_9.setColumns(10);
        contentPane.add(textField_9);
        
        textField_7 = new JTextField();
        textField_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_7.setHorizontalAlignment(SwingConstants.CENTER);
        textField_7.setEditable(false);
        textField_7.setColumns(10);
        contentPane.add(textField_7);
        
        textField_10 = new JTextField();
        textField_10.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_10.setHorizontalAlignment(SwingConstants.CENTER);
        textField_10.setEditable(false);
        textField_10.setColumns(10);
        contentPane.add(textField_10);
        
        textField_12 = new JTextField();
        textField_12.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_12.setHorizontalAlignment(SwingConstants.CENTER);
        textField_12.setEditable(false);
        textField_12.setColumns(10);
        contentPane.add(textField_12);
        
        textField_11 = new JTextField();
        textField_11.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_11.setHorizontalAlignment(SwingConstants.CENTER);
        textField_11.setEditable(false);
        textField_11.setColumns(10);
        contentPane.add(textField_11);
        
        textField_13 = new JTextField();
        textField_13.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_13.setHorizontalAlignment(SwingConstants.CENTER);
        textField_13.setEditable(false);
        textField_13.setColumns(10);
        contentPane.add(textField_13);
        
        textField_14 = new JTextField();
        textField_14.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_14.setHorizontalAlignment(SwingConstants.CENTER);
        textField_14.setEditable(false);
        textField_14.setColumns(10);
        contentPane.add(textField_14);
        
        textField_15 = new JTextField();
        textField_15.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_15.setHorizontalAlignment(SwingConstants.CENTER);
        textField_15.setEditable(false);
        textField_15.setColumns(10);
        contentPane.add(textField_15);
        
    	
    }

    private void actualizarInterfaz() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int valor = juego.cuadricula[i][j];
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
    }
}
