package layouts;

import javax.swing.*;
import java.awt.*;

public class MiGridBagLayout extends JFrame{
    static final long serialVersionUID = 1;

    MiGridBagLayout(){

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        JButton b1 = new JButton("Botón 1 (1,0)");
        GridBagConstraints cnst = new GridBagConstraints();
        cnst.anchor = GridBagConstraints.CENTER;
        cnst.fill = GridBagConstraints.BOTH;
        cnst.weightx = 1;
        cnst.weighty = 1;

        cnst.gridx = 1;
        cnst.gridy = 0;

        add(b1, cnst);
        
        JButton b2 = new JButton("Botón 2 (2,1)");
        cnst.gridx = 2;
        cnst.gridy = 1;
        add(b2, cnst);
        
        JButton b3 = new JButton("Botón 3 (0,1)");
        cnst.gridx = 0;
        cnst.gridy = 1;
        add(b3, cnst);
        
        JButton b4 = new JButton("Botón 4 (1,1)");
        cnst.gridx = 1;
        cnst.gridy = 1;
        add(b4, cnst);
        
        JButton b5 = new JButton("Botón 5 (1,2)");
        cnst.gridx = 1;
        cnst.gridy = 2;
        add(b5, cnst);

        JButton b6 = new JButton("Botón 6");
        cnst.anchor = GridBagConstraints.SOUTH;
        cnst.gridwidth = 3;
        cnst.gridx = 0;
        cnst.gridy = 3;
        add(b6, cnst);

        setSize(300, 300);
        setLocation(500, 500);
        setTitle("GridBagLayout");
    }

    public static void main(String[] args){
        MiGridBagLayout MGbL = new MiGridBagLayout();
        MGbL.setVisible(true);
    }
}
