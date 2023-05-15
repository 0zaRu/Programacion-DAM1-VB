package t10ej2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Ventana extends JFrame{

    static final long serialVersionUID = 1;
    int contador = 0;

    Ventana(){
        //Creamos los objetos de la ventana, botón y campo de texto
        JButton boton = new JButton("Botón Contador");
        JTextField respuesta = new JTextField("El botón contador no se ha pulsado");

        //Añadimos el listener del botón, que cuando se toca devuelve 
        //una cadena de texto que modificaq el campo de texto
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                respuesta.setText(cambiaTexto(contador++));
            }
        });

        //añadimos los objetos a la ventana
        add(boton);
        add(respuesta);

        //Creamos el escuchador de ventana para que se cierra cuando la cerramos
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        //Establecemos los parámetros de la ventana
        setTitle("Prueba de eventos en Java");
        setSize(300, 100);
        setLocation(900, 500);
        getContentPane().setBackground(Color.black);
        setLayout(new FlowLayout());
    }

    /** Método para devolver el texto para TextField */
    public String cambiaTexto(int i) {
        return "El botón ha sido pulsado "+i+" veces";
    }

    public static void main(String[] args){
        Ventana ventana = new Ventana();

        //Esto lo pongo aquí en vez de en el constructor para que no detecte el objeto "ventana" sin uso.
        ventana.setVisible(true);
    }
}