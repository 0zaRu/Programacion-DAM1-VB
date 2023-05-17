package ejemplosTemario;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MiGridLayout extends JFrame {
	
	static final long serialVersionUID = 1;
	
	MiGridLayout() {
	addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	});
	
	setLayout(new GridLayout(3, 3));
	
	add(new JButton("Boton 1"));
	add(new JButton("Boton 2"));
	add(new JButton("Boton 3"));
	add(new JButton("Boton 4"));
	add(new JButton("Boton 5"));
	add(new JButton("Boton 6"));
	add(new JButton("Boton 7"));
	add(new JButton("Boton 8"));
	
	setLocation(800, 500);
	setSize(500, 500);
	
	}
	
	public static void main(String[] args) {
		MiGridLayout mGL = new MiGridLayout();
		mGL.setVisible(true);
	}
}
