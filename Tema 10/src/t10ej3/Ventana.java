package t10ej3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Ventana extends JFrame{
    static final long serialVersionUID = 1;
    String[] semana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    int contador = 0;

    Ventana(){
        JButton boton = new JButton("Siguiente día");
        JTextField dia = new JTextField(10);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dia.setText(semana[contador++%7]);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        add(boton);
        add(dia);

        setTitle("Días de la semana");
        setLayout(new FlowLayout());
        setSize(300, 100);
        setLocation(700, 500);
        getContentPane().setBackground(Color.BLACK);

        dia.setBackground(Color.BLACK);
        dia.setForeground(Color.WHITE);
    }

    public static void main(String[] args){
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}
