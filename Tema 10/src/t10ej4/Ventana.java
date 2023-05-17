package t10ej4;

import java.util.Random;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class Ventana extends JFrame{
    static final long serialVersionUID = 1;
    static Random rand = new Random();

    Ventana(){
        JLabel texto = new JLabel("Usted desea ...");
        JButton botonLoco = new JButton("Aprobar");
        JButton botonNormal = new JButton("Suspender");
        JLabel texto2 = new JLabel();

        botonLoco.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton b = (JButton)e.getSource();
                b.setLocation(rand.nextInt(getContentPane().getWidth()-b.getWidth()-1)+1,
                rand.nextInt(getContentPane().getHeight()-b.getHeight()-1)+1);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                texto2.setText("Enhorabuena, has sido capaz de aprobar");
            }
        });

        botonNormal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                texto2.setText("Enhorabuena, has suspendido");
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add(texto);
        add(botonLoco);
        add(botonNormal);
        add(texto2);

        setTitle("Botón loco");
        setSize(500, 500);
        setLocation(700, 500);
        setLayout(new FlowLayout());
    }

    public static void main(String[] args){
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}
