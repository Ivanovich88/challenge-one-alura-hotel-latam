package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Usuarios;
import views.Login;
import views.MenuUsuario;

public class UsuariosControlador implements ActionListener {

	private Login vista;
	
	public UsuariosControlador(Login vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nombre = vista.getNombre();
		String psw  = vista.getPsw();
		
		if(Usuarios.validarUsuario(nombre,psw)) {
			MenuUsuario menu = new MenuUsuario();
			menu.setVisible(true);
			vista.dispose();
		}else {
			JOptionPane.showMessageDialog(vista,"Usuario o password no validos");
		}
		
	}
	
}
