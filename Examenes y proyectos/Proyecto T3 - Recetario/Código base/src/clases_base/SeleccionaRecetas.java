package clases_base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Clase para mostrar recetas de la base de datos y seleccionarlas
 * Implementa Key y Focus Listeners
 */
public class SeleccionaRecetas extends JPanel implements KeyListener, FocusListener{

    //Atributos staticos para su suo
    private static final long serialVersionUID = 1;
    private static Color colorFuente = new Color(8, 80, 95);
    private static Color colorFondoPrincipal = new Color(255, 228, 204);
    private static Color colorForAddFuente = new Color(8, 80, 96);
    private static Color colorprincipalOscuro = new Color(217, 190, 173);
    private static Font generalFont = new Font("Times New Roman", Font.PLAIN, 20);
    
    JTextField busqueda;
    JPanel principal, norte;
    ArrayList<Receta> todasRecetas;

    /**
     * Constructor
     */
    public SeleccionaRecetas(){
        
        //================================== INSTANCIACIÓN GENERAL ========================================
        principal = this;
        norte = new JPanel(new FlowLayout(SwingConstants.RIGHT));
        norte.setBackground(colorFondoPrincipal);

        setLayout(new BorderLayout());
        setBackground(colorFondoPrincipal);

        busqueda = new JTextField("Escribe el nombre de la receta ...", 20);
        busqueda.setBackground(colorFondoPrincipal);
        busqueda.setForeground(colorForAddFuente);
        busqueda.setFont(generalFont);
        busqueda.addKeyListener(this);
        busqueda.addFocusListener(this);
        
        JButton back = new JButton("Volver atrás");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Recetario.setPCentralMenuEleccion();
            }
        });
        
        norte.add(back);
        
        JLabel pre = new JLabel("Escribe el nombre de la receta: ");
        pre.setFont(generalFont);
        pre.setBackground(colorFondoPrincipal);
        
        norte.add(pre);
        norte.add(busqueda);
        add(norte, BorderLayout.NORTH);
        
        try{
            addRecetasCoincidentes("");
        }catch(SQLException e){

        }
    }

    /**
     * Metodo que hace la búsqueda en función del texto pasado por parametro
     * @param txt
     * @throws SQLException
     */
    private void addRecetasCoincidentes(String txt) throws SQLException{
        todasRecetas = resultadoRecetas(txt);
        JPanel panelRecetas = new JPanel(new GridBagLayout());
        panelRecetas.setBackground(colorFondoPrincipal);

        GridBagConstraints cnst = new GridBagConstraints(3, 0, 1, 1, 1, 0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 10, 30), 0, 0);

        //Creamos los constraits globales para todos los pasos
        GridBagConstraints recetasCosntrait = new GridBagConstraints();
            recetasCosntrait.gridheight = 1;
            recetasCosntrait.weightx = 1;
            recetasCosntrait.insets = new Insets(20, 10, 0, 10);

        
        /*Ahora pasamos al bucle donde se añadirá cada paso, la razón de que cada uno tenga un panel propio, es para que 
          la estructura quede bien, pues si comparten panel los rellenados de weightx hacen que todo quede fuera de lugar
          Por lo que aunque comparten constraits, son cada uno un panel independiente*/
        for(int i = 0; i < todasRecetas.size(); i++){
            //Ponemos gridy = iterador para que se añadan todos seguidos en cada vuelta
            recetasCosntrait.gridy = i;

            //Creamos un panel que contenga el paso
            JPanel panelUnaReceta = new JPanel(new GridBagLayout());
                panelUnaReceta.setBackground(colorprincipalOscuro);
                panelUnaReceta.setName(Integer.toString(todasRecetas.get(i).getID()));

            //Establecemos un textArea para el texto del paso y cambiamos sus atributos
            JTextArea texto = new JTextArea(todasRecetas.get(i).getNombre()+"\n"+todasRecetas.get(i).getTags()+"\n"+
            todasRecetas.get(i).getDuracion()+"\n"+todasRecetas.get(i).getDificultad()+"\n"+todasRecetas.get(i).getDescripcion());

            texto.setLineWrap(true);
            texto.setEditable(false);
            texto.setBackground(colorprincipalOscuro);
            texto.setForeground(colorFuente);
            texto.setFont(generalFont);

            JLabel imagen = instaciaImagen(todasRecetas.get(i).getImagenPrincipal(), 270);


            recetasCosntrait.anchor = GridBagConstraints.EAST;
            recetasCosntrait.gridx = 0;
            recetasCosntrait.gridwidth = 1;
            recetasCosntrait.fill = GridBagConstraints.NONE;

            panelUnaReceta.add(imagen, recetasCosntrait);

            //====================================================
            recetasCosntrait.anchor = GridBagConstraints.WEST;
            recetasCosntrait.fill = GridBagConstraints.BOTH;
            recetasCosntrait.gridx = 1;
            recetasCosntrait.gridwidth = 3;

            panelUnaReceta.add(texto, recetasCosntrait);

            //establecemos constraits globales para añadir el paso al viewport
            cnst.anchor = GridBagConstraints.FIRST_LINE_START;
            cnst.gridwidth = 4;
            cnst.gridx = 0;
            cnst.gridy = i;
            
            panelUnaReceta.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    
                    JPanel origen = (JPanel)e.getSource();

                    for (int i = 0; i < todasRecetas.size(); i++) {
                        if(origen.getName().equals(Integer.toString(todasRecetas.get(i).getID()))){
                            Recetario.setPCentralVerReceta(todasRecetas.get(i));
                            return;
                        }
                    }
                }
            });

            //Lo añadimos al viewport
            panelRecetas.add(panelUnaReceta, cnst);
            add(panelRecetas);
        }
    }

    /**
     * Metodo que genera los resultados de las recetas en un arraylist que devuelve
     * @param texto
     * @return
     * @throws SQLException
     */
    private ArrayList<Receta> resultadoRecetas(String texto) throws SQLException{
        ArrayList<Receta> todasRecetas = new ArrayList<Receta>();
        
        Connection con = UConnection.getConnection();
        String sql = "Select * from receta";

        PreparedStatement pstm;
        if(texto.length() != 0){
            sql += " WHERE nombre LIKE ?";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, '%'+busqueda.getText()+'%');
        }
        else
            pstm = con.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();

        while(rs.next()){
            todasRecetas.add(new Receta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
            rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
        }

        return todasRecetas;
    }

    /**
     * Metodo que devuelve las imagenes como JLabels en función de su ruta y tamaño
     * @param rutaIMG
     * @param MAX_X
     * @return
     */
    private JLabel instaciaImagen(String rutaIMG, int MAX_X){
        int MAX_Y = (int) (MAX_X / 1.77f);

        // Cogemos la imagen original
        ImageIcon icon = new ImageIcon(rutaIMG);
        icon = new ImageIcon(icon.getImage().getScaledInstance(MAX_X , MAX_Y, Image.SCALE_SMOOTH));
        // Añadimos el nuevo ImageIcon a la etiqueta y luego añadimos la etiqueta al panel
        return new JLabel(icon);
    }

    /**
     * Metodo para recargar visiblemente las recetas
     */
    private void recargaRecetas(){
        try{
            Component[] components = principal.getComponents();
            for (Component component : components) {
                if (component instanceof JPanel && component.getName() != null && component.getName().contains("panelUnaReceta")) {
                    principal.remove(component);
                }
            }
            principal.revalidate();

            addRecetasCoincidentes(busqueda.getText());
            
            principal.revalidate();
        
        }catch(SQLException er){
            
        }
    }

    /**
     * @Override
     * Metodo para cargar las recetas cuando se ha terminado de escribir su nombre
     */
    public void focusLost(FocusEvent e) {
         
        if(e.getSource() == busqueda){
            recargaRecetas();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        JTextField origen = (JTextField)e.getSource();

        if(e.getKeyChar() == 9 || e.getKeyChar() == 10){
            try{
                resultadoRecetas(busqueda.getText());
                recargaRecetas();
            }catch(SQLException er){
            }
        }
        else
            if(origen.getForeground() == colorForAddFuente){
                origen.setText("");
                origen.setForeground(colorFuente);
            }
    }

    @Override
    public void focusGained(FocusEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
