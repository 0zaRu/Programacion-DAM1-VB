package ejemplos_componentes;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class JSliderEJ extends JFrame implements ChangeListener{
    static final long serialVersionUID = 1;

    JSlider desplaza = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
	JLabel valor = new JLabel("Valor: "+ desplaza.getValue());

    JSliderEJ(){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        desplaza.putClientProperty("JSlider.isFilled", Boolean.FALSE);
        desplaza.setPaintLabels(true);
        desplaza.setPaintTicks(true);
        desplaza.setMajorTickSpacing(25);
        desplaza.setMinorTickSpacing(5);
        desplaza.addChangeListener(this);
        
        add(desplaza, BorderLayout.NORTH);

        JPanel content = new JPanel(new FlowLayout());
        content.add(valor);
        add(content, BorderLayout.CENTER);

        setSize(550, 200);
        setLocation(400, 600);
        setTitle("Ejemplo de JSlider");
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        valor.setText("Valor: "+ desplaza.getValue());
    }

    public static void main(String[] args) {
        JSliderEJ miJS = new JSliderEJ();
        miJS.setVisible(true);
    }
}
