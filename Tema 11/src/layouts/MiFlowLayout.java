package layouts;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MiFlowLayout extends JFrame{
	
	static final long serialVersionUID = 1;
	
	MiFlowLayout() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setLayout(new FlowLayout());
		
		add(new JButton("Boton 1"));
		add(new JButton("Boton 2"));
		add(new JButton("Boton 3"));
		add(new JButton("Boton 4"));
		add(new JButton("Boton 5"));
		add(new JButton("Boton 6"));
		add(new JButton("Boton 7"));
		add(new JButton("Boton 8"));
		
		setSize(500, 500);
		setLocation(800, 500);
	}
	
	public static void main(String[] args) {
		MiFlowLayout mFL = new MiFlowLayout();
		mFL.setVisible(true);
	}
}
