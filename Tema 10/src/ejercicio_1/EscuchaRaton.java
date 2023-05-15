package ejercicio_1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class EscuchaRaton implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton b = (JButton)e.getSource();
		b.setText("Lo pulsaste");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		JButton b = (JButton)e.getSource();
		b.setText("Lo estas presionando");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JButton b = (JButton)e.getSource();
		b.setText("Lo soltaste");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JButton b = (JButton)e.getSource();
		b.setText("Has entrado");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JButton b = (JButton)e.getSource();
		b.setText("Has salido");
	}
	
	

}
