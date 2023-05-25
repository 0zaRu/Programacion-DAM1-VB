package ejemplos_componentes;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JOptionPaneEJ extends JFrame implements ActionListener{
	
	static final long serialVersionUID = 1;
	
	JButton message = new JButton("MessageDialog");
	JButton confirm = new JButton("ConfirmDialog");
	JButton input = new JButton("InputDialog");
	JButton interno = new JButton("InternalMesagge");
	
	JOptionPaneEJ() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		message.addActionListener(this);
		confirm.addActionListener(this);
		input.addActionListener(this);
		interno.addActionListener(this);
		
		add(message);
		add(confirm);
		add(input);
		add(interno);
		
		setSize(500, 400);
		setLocation(500, 800);
		setTitle("Tipos de JDialog");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(message)) 
		{
			JOptionPane.showMessageDialog(this.getContentPane(), "Mensaje de Información", "Message", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(this.getContentPane(), "Mensaje de pregunta", "Message", JOptionPane.QUESTION_MESSAGE);
			JOptionPane.showMessageDialog(this.getContentPane(), "Mensaje de alerta", "Message", JOptionPane.WARNING_MESSAGE);
			JOptionPane.showMessageDialog(this.getContentPane(), "Mensaje personalizado", "Message", JOptionPane.PLAIN_MESSAGE, (new ImageIcon("pingo.jpg")));
			JOptionPane.showMessageDialog(this.getContentPane(), "Mensaje de error", "Message", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource().equals(confirm)) 
		{

		}
		else if(e.getSource().equals(input)) 
		{
			
		}
		else if(e.getSource().equals(interno)) 
		{
			
		}
	}
	
	public static void main(String[] args) {
		JOptionPaneEJ jOP = new JOptionPaneEJ();
		jOP.setVisible(true);
	}
}
