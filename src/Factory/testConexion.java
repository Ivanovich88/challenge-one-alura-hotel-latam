package Factory;

import java.sql.Connection;
import java.sql.SQLException;

public class testConexion {

	public static void main(String[] args) throws SQLException{
		ConexionBase con = new ConexionBase();
		Connection cone = con.conectarBase();
		
		System.out.println("Buena conexion");
		
		cone.close();
		
		System.out.println("Cerro la conexion");
		
	}
	
}
