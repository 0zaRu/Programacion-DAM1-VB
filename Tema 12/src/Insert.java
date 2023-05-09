import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
	public static void main(String[] args) {
	
		//Creamos los objetos con los que vamos a trabajar
		Connection con = null;			//Con se encarga de hacer las conexiones a la bd con el driver
		PreparedStatement pstm = null;	//PreparedStatement es una sentencia preparada que se enviará a la bd

		//Todos estos String se encargan de almacenar la información necesaria para hacer la conexión a modo de plantilla
		String driver = "com.mysql.cj.jdbc.Driver";
		String database = "instituto";
		String hostname = "localhost";
		String port = "3306";
		String url = "jdbc:mysql://"+ hostname + ":" + port + "/"+ database + "?userSSL=false&serverTimezone=UTC";
		String usr = "root";
		String pwd = "123456";
		
		//Este bloque se encarga de "encender" el driver, aunque me he dado cuenta de que no hace mucha falta
		try {
			//Se levanta el driver
			Class.forName(driver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			//Se establece la conexion a la bd con usuario y contraseña con Connection
			con = DriverManager.getConnection(url, usr, pwd);
			
			//Creamos la sentencia y la metemos en la PreparedStatement pstm, parametrizada
			String sql = "INSERT INTO Asignaturas (Nombre, Horas)";
			sql += "values(?, ?)";
			pstm = con.prepareStatement(sql);
			
			//Añadimos a la sentencia los valores (desparametrización)
			pstm.setString(1, "Bases de Datos");
			pstm.setInt(2, 6);
			
			//almacenamos elr esultado
			int resultado = pstm.executeUpdate();
			
			//Hacemos las salidas pertinentes
			if(resultado == 1)
				System.out.println("1 fila insertada con éxito");
			else
				throw new RuntimeException("Error durante la insercción");
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		
		}finally {
			//Cerramos los objetos una vez se ha finalizado
			try {
				if(pstm != null) 	pstm.close();
				if(con != null)		con.close();
			
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}