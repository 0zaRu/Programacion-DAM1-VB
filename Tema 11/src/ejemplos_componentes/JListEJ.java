package ejemplos_componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListEJ extends JFrame implements ListSelectionListener{
	static final long serialVersionUID = 1;
	JList<String> paises = new JList<String>(new String[]{"España", "Francia", "Italia", "Alemania", "Países bajos"});
	JScrollPane despl = new JScrollPane(paises);
	JLabel selecciones = new JLabel("No se ha seleccionado nada");
	
	JListEJ(){
		
		paises.setVisibleRowCount(3);
		paises.addListSelectionListener(this);
		
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		setLayout(new FlowLayout());
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());

		panel1.add(despl);
		panel2.add(selecciones);
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.SOUTH);
		
		setSize(200, 300);
		setLocation((1920/2)-200, (1080/2)-300);
		setTitle("Prueba Listas Desplegables");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		String texto = "Seleccionado: ";
		
		for(int i=0; i < paises.getSelectedValuesList().size(); i++) {
			texto += paises.getSelectedValuesList().get(i) + " ";
		}
		
		selecciones.setText(texto);
	}
	
	
	public static void main(String[] args) {
		JListEJ jl = new JListEJ();
		jl.setVisible(true);
	}
}
