package ejemplos_componentes;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		setSize(500, 400);
		setLocation(500, 800);
		setTitle("Tipos de JDialog");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(message)) 
		{
			//JOptionPane.showMessageDialog
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
}
