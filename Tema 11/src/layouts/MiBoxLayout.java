package layouts;

import javax.swing.*;

public class MiBoxLayout extends JFrame {
	
	static final long serialVersionUID = 1;
	
	MiBoxLayout() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

	Box vertical = Box.createVerticalBox();
	//Me falta como poner separación entre los botones

	vertical.add(new JButton("Botón 1"));
	vertical.add(new JButton("Botón 2"));
	vertical.add(new JButton("Botón 3"));
	vertical.add(new JButton("Botón 4"));
	vertical.add(new JButton("Botón 5"));
	add(vertical);
	setLocation(800, 500);
	setSize(500, 500);
	
	}
	
	public static void main(String[] args) {
		MiBoxLayout mBL = new MiBoxLayout();
		mBL.setVisible(true);
	}
}