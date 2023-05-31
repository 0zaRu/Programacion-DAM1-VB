package singleton_pattern;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Asignatura {
	
	static final String TRUEASIG  = "Bases de Datos";
	static final String ERRORASIG = "virus";
	
	public static void main(String[] args) {
		try {
			Connection con = UConnection.getConnection();
			con.setAutoCommit(false);
			
			Insertar15(con, TRUEASIG, 6);
			Select(con);
			System.out.println("=============================================");
			Update(con, 8, "Bases de Datos");
			Select(con);
			System.out.println("=============================================");
			Delete(con, "Bases de Datos");
			Select(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	static void Insertar15(Connection con, String nombre, int horas) throws SQLException {
		
		String sql = "Insert into asignaturas (Nombre, Horas)";
		sql += " values(?, ?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		for(int i=1; i<16; i++) {
			pstm.setString(1, (nombre));
			pstm.setInt(2, horas);
			
			int resultado = pstm.executeUpdate();
			
			//Hacemos las salidas pertinentes
			if(resultado == 0 || nombre == ERRORASIG) {
				con.rollback();
				throw new RuntimeException("Error durante la insercción de un valor");
			}
		}
		con.commit();
		System.out.println("15 valores añadidos con exito");
	}
	
	
	static void Select(Connection con) throws SQLException {
		String sql = "Select Nombre, Horas FROM asignaturas";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next())
			System.out.println("Nombre: " + rs.getString(1)+ ".\t\tHoras: " + rs.getInt("Horas"));
	}
	
	
	static void Update(Connection con, int horas, String nombre) throws SQLException {
		String sql = "UPDATE Asignaturas SET Horas=? ";
		sql += "WHERE nombre=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setInt(1, 8);
		pstm.setString(2, nombre);
		
		int resultado = pstm.executeUpdate();
		
		if(resultado < 1 || horas <= 0)
			throw new RuntimeException("Error durante la actualización");
		
		con.commit();
		System.out.println("Filas actualizadas correctamente");
	}
	
	
	static void Delete(Connection con, String nombre) throws SQLException {
		String sql = "Delete from Asignaturas ";
		sql += "Where Nombre=?";
		
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, nombre);
		
		int resultado = pstm.executeUpdate();
		
		if(resultado <= 0)
			throw new RuntimeException("Error durante la elimimación");
		
		else
			con.commit();
			System.out.println("Filas borradas correctamente");
	}
}






