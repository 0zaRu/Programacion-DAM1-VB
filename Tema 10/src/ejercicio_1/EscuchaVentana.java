package ejercicio_1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EscuchaVentana extends WindowAdapter { //esto es una clase adaptada, la cual nos permite SOLO acceder al metodo que nos interesa sin implementar todos

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		
	}

}
