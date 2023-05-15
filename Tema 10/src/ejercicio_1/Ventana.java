package ejercicio_1;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame{
	
	static final long serialVersionUID = 1;
	
	Ventana(){
		
		//cambia el color de la ventana a negro
		getContentPane().setBackground(Color.BLACK);
		
		//cambia la distribucion de los objetos
		setLayout(new FlowLayout());
		
		//crea una etiqueta a la que se le añade una imagen
		JLabel etiqueta = new JLabel (new ImageIcon("navi.gif"));
		add(etiqueta);

		//crea un boton con un texto y cambia el color de los elementos del frente a rojo
		JButton boton = new JButton("Pulsar");
		boton.setForeground(Color.RED);
		//Añade los eventos de ratón, implementados con Mouse Listener en la clase Escucharaton
		boton.addMouseListener(new EscuchaRaton ());
		
		
		//añade el boton a la ventana
		add(boton);
	}
	
	public static void main (String [] args) {
		Ventana ventana = new Ventana();
		
		ventana.setTitle("Hola");
		ventana.setSize(500, 300);
		ventana.setLocation(100, 100);
		ventana.setVisible(true);
		
		//Añade los eventos de ventana, implementando con Windows Listener a traves de la clase EscuchaVentana
		ventana.addWindowListener(new EscuchaVentana());
	}
}
