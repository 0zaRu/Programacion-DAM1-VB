package clases_base;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class MenuEleccion extends JPanel {

	private static final long serialVersionUID = 1;

	/**
	 * @param TAMANIO_FUENTE para establecer el tamaño que tendrán los JLabels (MOSTRAR, CREAR, INGREDIENTES)
	 */
	private static final int TAMANIO_FUENTE = 50;

	private Image imagenFondo;

	MenuEleccion(String rutaImagen) {
		imagenFondo = new ImageIcon(rutaImagen).getImage();
		

		//Creamos el ImagenIcon al que le pasamos las imagenes correspondientes
		ImageIcon fondoBoton1 = new ImageIcon("Imagenes/LIBRORECE.jpg");
		ImageIcon fondoBoton2 = new ImageIcon("Imagenes/CREARRECETA.png");
		ImageIcon fondoBoton3 = new ImageIcon("Imagenes/Ingredientes.jpg");
		
		// Creamos los botones que se van a mostrar en este JPanel
		JButton bMostrarRecetas = new JButton("MOSTRAR RECETAS");
		JButton bCrearmeRecetas = new JButton("CREAR RECETAS");
		JButton bMostrarIngredientes = new JButton("MOSTRAR INGREDIENTES");
		
		// A cada uno de los tres botones le hemos establecido su imagen pasandole su ImagenIcon correspondiente con .setIcon
		bMostrarRecetas.setIcon(fondoBoton1);
		bCrearmeRecetas.setIcon(fondoBoton2);
		bMostrarIngredientes.setIcon(fondoBoton3);
		
		// Quitamos el contenido (fondo) de cada botón usando .setContentAreaFilled(false);
		bMostrarRecetas.setContentAreaFilled(false);
		bCrearmeRecetas.setContentAreaFilled(false);
		bMostrarIngredientes.setContentAreaFilled(false);
		
		// Quitamos el borde de cada botón usando .setBorderPainted(false);
		bMostrarRecetas.setBorderPainted(false);
		bCrearmeRecetas.setBorderPainted(false);
		bMostrarIngredientes.setBorderPainted(false);
		
		// Establecemos la dimension que va a tener cada boton 
		Dimension bTamanio = new Dimension(300, 350);
		
		// Asignamos la dimension que queremos a cada botón usando .setPreferredSize(bTamanio); le pasamos la dimension creada antes
		bMostrarRecetas.setPreferredSize(bTamanio);
		bCrearmeRecetas.setPreferredSize(bTamanio);
		bMostrarIngredientes.setPreferredSize(bTamanio);
		
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(20, 80, 20 , 80);

		

		// Establecemos la posicion de cada JLabel/Boton y añadimoos para que se muestre en nuestro JPanel la posicion la establecemos por medio de GridBagConstraints

		constraints.gridx = 0;
		constraints.gridy = 0;

		// Lo agregamos al JPanel con su constraints
		JLabel mostrar = new JLabel("MOSTRAR");
		add(mostrar, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;

		// Lo agregamos al JPanel con su constraints
		add(bMostrarRecetas, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		JLabel crear = new JLabel("CREAR");

		// Lo agregamos al JPanel con su constraints
		add(crear, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;

		// Lo agregamos al JPanel con su constraints
		add(bCrearmeRecetas, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 0;
		JLabel ingredientes = new JLabel("INGREDIENTES");

		// Lo agregamos al JPanel con su constraints
		add(ingredientes, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 1;
		
		// Lo agregamos al JPanel con su constraints
		add(bMostrarIngredientes, constraints);
		
		
		//Creamos una fuente específica para cada JLabel (mostrar, crear, ingredientes)
		Font fCrear= new Font(mostrar.getFont().getName(), Font.BOLD, TAMANIO_FUENTE);
		Font fMostrar = new Font(crear.getFont().getName(), Font.BOLD, TAMANIO_FUENTE);
		Font fIngrediente = new Font(ingredientes.getFont().getName(), Font.BOLD, TAMANIO_FUENTE);
		
		
		//Asignamos la fuente correspondiente a cada JLabel (mostrar, crear, ingredientes) 
		mostrar.setFont(fCrear);
		crear.setFont(fMostrar);
		ingredientes.setFont(fIngrediente);
		
		//Establecemos el color de fondo de cada JLabe
		mostrar.setForeground(Color.WHITE);
		crear.setForeground(Color.WHITE);
		ingredientes.setForeground(Color.WHITE);
		
		
		
		//Establecemos los ..setToolTipText(); correspondientes para cada JButton

		bMostrarRecetas.setToolTipText("PULSA PARA VER RECETAS");
		bCrearmeRecetas.setToolTipText("PULSA PARA CREAR RECETAS");
		bMostrarIngredientes.setToolTipText("PULSA PARA MOSTRAR INGREDIENTES");
		
		
		//Creamos los listeners correspondientes para el botón bMostrarRecetas
		bMostrarRecetas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				// En el momento que se clickee el boton bMostrarRecetas se cambia de JPanel
				Recetario.setPCentralSeleccionaReceta();
			}
			@Override
			public void mousePressed(MouseEvent evt) {
				// En el momento que se mantenga pulsado el boton bMostrarRecetas se cambia de JPanel
				// Se controla este MouseEvent
				Recetario.setPCentralSeleccionaReceta();
			}
		});
		
		
		//Creamos los listeners correspondientes para el botón bCrearmeRecetas
		bCrearmeRecetas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				/// En el momento que se clickee el boton bCrearmeRecetas se cambia de JPanel
				Recetario.setPCentralNuevaReceta();
			}
			@Override
			public void mousePressed(MouseEvent evt) {
				// En el momento que se mantenga pulsado el boton bCrearmeRecetas se cambia de JPanel
				// Se controla este MouseEvent
				Recetario.setPCentralNuevaReceta();
			}
		});
		
		//Creamos los listeners correspondientes para el botón bMostrarIngredientes
		bMostrarIngredientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				// En el momento que se clickee el boton bCrearmeRecetas se cambia de JPanel
				Recetario.setPCentralIngrediente();
			}
			@Override
			public void mousePressed(MouseEvent evt) {
				// En el momento que se mantenga pulsado el boton bMostrarIngredientes se cambia de JPanel
				// Se controla este MouseEvent
				Recetario.setPCentralIngrediente();
			}
		});
	}
	
	/**
	 * @param g Se le pasa un objeto de la clase Graphics, con éste método se establece el "fondo del programa"
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
	}
}
