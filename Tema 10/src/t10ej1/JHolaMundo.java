package t10ej1;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JHolaMundo extends WindowAdapter {
    public static void main(String[] args){
        JFrame ventana = new JFrame();
        JLabel hw = new JLabel("Hola Mundo!!");

        ventana.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        ventana.getContentPane().add(hw);
        ventana.setSize(200, 100);
        ventana.setLocation(700, 500);
        ventana.setVisible(true);
    }
}
