package clases_base;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UsuarioLogin extends JPanel {
    
	private static final long serialVersionUID = 1;

	private JButton bLogin;
	private JButton bRegistrar;

	private JTextField jtfUsuario;
	private JPasswordField jtfContrasenia;

	private Image imagenFondo;

	private String recogeUsuario;
	private String recogeContrasenia;
	private char[] recogeCaracteresCon;

	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	// Establecemos los mensajes que se mostrarán para diferentes casos
	private int mensajeErrorCuadrosVacios;
	private int mensajeErrorLogin;


	UsuarioLogin(String rutaImagen) {
		imagenFondo = new ImageIcon(rutaImagen).getImage();
		
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		// Creamos el objeto constraints de la clase GridBagConstraints para distribuir nuestros JLabels/JTextFields
		GridBagConstraints constraints = new GridBagConstraints();
		
		//JLabel indicando el texto para iniciar sesion
		JLabel login = new JLabel("INICIAR SESIÓN");

		// Creamos una fuente para el JLabel anterior
		Font fLogin = new Font(login.getFont().getName(), Font.BOLD, 60);

		// Asignamos la fuente al JLabel con .setFont();
		login.setFont(fLogin);
		
		// Añadimos y establecemos las pisiciones de cada Jlabel al lado de su correspondiente JTextField
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    constraints.gridwidth = 2;
	    add(login, constraints);
	    
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridwidth = 1;
		constraints.gridx = 0;
		constraints.gridy = 1;
	    
		JLabel usus = new JLabel("Usuario: ");
		add(usus, constraints);
		
	    constraints.gridx = 1;
	    constraints.gridy = 1;
		jtfUsuario = new JTextField(20);
		jtfUsuario.setToolTipText("Ingresa tu usuario");
		add(jtfUsuario, constraints);
		
        constraints.gridx = 0;
        constraints.gridy = 2;
		
        JLabel pas = new JLabel("Contraseña: ");
        add(pas, constraints);
		
        constraints.gridx = 1;
        constraints.gridy = 2;
        jtfContrasenia = new JPasswordField(20);
        jtfContrasenia.setToolTipText("Ingresa tu contraseña");
        add(jtfContrasenia, constraints);
		
        constraints.gridx = 0;
        constraints.gridy = 3;
        
        constraints.gridwidth = 2;
		
        bLogin = new JButton("INICIAR SESIÓN");
        add(bLogin, constraints);
		JLabel opcionRegistro = new JLabel("En el caso de que no tenga cuenta, pulse el siguiente en el botón ");
		constraints.gridy = 3;
		add(opcionRegistro, constraints);
		
        constraints.gridy = 4;

		bRegistrar = new JButton("REGISTRARSE");
        add(bRegistrar, constraints);
        
        // Asignamos los ToolTipText para cada boton 
        bLogin.setToolTipText("PULSA AQUÍ PARA ENTRAR EN RECETARIO");
		bRegistrar.setToolTipText("PULSA AQUÍ PARA CREAR UNA CUENTA EN RECETARIO");
        
		//Creamos los listeners correspondientes para el botón bLogin
		bLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				JButton b = (JButton) evt.getSource();
				b.setText("CARGANDO USUARIO");
				recogeUsuario = jtfUsuario.getText();
				recogeCaracteresCon = jtfContrasenia.getPassword();
				recogeContrasenia = new String(recogeCaracteresCon);
				Arrays.fill(recogeCaracteresCon, ' ');
				//Comprueba si el recogeUsuario y recogeContrasenia están vacíos
				if (recogeUsuario.isEmpty() && recogeContrasenia.isEmpty()) {
					mensajeErrorCuadrosVacios = JOptionPane.showOptionDialog(null,
							"No se han introducido ni usuario ni contraseña", "Error", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, new String[] { "Continuar" }, "Continuar");
					System.out.println(mensajeErrorCuadrosVacios);
					//Si solo recogeUsuario está vacio
				} else if (recogeUsuario.isEmpty()) {
					mensajeErrorCuadrosVacios = JOptionPane.showOptionDialog(null, "No se ha introducido el usuario",
							"Error", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
							new String[] { "Continuar" }, "Continuar");
					System.out.println(mensajeErrorCuadrosVacios);
					//Si solo recogeContrasenia está vacio
				} else if (recogeContrasenia.isEmpty()) {
					mensajeErrorCuadrosVacios = JOptionPane.showOptionDialog(null, "No se ha introducido la contraseña",
							"Error", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
							new String[] { "Continuar" }, "Continuar");
					System.out.println(mensajeErrorCuadrosVacios);
				} else {
					//Si el método devuelve 1, significa que el usuario y contraseña son correctos
					if (comprobarUsuarioContrasenia(recogeUsuario, recogeContrasenia) == 1) {
						// SE INICIA LA VENTANA DE MENU
						Recetario.setPCentralMenuEleccion();
						//Si no devuelve 1, salta el siguiente error
					} else {
						mensajeErrorLogin = JOptionPane.showOptionDialog(null,
								"Usuario no encontrado, o contraseña incorrecta, en el caso de que no tenga una cuenta en RECETARIO, pulse el boton REGISTRARSE",
								"Error", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
								new String[] { "Continuar" }, "Continuar");
						System.out.println(mensajeErrorLogin);
					}
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent evt) {
				JButton b = (JButton) evt.getSource();
				b.setText("PULSA PARA INICIAR SESIÓN");
			}

			@Override
			public void mouseExited(MouseEvent evt) {
				JButton b = (JButton) evt.getSource();
				b.setText("INICIAR SESIÓN");
			}


		});
		
		// Creamos los listeners correspondientes para el botón bRegistrar
		bRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				JButton b = (JButton) evt.getSource();
				b.setText("ABRIENDO REGISTRO");
				Recetario.setPCentralUsuarioRegistro();
				
			}

			@Override
			public void mouseEntered(MouseEvent evt) {
				JButton b = (JButton) evt.getSource();
				b.setText("PULSA PARA REGISTRARTE");
			}

			@Override
			public void mouseExited(MouseEvent evt) {
				JButton b = (JButton) evt.getSource();
				b.setText("REGISTRARSE");
			}
			
			@Override
			public void mousePressed(MouseEvent evt) {
				JButton b = (JButton) evt.getSource();
				b.setText("DEJA DE PRESIONAR PARA REGISTRARTE");
				Recetario.setPCentralUsuarioRegistro();
			}

		});
	}
	

	/**
	 * Método que comprueba si el usuario existe o no
	 * 
	 * @param usuario
	 * @param contrasenia
	 * 
	 * @return devuelve un 1 en el caso de que el usuario no existe, 0 si el usuario no existe
	 */
	public int comprobarUsuarioContrasenia(String usuario, String contrasenia) {
		int resultado = 0;
		con = UConnection.getConnection();
		try {
			String sql = "SELECT usuario, psw FROM Usuario";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				if (usuario.equalsIgnoreCase(rs.getString("usuario"))
						&& contrasenia.equalsIgnoreCase(rs.getString("psw"))) {
					//cambia a 1 si el usuario y contraseña son correctos
					resultado = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return resultado;
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
