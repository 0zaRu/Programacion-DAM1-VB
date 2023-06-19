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
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UsuarioRegistro extends JPanel {
	private static final long serialVersionUID = 1;
	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfEmail;
	private JTextField jtfUsuario;
	private JPasswordField jtfContrasenia;

	private String recogeNombre;
	private String recogeApellido1;
	private String recogeApellido2;
	private String recogeEmail;
	private String recogeUsuario;
	private String recogeContrasenia;
	private char[] recogeCaracteresCon;

	private int mensajeError;
	private int mensajeUsuarioCreado;
	private int mensajeUsuarioNoCreado;

	private Image imagenFondo;

	private Connection con;
	private PreparedStatement pstm, pstm2;
	private ResultSet rs;
	UsuarioRegistro(String rutaImagen) {
		imagenFondo = new ImageIcon(rutaImagen).getImage();
		
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		

		
		
		JLabel registrate = new JLabel("REGÍSTRATE");
        Font fRegistro = new Font(registrate.getFont().getName(), Font.BOLD, 60);
        registrate.setFont(fRegistro);
        
		add(registrate, constraints);
		constraints.gridwidth = 1;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(5, 5, 5, 5);
		
		JLabel nombre = new JLabel("Nombre: ");
		add(nombre, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		jtfNombre = new JTextField(20);
		jtfNombre.setToolTipText("Ingresa tu nombre");
		add(jtfNombre, constraints);
		
		
        constraints.gridx = 0;
        constraints.gridy = 2;
		JLabel apellido1 = new JLabel("Primer apellido: ");
		add(apellido1, constraints);
		
        constraints.gridx = 1;
        constraints.gridy = 2;
		jtfApellido1 = new JTextField(20);
		jtfApellido1.setToolTipText("Ingresa tu primer apellido");
		add(jtfApellido1, constraints);
		
        constraints.gridx = 0;
        constraints.gridy = 3;
		
		
		JLabel apellido2 = new JLabel("Segundo apellido: ");
		add(apellido2, constraints);
		constraints.gridx = 1;
		 constraints.gridy = 3;
		jtfApellido2 = new JTextField(20);
		jtfApellido2.setToolTipText("Ingresa tu segundo apellido");
		add(jtfApellido2, constraints);
		
		
        constraints.gridx = 0;
        constraints.gridy = 4;
		JLabel email = new JLabel("Email: ");
		add(email, constraints);
		
        constraints.gridx = 1;
        constraints.gridy = 4;
		jtfEmail = new JTextField(20);
		jtfEmail.setToolTipText("Ingresa tu email");
		add(jtfEmail, constraints);
		
		
        constraints.gridx = 0;
        constraints.gridy = 5;
		JLabel usuario = new JLabel("Usuario: ");
		add(usuario, constraints);
		
        constraints.gridx = 1;
        constraints.gridy = 5;
		jtfUsuario = new JTextField(20);
		jtfUsuario.setToolTipText("Ingresa tu usuario");
		add(jtfUsuario, constraints);
		
        constraints.gridx = 0;
        constraints.gridy = 6;
		
		JLabel contrasenia = new JLabel("Contraseña: ");
		add(contrasenia, constraints);
		
        constraints.gridx = 1;
        constraints.gridy = 6; 
		jtfContrasenia = new JPasswordField(20);
		jtfContrasenia.setToolTipText("Ingresa tu contraseña");
		add(jtfContrasenia, constraints);
		
		JButton bIniciaSesion = new JButton("INICIAR SESION");
		constraints.gridx = 0;
		constraints.gridy = 7;
		add(bIniciaSesion, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 7;
		JButton bRegistrarse = new JButton("REGISTRARSE");
		add(bRegistrarse, constraints);

		// ToolTipText necesarios para los botones e informar al usuario
		bIniciaSesion.setToolTipText("PULSA AQUÍ EN EL CASO DE QUE YA TENGAS UNA CUENTA EN RECETARIO");
		bRegistrarse.setToolTipText("PULSA AQUÍ PARA CREAR UNA CUENTA EN RECETARIO");
		
		
		bRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				JButton b = (JButton) evt.getSource();
				b.setText("REGISTRANDO");
				// recoger datos y lanzar el registro
				recogeNombre = jtfNombre.getText();
				recogeApellido1 = jtfApellido1.getText();
				recogeApellido2 = jtfApellido2.getText();
				recogeEmail = jtfEmail.getText();
				recogeUsuario = jtfUsuario.getText();
				recogeCaracteresCon = jtfContrasenia.getPassword();
				recogeContrasenia = new String(recogeCaracteresCon);

				// Comprueba si algún campo está vacío
				if (recogeNombre.isEmpty() || recogeApellido1.isEmpty() || recogeApellido2.isEmpty() || recogeEmail.isEmpty() || recogeUsuario.isEmpty() || recogeContrasenia.isEmpty()) {
					mensajeError = JOptionPane.showOptionDialog(null, "Algún campo está vacío, por favor revise el formulario", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] { "Continuar" }, "Continuar");
					System.out.println(mensajeError);
				} else {
					// Si el metodo devuelve un 1, si devuelve 1 significa que no existe y se procede a registrar al usuario
					if (comprobarUsuario(recogeUsuario) == 1) {
						registrarUsuario(recogeNombre, recogeApellido1, recogeApellido2, recogeEmail, recogeUsuario,recogeContrasenia);mensajeUsuarioCreado = JOptionPane.showOptionDialog(null, "Usuario creado correctamente","Información", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,new String[] { "Continuar" }, "Continuar");
						System.out.println(mensajeUsuarioCreado);
						Recetario.setPCentralUsuarioLogin();
					} else {
						// Salta el error de que ya existe ese usuario
						mensajeUsuarioNoCreado = JOptionPane.showOptionDialog(null,
								"Error al crear el usuario, este usuario ya existe", "Error",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
								new String[] { "Continuar" }, "Continuar");
						System.out.println(mensajeUsuarioNoCreado);
					}
				}
			}
		});
		bIniciaSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				JButton b = (JButton) evt.getSource();
				b.setText("ABRIENDO LOGIN");
				Recetario.setPCentralUsuarioLogin();
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
	}

	/**
 		* Metodo que crea a un usuario en RECETARIO
 		*
 		* @param nombre      el nombre del usuario
 		* @param apellido1   el primer apellido del usuario
 		* @param apellido2   el segundo apellido del usuario
 		* @param email       el email del usuario
 		* @param usuario     usuario nombre
 		* @param contrasenia contraseña
 		* @return the ID of the newly registered user
 	*/
	private int registrarUsuario(String nombre, String apellido1, String apellido2, String email, String usuario,
			String contrasenia) {
		int resultado = 0;
		try {
			// Establecemos la sentencia sql
			con = UConnection.getConnection();
			String sqlRegistrarUsuario = "INSERT INTO Usuario (Nombre, Apellido1, Apellido2, Email, Usuario, psw) ";
			sqlRegistrarUsuario += "VALUES (?, ?, ? ,?, ?, ?)";
			pstm2 = con.prepareStatement(sqlRegistrarUsuario);
			pstm2.setString(1, nombre);
			pstm2.setString(2, apellido1);
			pstm2.setString(3, apellido2);
			pstm2.setString(4, email);
			pstm2.setString(5, usuario);
			pstm2.setString(6, contrasenia);
			resultado = pstm2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Devuelve un 1 si se ha ejecutado la sentencia
		return resultado;
	}

	/**
	 * Metodo que comprueba si un usuario que queremos registrar ya existe o no
	 * 
	 * @param usuario se pasa el nombre del usuario para ver si ya existe uno
	 * @return devuelve un 1 si no existe o un 0 si existe el usuario antes de crearlo
	 */

	public int comprobarUsuario(String usuario) {
		int resultado = 1;
		con = UConnection.getConnection();
		try {
			// Establecemos la sentencia sql
			String sql = "SELECT usuario, psw FROM Usuario";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				if (usuario.equalsIgnoreCase(rs.getString("usuario"))) {
					// retorna 0 si existe
					resultado = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		// Devuelve un 1 si no existe o un 0 si existe el usuario antes de crearlo
		return resultado;
	}
}