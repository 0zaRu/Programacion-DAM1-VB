package ejemplosTemario;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MiBorderLayout extends JFrame {
	
	static final long serialVersionUID = 1;
	
	MiBorderLayout() {
	addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	});
	
	setLayout(new BorderLayout());
	
	add(new JButton("Boton 1"), BorderLayout.NORTH);
	add(new JButton("Boton 2"), BorderLayout.SOUTH);
	add(new JButton("Boton 3"), BorderLayout.EAST);
	add(new JButton("Boton 4"), BorderLayout.WEST);
	add(new JButton("Boton 5"), BorderLayout.CENTER);
	
	setLocation(800, 500);
	setSize(500, 500);
	
	}
	
	public static void main(String[] args) {
		MiBorderLayout mGL = new MiBorderLayout();
		mGL.setVisible(true);
	}
}