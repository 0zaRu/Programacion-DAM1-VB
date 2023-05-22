package ejemplos_componentes;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PswFiledPrueba extends JFrame{
    static final long serialVersionUID = 1;
    char[] psw1;

    PswFiledPrueba(){

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel texto = new JLabel("Introduce tu contraseña: ");
        add(texto);

        JPasswordField psw = new JPasswordField(20);
        JLabel respuesta = new JLabel();

        psw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pswconvert = psw.getPassword();
                if(pswconvert.length < 8)
                    respuesta.setText("La contraseña es demasiado corta (<8).");
                    
                else
                respuesta.setText("La contraseña es correcta");
            }
        });

        add(psw);
        add(respuesta);

        setSize(300, 200);
        setLocation(300, 500);
        setTitle("Validar contraseña");
    }

    public static void main(String[] args){
        PswFiledPrueba pf = new PswFiledPrueba();
        pf.setVisible(true);
    }
}
