package t11ej2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Botonera extends JPanel {

	static final long serialVersionUID = 1;

	Botonera(){
		//Establecemos la botonera a grid para poder añadir centrado todo
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		//Rellenamos el funcionamiento del botón de cargar archivo
		JButton cargar = new JButton("Cargar ...");
		cargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/////////////////////////////////
			}
		});
		cargar.setToolTipText("Cargar un archivo de texto");
		
		//Rellenamos el funcionamiento del botón para guardar el archivo
		JButton guardar = new JButton("Guardar");
		
		//Rellenamos el funcionamiento de guardar como
		JButton guardar_como = new JButton("Guardar como ...");
		
		//Rellenamos el funcionamiento para cerrar el archivo (ventana emergente de comprobación de guardado?)
		JButton cerrar = new JButton("Cerrar");
		
		//Rellenamos el funcionamiento de limpiar
		JButton limpiar = new JButton("Limpiar");
		
		//Debería añadir un windowlistener para el redimensionamiento y tamaño mínimo
		
		//Añadimos todo a su respectivo lugar
		int espaciado = 12;

		add(Box.createHorizontalStrut(espaciado), CENTER_ALIGNMENT);
		
		add(cargar, CENTER_ALIGNMENT);
		add(Box.createHorizontalStrut(espaciado), CENTER_ALIGNMENT);
		
		add(guardar, CENTER_ALIGNMENT);
		add(Box.createHorizontalStrut(espaciado), CENTER_ALIGNMENT);
		
		add(guardar_como, CENTER_ALIGNMENT);
		add(Box.createHorizontalStrut(espaciado), CENTER_ALIGNMENT);
		
		add(cerrar, CENTER_ALIGNMENT);
		add(Box.createHorizontalStrut(espaciado), CENTER_ALIGNMENT);
		
		add(limpiar, CENTER_ALIGNMENT);
		add(Box.createHorizontalStrut(espaciado), CENTER_ALIGNMENT);

	}
	
	
	//private String[] leerarchivo() {
		
	//}
}
