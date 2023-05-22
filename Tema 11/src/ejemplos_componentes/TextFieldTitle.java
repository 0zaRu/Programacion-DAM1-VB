package ejemplos_componentes;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class TextFieldTitle extends JFrame{
    static final long serialVersionUID = 1;

    TextFieldTitle(){

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel texto = new JLabel("Introduce el título de la ventana: ");
        add(texto);

        JTextField areatxt = new JTextField("Introduce el nombre de la ventana");
        areatxt.setForeground(Color.GRAY);
        areatxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField area = (JTextField) e.getSource();
                setTitle(area.getText());                
            }
        });

        areatxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(areatxt.getForeground() == Color.GRAY){
                    areatxt.setForeground(Color.BLACK);
                    areatxt.setText("");
                }
            }
        });

        add(areatxt);

        setSize(600, 400);
        setLocation(400, 400);
        setTitle("No editado");
    }

    public static void main(String[] args){
        TextFieldTitle TFT = new TextFieldTitle();
        TFT.setVisible(true);
    }
}
