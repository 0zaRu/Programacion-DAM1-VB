package ejemplos_componentes;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class MiJLabel extends JFrame {
	
	static final long serialVersionUID = 1;
	
	MiJLabel() {

		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 2));
		
		JLabel e1 = new JLabel("Etiqueta 1");
		JLabel e2 = new JLabel("Etiqueta 2");
		e2.setFont(new Font("A", Font.BOLD, 16));

		//Me falta saber cómo pongo el texto de etiqueta 3 arriba derecha
		JLabel e3 = new JLabel("Etiqueta 3", new ImageIcon("OIP.jpg"), SwingConstants.CENTER);
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
