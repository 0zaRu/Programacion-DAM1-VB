package ejemplos_componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class MiJComboBox extends JFrame implements ItemListener{
	static final long serialVersionUID = 1;
	JComboBox<String> paises = new JComboBox<String>(new String[]{"España", "Francia", "Italia", "Alemania", "Países bajos"});
	JLabel selecciones = new JLabel("No se ha seleccionado nada");
	
	MiJComboBox(){
		
		paises.setMaximumRowCount(3);
		paises.addItemListener(this);
		
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		setLayout(new FlowLayout());
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());

		panel1.add(paises);
		panel2.add(selecciones);
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.SOUTH);
		
		setSize(200, 300);
		setLocation((1920/2)-200, (1080/2)-300);
		setTitle("Prueba Listas Desplegables");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		selecciones.setText("Seleccionado: " + paises.getSelectedItem().toString());
		
	}
	
	public static void main(String[] args) {
		MiJComboBox jcb = new MiJComboBox();
		jcb.setVisible(true);
	}
}
