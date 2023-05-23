package ejemplos_componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class JScrollBarEJ extends JFrame{

	static final long serialVersionUID = 1;
	
	int valorIni = 0, maxSize = 300+(300/10), barra = 300/10;
	JScrollBar miScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, valorIni, barra, 0, maxSize);
	
	JLabel valor = new JLabel("Valor: "+ valorIni);
	
	JScrollBarEJ(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		miScrollBar.addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				valor.setText("Valor: "+ miScrollBar.getValue());
			}
		});
		
		add(miScrollBar, BorderLayout.NORTH);
		JPanel centrar = new JPanel(new FlowLayout());
		centrar.add(valor);
		add(centrar, BorderLayout.CENTER);
		
		setLocation(500, 700);
		setSize(300, 200);
		setTitle("Ejemplo ScrollPane");
	}
	

	
	public static void main(String[] args) {
		JScrollBarEJ mSB = new JScrollBarEJ();
		mSB.setVisible(true);
	}
}
