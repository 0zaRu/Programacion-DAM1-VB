package ejemplosTemario;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class MiJLabel extends JFrame {
	
	static final long serialVersionUID=1;
	
	MiJLabel() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 2));
		
		JLabel e1 = new JLabel("Etiqueta 1");
		JLabel e2 = new JLabel("Etiqueta 2");
		//e2.setFont
		JLabel e3 = new JLabel("Etiqueta 3", new ImageIcon("OIP.jpg"), SwingConstants.NORTH_EAST);
		JLabel e4 = new JLabel("Etiqueta 4", SwingConstants.RIGHT);
		JLabel e5 = new JLabel("<html><b>Negrita</b> y <i>cursiva</i> y <FONT COLOR=red> rojo");
		
		add(e1);
		add(e2);
		add(e3);
		add(e4);
		add(e5);

		setSize(500, 500);
		setLocation(800, 500);
		setTitle("MisJLabels");
	}
	
	public static void main(String[] args) {
		MiJLabel mJL = new MiJLabel();
		mJL.setVisible(true);
	}
}
