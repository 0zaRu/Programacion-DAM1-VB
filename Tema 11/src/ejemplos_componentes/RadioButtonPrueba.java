package ejemplos_componentes;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class RadioButtonPrueba extends JFrame{
    static final long serialVersionUID = 1;
    char[] psw1;

    RadioButtonPrueba(){

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        ButtonGroup grupo = new ButtonGroup();
        
        JRadioButton carne = new JRadioButton("Carne");
        JRadioButton pescado = new JRadioButton("Carne");
        JLabel select = new JLabel("Usted prefiere: Nada");

        ItemListener escuchacheck = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(carne.isSelected())
                    select.setText("Usted prefiere: Carne");

                else
                    select.setText("Usted prefiere: Pescado");

            }
        };
        carne.addItemListener(escuchacheck);
        pescado.addItemListener(escuchacheck);

        grupo.add(carne);
        grupo.add(pescado);
        add(carne);
        add(pescado);
        add(select);

        setSize(400, 200);
        setLocation(300, 500);
        setTitle("Validar contraseña");
    }

    public static void main(String[] args){
        RadioButtonPrueba rb = new RadioButtonPrueba();
        rb.setVisible(true);
    }
}