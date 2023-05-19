package ejemplosTemario;

import javax.swing.*;

public class MiBoxLayout extends JFrame {
	
	static final long serialVersionUID = 1;
	
	MiBoxLayout() {
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	setLocation(800, 500);
	setSize(500, 500);
	
	}
	
	public static void main(String[] args) {
		MiBoxLayout mBL = new MiBoxLayout();
		mBL.setVisible(true);
	}
}