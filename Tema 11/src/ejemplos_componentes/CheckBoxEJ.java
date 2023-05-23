package ejemplos_componentes;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class CheckBoxEJ extends JFrame{
    static final long serialVersionUID = 1;
    char[] psw1;

    CheckBoxEJ(){

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        //para qué era el container necesario?
        JCheckBox carne = new JCheckBox("Carne");
        JCheckBox pescado = new JCheckBox("Carne");
        JLabel select = new JLabel("Usted prefiere: Nada");

        ItemListener escuchacheck = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(carne.isSelected() && pescado.isSelected())
                    select.setText("Usted prefiere: Carne y pescado");
                
                else if(carne.isSelected() && !pescado.isSelected())
                    select.setText("Usted prefiere: Carne");

                else if(!carne.isSelected() && pescado.isSelected())
                    select.setText("Usted prefiere: Pescado");

                else
                    select.setText("Usted prefiere: Nada");
            }
        };
        carne.addItemListener(escuchacheck);
        pescado.addItemListener(escuchacheck);

        add(carne);
        add(pescado);
        add(select);

        setSize(400, 200);
        setLocation(300, 500);
        setTitle("Validar contraseña");
    }

    public static void main(String[] args){
        CheckBoxEJ cb = new CheckBoxEJ();
        cb.setVisible(true);
    }
}