package clases_base;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.util.ResourceBundle;

public class UConnection {
	
	private static Connection con = null;
	
	public static Connection getConnection() {
		try {
			if(con == null) {
				Runtime.getRuntime().addShutdownHook(new MiShutdownHook());
;
				//ResourceBundle rb = ResourceBundle.getBundle("jdbc");
				String driver = "com.mysql.cj.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/recetario?useSSL=false&serverTimezone=UTC";
                String usr = "root";
                String pwd = "123456";
				
				Class.forName(driver);
				con = DriverManager.getConnection(url, usr, pwd);
			}
			return con;
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error al crear la conexión", e);
		}
	}

	static class MiShutdownHook extends Thread{
		public void run() {
			try {
				con = UConnection.getConnection();
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
