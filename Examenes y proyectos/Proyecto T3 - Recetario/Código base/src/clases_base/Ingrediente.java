package clases_base;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ingrediente extends JPanel {

	private static final long serialVersionUID = 1;

	private Image imagenFondo;
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	private JTextField jtfNombre;
	private JTextField jtfPrecio;
	private JTextField jtfOrigen;
	private JTextField jtfEstado;
	
	private JLabel nombre;
	private JLabel nombreBorrar;
	private JTextField jtfNombreBorrar;
	
	private String recogeNombre;
	private String recogePrecio;
	private String recogeOrigen;
	private String recogeEstado;
	
	private int mensajeError;
	private int mensajeIngredineteCreador;
	JPanel panelAbajo;
	

	Ingrediente(String rutaImagen) {
   		imagenFondo = new ImageIcon(rutaImagen).getImage();
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel panelArriba = new JPanel();
        panelAbajo = new JPanel();
        
		// Creamos el botón atras para volver al selector del menú
        JButton atras = new JButton("ATRAS");
		// Añadimos un ToolTipText al boton atras para que el usuario sepa la accion que realiza el botón
        atras.setToolTipText("PULSA PARA REGRESAR AL MENU");
        
        atras.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent evt) {
        		JButton b = (JButton) evt.getSource();
        		b.setText("ATRAS");
        		Recetario.setPCentralMenuEleccion();
        	}
        	@Override
        	public void mouseEntered(MouseEvent evt) {
        		JButton b = (JButton) evt.getSource();
        		b.setText("ATRAS");
        	}
        	@Override
        	public void mouseExited(MouseEvent evt) {
        		JButton b = (JButton) evt.getSource();
        		b.setText("ATRAS");
        	}
        	@Override
        	public void mousePressed(MouseEvent evt) {
        		Recetario.setPCentralMenuEleccion();
        	}
        });
        
        
        
		// Establecemos que el panel de arriba no sea opaco
        panelArriba.setOpaque(false);
        panelArriba.setLayout(new GridBagLayout());
        // Establecemos que el panel de abajo no sea opaco
        panelAbajo.setOpaque(false);
        panelAbajo.setLayout(new FlowLayout());
        
        
        //Creamos los JLabel/JTextField necesarios para que el usuario rellene para crear un ingrediente
        JLabel creaIng = new JLabel("AÑADE UN INGREDIENTE ");
        nombre = new JLabel("Nombre: ");
        jtfNombre = new JTextField(20);
        JLabel precio = new JLabel("Precio: ");
        jtfPrecio = new JTextField(20);
        JLabel origen = new JLabel("Origen: ");
        jtfOrigen = new JTextField(20);
        JLabel estado = new JLabel("Estado: ");
        jtfEstado = new JTextField(20);
        
        JLabel borraIng = new JLabel("BORRA UN INGREDIENTE ");
        nombreBorrar = new JLabel("Nombre: ");
        jtfNombreBorrar = new JTextField(20);
        
        //Creamos el botón que aádirá los ingredientes
        JButton aniadirIngrediente = new JButton("AÑADIR");
        JButton borrarIngrediente = new JButton("BORRAR");
        
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 8;
		// Agregamos el boton atras al JPanel
        panelArriba.add(atras, constraints);
        constraints.gridwidth = 8;
		constraints.gridx = 0;
		constraints.gridy = 1;
        
		panelArriba.add(creaIng, constraints);
		constraints.gridwidth = 1;
		constraints.gridx = 0;
		constraints.gridy = 2;
        
		panelArriba.add(nombre, constraints);
        
		constraints.gridx = 1;
		constraints.gridy = 2;
        
		panelArriba.add(jtfNombre, constraints);
        
		constraints.gridx = 2;
		constraints.gridy = 2;
        
		panelArriba.add(precio, constraints);
        
		constraints.gridx = 3;
		constraints.gridy = 2;
        
		panelArriba.add(jtfPrecio, constraints);
		
		constraints.gridx = 4;
		constraints.gridy = 2;

		panelArriba.add(origen, constraints);
       
		constraints.gridx = 5;
		constraints.gridy = 2;

		panelArriba.add(jtfOrigen, constraints);
		
		constraints.gridx = 6;
		constraints.gridy = 2;

		panelArriba.add(estado, constraints);
		
		constraints.gridx = 7;
		constraints.gridy = 2;
		
		panelArriba.add(jtfEstado, constraints);
		
		
		constraints.gridx = 8;
		constraints.gridy = 2;
		panelArriba.add(aniadirIngrediente, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 8;
		panelArriba.add(borraIng, constraints);
		
		constraints.gridx = 3;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		panelArriba.add(nombreBorrar, constraints);
		
		constraints.gridx = 4;
		constraints.gridy = 4;
		panelArriba.add(jtfNombreBorrar, constraints);
		
		constraints.gridx = 5;
		constraints.gridy = 4;
		panelArriba.add(borrarIngrediente, constraints);
		
        //Asignamos al botón aniadirIngrediente y borrarIngrediente un .setToolTipText(); para que el usuario tenga informacion sobre dicho botón 
        aniadirIngrediente.setToolTipText("PULSA PARA AÑADIR UN INGREDIENTE");
		borrarIngrediente.setToolTipText("PULSA PARA BORRAR UN INGREDIENTE");
		
		//Añadimos una barra de desplazamiento a la tabla
		JScrollPane jsp = new JScrollPane(tabla());
		panelAbajo.add(jsp);

        
		
		//Creamos los Listeners necesarios para el botón aniadirIngrediente
        aniadirIngrediente.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent evt) {
        		JButton b = (JButton) evt.getSource();
        		b.setText("CARGANDO");
        		recogeNombre = jtfNombre.getText();
        		recogePrecio = jtfPrecio.getText();
        		recogeOrigen = jtfOrigen.getText();
        		recogeEstado = jtfEstado.getText();
        		
        		
        		//El estado no es necesario, en el caso de que esté vacio se asignará -SIN ESTADO- 
        		if(recogeEstado.isEmpty()) {
        			recogeEstado = "-SIN ESTADO-";
        		} else {
        			recogeEstado = jtfEstado.getText();
        		}
        		// Comprueba si algun campo que no sea Estado se encuentran vacíos
        		if(recogeNombre.isEmpty() || recogePrecio.isEmpty() || recogeOrigen.isEmpty()) {
					mensajeError = JOptionPane.showOptionDialog(null,
							"Algún campo está vacío, por favor revise el formulario", "Error",
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] { "Continuar" },
							"Continuar");
					System.out.println(mensajeError);
        		} else {
					//El metodo comprobarIngrediente devuelve 1 si no existe el ingrediente y un 0 si existe el ingrediente
        			if (comprobarIngrediente(recogeNombre) == 1) {
        				if(aniadirIngrediente(recogeNombre, recogePrecio, recogeOrigen, recogeEstado) == 1) {
							// Salta un mensaje de informacion, indicando de que se ha creado el ingrediente deseado
    						mensajeIngredineteCreador = JOptionPane.showOptionDialog(null, "Ingrediente " + recogeNombre + " agregado correctamente",
    								"Información", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
    								new String[] { "Continuar" }, "Continuar");
    						System.out.println(mensajeIngredineteCreador);

        				} else {
							// Salta error si no se ha podido agregar el ingrediente
        					mensajeError = JOptionPane.showOptionDialog(null,
        							"No se ha podido agregar el ingrediente " + recogeNombre, "Error",
        							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] { "Continuar" },
        							"Continuar");
        				}
        			} else {
						// Salta error en el caso de que ya exista el ingrediente
    					mensajeError = JOptionPane.showOptionDialog(null,
    							"Este ingrediente ya existe", "Error",
    							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] { "Continuar" },
    							"Continuar");
        			}
        		}
				// Hacemos algo mas parecido a una actualización cada vez que se añade un ingrediente
				jsp.setViewportView(tabla());
				revalidate();
        	}
        	
			@Override
			public void mouseEntered(MouseEvent evt) {
				JButton b = (JButton) evt.getSource();
				b.setText("CLICK PARA AÑADIR");
			}
			
			@Override
			public void mouseExited(MouseEvent evt) {
				JButton b = (JButton) evt.getSource();
				b.setText("AÑADIR");
			}
        });
        
        borrarIngrediente.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent evt) {
        		JButton b = (JButton) evt.getSource();
        		b.setText("CARGANDO");
        		recogeNombre = jtfNombreBorrar.getText();
        		
        		// Comprueba si algun campo que no sea Estado se encuentran vacíos
        		if(recogeNombre.isEmpty()) {
					mensajeError = JOptionPane.showOptionDialog(null,
							"El campo nombre está vacío, por favor revise el formulario", "Error",
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] { "Continuar" },
							"Continuar");
					System.out.println(mensajeError);
        		} else {
					//El metodo comprobarIngrediente devuelve 1 si no existe el ingrediente y un 0 si existe el ingrediente
        			if (comprobarIngrediente(recogeNombre) == 0) {
        				if(borrarIngrediente(recogeNombre) == 1) {
							// Salta un mensaje de informacion, indicando de que se ha creado el ingrediente deseado
    						mensajeIngredineteCreador = JOptionPane.showOptionDialog(null, "Ingrediente " + recogeNombre + " borrado correctamente",
    								"Información", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
    								new String[] { "Continuar" }, "Continuar");
    						System.out.println(mensajeIngredineteCreador);

        				} else {
							// Salta error si no se ha podido borrar el ingrediente
        					mensajeError = JOptionPane.showOptionDialog(null,
        							"No se ha podido borrar el ingrediente " + recogeNombre, "Error",
        							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] { "Continuar" },
        							"Continuar");
        				}
        			} else {
						// Salta error en el caso de que ya exista el ingrediente
    					mensajeError = JOptionPane.showOptionDialog(null,
    							"Este ingrediente no existe", "Error",
    							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] { "Continuar" },
    							"Continuar");
        			}
        		}
				// Hacemos algo mas parecido a una actualización cada vez que se añade un ingrediente
				jsp.setViewportView(tabla());
				revalidate();
        	}
        	
			@Override
			public void mouseEntered(MouseEvent evt) {
				JButton b = (JButton) evt.getSource();
				b.setText("CLICK PARA BORRAR");
			}
			
			@Override
			public void mouseExited(MouseEvent evt) {
				JButton b = (JButton) evt.getSource();
				b.setText("BORRAR");
			}
        });
        
        // Creamos un objeto fuente de la Clase Font pasandole la getFont(); de creaIng
        Font fuente = creaIng.getFont();
        // Agrandamos la fuente
        Font nuevaFuente = fuente.deriveFont(fuente.getSize() * 2f); 
        // Asignamos la fuente
        creaIng.setFont(nuevaFuente);
        borraIng.setFont(nuevaFuente);
        
        //Agregamos al panel de Arriba la informacion necesaria para crear un botón
        
        //para diferenciar el de arriba con el de abajo
        panelAbajo.setBackground(Color.BLUE);
        
        
        
        // Agregamos los paneles al panel principal
        add(panelArriba);
        add(panelAbajo);
	}

	/**
	 * Método que comprueba si el ingrediente que se quiere crear existe o no
	 *
	 * @param nombre del ingrediente que se quiere agregar
	 * @return devuelve un 1 si el ingrediente no existe, 0 en el caso de que sí existe
	 */
	public int comprobarIngrediente(String nombre) {
		int resultado = 1;
		// Pasamos al getConnection(); de la clase UConnection a con
		con = UConnection.getConnection();
		try {
			// Establecemos la sentencia sql
			String sql = "SELECT nombre FROM Ingrediente";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				if (nombre.equalsIgnoreCase(rs.getString("nombre"))) {
					// retorna 0 si existe
					resultado = 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	/**
	 * Método que crea un nuevo ingrediente
	 *
	 * @param nombre del nuevo ingrediente
	 * @param precio del nuevo ingrediente
	 * @param origen del nuevo ingrediente
	 * @param estado del nuevo ingrediente
	 * @return un cierto resultado, 0 en el caso de que no se ha creado el ingrediente, 1 en el caso de que sí se ha creado el ingrediente
	 */
	public int aniadirIngrediente(String nombre, String precio, String origen, String estado) {
		int resultado = 0;
		try {
			// Pasamos al getConnection(); de la clase UConnection a con
			con = UConnection.getConnection();
			// Establecemos la sentencia sql
			String sqlRegistrarUsuario = "INSERT INTO Ingrediente (Nombre, Precio, Origen, Estado_preferente) ";
			sqlRegistrarUsuario += "VALUES (?, ?, ? ,?)";
			pstm = con.prepareStatement(sqlRegistrarUsuario);
			pstm.setString(1, nombre);
			pstm.setString(2, precio);
			pstm.setString(3, origen);
			pstm.setString(4, estado);
			resultado = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	/**
	 * Metodo que borra un ingrediente
	 * 
	 * @param nombre, se le pasa el nombre del ingrediente que se quiere borrar
	 */
	public int borrarIngrediente(String nombre) {
		int resultado = 0;
		Connection con = UConnection.getConnection();
		PreparedStatement pstm = null;
		
		try {
			String sql = "DELETE FROM Ingrediente ";
			sql += "WHERE nombre=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, nombre);
			resultado = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return resultado;
	}
	/**
	 * Creamos el metodo tabla()
	 *
	 * @return devuelve un JTable con la información de nuestros ingredientes
	 */
	private JTable tabla() {
		JTable tabla = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

        try {
			// Pasamos al getConnection(); de la clase UConnection a con
            con = UConnection.getConnection();
			
			// Establecemos la sentencia sql
            String sql = "SELECT nombre, precio, origen, estado_preferente FROM Ingrediente";
            pstm  = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            // Obtener el numero de columnas de la tabla
            int numCols = rs.getMetaData().getColumnCount();

            // Crear el DefaultTableModel con los nombres de las columnas
            DefaultTableModel nombreCols = new DefaultTableModel();
            for (int i = 1; i <= numCols; i++) {
            	nombreCols.addColumn(rs.getMetaData().getColumnName(i));
            }

            // Agregamos los datos a la tabla
            while (rs.next()) {
                Object[] datos = new Object[numCols];
                for (int i = 1; i <= numCols; i++) {
                	datos[i - 1] = rs.getObject(i);
                }
                nombreCols.addRow(datos);
            }
            
            // Creamos el JTable con el DefaultTableModel
            tabla = new JTable(nombreCols);   
        } catch (SQLException e) {
            e.printStackTrace();
        }
		// Devolvemos la tabla con los datos
		return tabla;
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