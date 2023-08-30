package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import Factory.ConexionBase;

public class Usuarios {

		private String nombre;
		private String psw;
		
		public Usuarios (String nombre,String psw) {
			this.nombre = nombre;
			this.psw = psw;
		}	
			
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getPsw() {
			return psw;
		}

		public void setPsw(String psw) {
			this.psw = psw;
		}
		
		public static boolean validarUsuario(String nombre,String psw) {
		ConexionBase con = new ConexionBase();
		Connection connec = null;
		PreparedStatement state = null;
		ResultSet result = null;
		try {
		
		connec = con.conectarBase();
		state = connec.prepareStatement(" SELECT * FROM usuarios WHERE nombre=? AND psw=?");
		state.setString(1, nombre);
		state.setString(2, psw);
		result = state.executeQuery();
		return result.next();
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(result !=null)
					result.close();
				if(state !=null)
					state.close();
				if(connec !=null)
					connec.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		}
}
