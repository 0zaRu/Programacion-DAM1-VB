package clases_base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

/**
 * JFrame unico y principal de la aplicacion que contendrá todos los posible JPanels
 */
public class PrincipalJFrame extends JFrame {
    
    static final long serialVersionUID = 1;
	/**
	 * Constructor del JFrame
	 */
    public PrincipalJFrame(){
        //establecemos el lookandfeel por defecto del sistema
		try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
		//Cerramos la ejecución cuando se cierre la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //A partir de aquí el constructor real para la ventana
        setJMenuBar(instanciaMenuBar());
        
        this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().setBackground(new Color(255, 228, 204));
        //PANTALLA COMPLETA
		setExtendedState(JFrame.MAXIMIZED_BOTH);

        setTitle("Recetario");
        setSize(500, 600);
        setLocation(500, 800);
    }

	/**
	 * 
	 * @return MenuBar por defecto de la aplicación
	 * MenuBar de la aplicación que permite salir de esta con cntr+q
	 */
    private JMenuBar instanciaMenuBar() {
		
    	JMenuBar barra = new JMenuBar();
    	JMenu archivo = new JMenu("Archivo");
    	JMenuItem salir = new JMenuItem("Salir");
    	
		archivo.setMnemonic('A');
		archivo.addSeparator();
		archivo.add(salir);

		salir.setAccelerator(KeyStroke.getKeyStroke('Q', ActionEvent.CTRL_MASK));
		salir.setMnemonic('Q');

		barra.add(archivo);

		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(JOptionPane.showConfirmDialog(getContentPane(), "¿Desea salir del programa?",
				"Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE))
				{
					case JOptionPane.YES_OPTION:
						System.exit(0);
					break;

					case JOptionPane.NO_OPTION:
					case JOptionPane.CANCEL_OPTION:
					default:
					break;
				}
			}
		});
    	return barra;
    }
}