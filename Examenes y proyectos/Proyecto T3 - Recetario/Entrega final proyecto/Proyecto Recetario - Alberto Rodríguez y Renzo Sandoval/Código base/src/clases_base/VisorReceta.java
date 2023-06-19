package clases_base;

import java.util.Random;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Metodo para visualizar las recetas seleccionadas
 */
public class VisorReceta extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1;
	private static Color colorFuente = new Color(8, 80, 95);
    private static Font generalFont = new Font("Times New Roman", Font.PLAIN, 20);
    // Requerirá pasar por parámetro un array de Objects dado por la base de datos
    // Por ahora lo pongo sin parámetros pero tocará editar un poco
    Receta receta;
    int nPasos = 0;

    /**
     * Muestra la receta pasada por parámetro
     * @param receta
     */
    public VisorReceta(Receta receta) {
        //================================== INSTANCIACIÓN GENERAL ========================================
        
        this.receta = receta;

        setLayout(new GridBagLayout());
        setBackground(new Color(255, 228, 204));

        GridBagConstraints cnst = new GridBagConstraints(0, 0, 2, 4, 0, 0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 10, 30), 0, 0);
        
        //1 añadimos la imagen principal de la receta (receta[1])
        JLabel imagenP = (JLabel)instaciaImagen(receta.getImagenPrincipal(), 550);
        add(imagenP, cnst);
        
        //Cambiamos los valores necesarios para añadir el nombre
        addNombre(cnst);

        addTiempo(cnst);

        addDificultad(cnst);

        addDescripcion(cnst);

        addEtiquetas(cnst);

        addIngredientes(cnst);

        addPasos(cnst);

        addBackBoton();
    }

    /**
     * Metodo para añadir el nombre en funcion de los constraits
     * @param cnst
     */
    private void addNombre(GridBagConstraints cnst) {
        //Cambios necesarios de los constraits
        cnst.gridheight = 1;
        cnst.gridwidth = 2;
        cnst.gridx = 2;
        cnst.gridy = 0;
        
        //Pasamos de objeto a String modificado con html y lo convertimos a JLabel
        String nombreCabe = "<html><u>"+receta.getNombre().toString()+"       </u>";
        JLabel nombre = new JLabel(nombreCabe);
        
        //Establecemos fuente, color ... sus parámetros especiales
        nombre.setFont(new Font("Times New Roman", Font.BOLD, 30));
        nombre.setForeground(colorFuente);
        nombre.setBorder(null);
        nombre.setBackground(getBackground());
        
        //Se añade al viewport
        add(nombre, cnst);
    }

    /**
     * Metodo para añadir la duracion de la receta en funcion de los contraits
     * @param cnst
     */
    private void addTiempo(GridBagConstraints cnst) {
        //Cambios necesarios de los constraits
        cnst.gridwidth = 1;
        cnst.gridx = 2;
        cnst.gridy = 1;
        cnst.insets = new Insets(20, 20, 10, 0);

        //Creamos el textfield que lo contendrá
        JTextField tiempo = new JTextField(receta.getDuracion(), 10);
            tiempo.setFont(generalFont);
            tiempo.setForeground(colorFuente);
            tiempo.setBorder(null);
            tiempo.setEditable(false);
            tiempo.setBackground(getBackground());

        //Lo añadimos al viewport
        add(tiempo, cnst);

        //Volvemos a poner los separadores originales
        cnst.insets = new Insets(20, 20, 10, 30);
    }

    /**
     * Metodo para añadir la dificultad en funcion de los constraits
     * @param cnst
     */
    private void addDificultad(GridBagConstraints cnst) {
        //Cambios necesarios de los constraits
        cnst.insets = new Insets(20, 6, 10, 30);
        cnst.gridx = 3;
        cnst.gridy = 1;
        
        //Creamos y modificamos atributos
        JTextField dificultad = new JTextField(receta.getDificultad(), 15);
            dificultad.setFont(generalFont);
            dificultad.setForeground(colorFuente);
            dificultad.setBorder(null);
            dificultad.setEditable(false);
            dificultad.setBackground(getBackground());
        
        //Añadimos a viewport
        add(dificultad, cnst);

        //Volvemos a poner los separadores originales
        cnst.insets = new Insets(20, 20, 10, 30);
    }

    /**
     * Metodo para añadir la descripción en funcion de los constraits
     * @param cnst
     */
    private void addDescripcion(GridBagConstraints cnst) {
        //Establecemos constraits específicos
        cnst.gridwidth = 2;
        cnst.gridx = 2;
        cnst.gridy = 2;
        cnst.anchor = GridBagConstraints.FIRST_LINE_START;

        //Creamos el area que lo contedrá y modificamos sus atributos
        JTextArea descripcion = new JTextArea(receta.getDescripcion(), 6, 30);
            descripcion.setFont(generalFont);
            descripcion.setForeground(colorFuente);
            descripcion.setLineWrap(true);
            descripcion.setEditable(false);
            descripcion.setBackground(getBackground());

        //Añadimos al viewport
        add(descripcion, cnst);

        //Volvemos a poner las características generales de los constraits
        cnst.anchor = GridBagConstraints.CENTER;
    }

    /**
     * Metodo para añadir las etiquetas en función de los constraits
     * @param cnst
     */
    private void addEtiquetas(GridBagConstraints cnst) {
        //Cambiamos los constraits a los necesarios
        cnst.anchor = GridBagConstraints.FIRST_LINE_START;
        cnst.fill = GridBagConstraints.NONE;
        cnst.gridx = 2;
        cnst.gridy = 3;
        
        //Iniciamos los objetos necesarios para contener las etiquetas y ponerles color aleatorio
        Random rand = new Random();
        JPanel etiquetas = new JPanel(new FlowLayout());
            etiquetas.setBackground(getBackground());
            etiquetas.setPreferredSize(new Dimension(415, 80));
        //Convertimos las etiquetas a String y las pasamos a un array con split

        String tags[] = receta.getTags().split("[|]");

        //Las recorremos y agregamos colocando colores rgb aleatorios por encima de 128, 128, 128 para que el texto negro sea legible
        for(int i = 0; i < tags.length ; i++){
            int r = rand.nextInt(128)+128;
            int g = rand.nextInt(128)+128;
            int b = rand.nextInt(128)+128;

            JPanel jpTag = new JPanel();
            JLabel tag = new JLabel(tags[i]);
            tag.setFont(generalFont);
            tag.setForeground(colorFuente);

            jpTag.setBackground(new Color(r, g, b));
            jpTag.add(tag);
            etiquetas.add(jpTag);
        }
        
        //Añadimos el contenedor de etiquetas al viewPort
        add(etiquetas, cnst);

        //Volvemos a los constrait generales originales
        cnst.anchor = GridBagConstraints.CENTER;
        cnst.fill = GridBagConstraints.BOTH;
    }

    /**
     * Metodo para añdir los ingredientes en funcion de los constraits
     * @param cnst
     */
    private void addIngredientes(GridBagConstraints cnst) {
        //Los ingredientes requieren un doble split, pues almacena [ingrediente , cantidad] | [ingrediente , cantidad]
        String[] ingreCant = receta.getIngredientes().split("[|]");
        
        //Añadimos el enunciado como una celda más, pues da problemas de visualización si se mete en un scrollPane
        String ingrediente[][] = new String[ingreCant.length+1][2];
        ingrediente[0][0] = "<html><body style='background-color: rgb(146, 115, 255); padding: 8px;'><b>&nbsp;&nbsp;&nbsp;&nbsp;Ingrediente&nbsp;&nbsp;&nbsp;&nbsp;</b></body>";
        ingrediente[0][1] = "<html><body style='background-color: rgb(146, 115, 255); padding: 8px;'><b>&nbsp;&nbsp;&nbsp;&nbsp;Cantidad&nbsp;&nbsp;&nbsp;&nbsp;</b></body>";
        
        //Añadimos todos los ingredientes y cantidades a la tabla
        for(int i = 0; i < ingreCant.length; i++)
            ingrediente[i+1] = ingreCant[i].split("[,]");

        //Creamos la tabla y modificamos sus parámetros
        JTable jtIngre = new JTable(ingrediente, new String[]{"Ingrediente", "Cantidad"});
            jtIngre.setBackground(getBackground());
            jtIngre.setFont(generalFont);
            jtIngre.setForeground(colorFuente);
            jtIngre.setShowGrid(false);
            jtIngre.setRowHeight(30);
            jtIngre.setEnabled(false);

        //Establecemos los constraits necesarios
        cnst.anchor = GridBagConstraints.FIRST_LINE_START;
        cnst.gridwidth = 2;
        cnst.gridheight = 1;
        cnst.gridx = 0;
        cnst.gridy = 4;
        
        //Añadimos al viewport
        add(jtIngre, cnst);

        //Recolocamos los constraits globales estándares
        cnst.anchor = GridBagConstraints.CENTER;
    }

    /**
     * Metodo para añadir los pasos en funcion de los constraits
     * @param cnst
     */
    private void addPasos(GridBagConstraints cnst) {
        String[] pasosImagen = receta.getPasos().split("\\|\\|");
        String[][] pasos = new String[pasosImagen.length][2];
        
        for(int i = 0; i < pasos.length; i++){
            String pasoInterno[] = pasosImagen[i].split("///");
            pasos[i][0] = pasoInterno[0];
            pasos[i][1] = pasoInterno[1];
        }

        //Creamos los constraits globales para todos los pasos
        GridBagConstraints pasosConstrait = new GridBagConstraints();
            pasosConstrait.gridheight = 1;
            pasosConstrait.weightx = 1;
            pasosConstrait.insets = new Insets(20, 10, 0, 10);

        
        /*Ahora pasamos al bucle donde se añadirá cada paso, la razón de que cada uno tenga un panel propio, es para que 
          la estructura quede bien, pues si comparten panel los rellenados de weightx hacen que todo quede fuera de lugar
          Por lo que aunque comparten constraits, son cada uno un panel independiente*/
        for(int i = 0; i < pasos.length; i++){
            //Ponemos gridy = iterador para que se añadan todos seguidos en cada vuelta
            pasosConstrait.gridy = i;

            //Creamos un panel que contenga el paso
            JPanel panelPasos = new JPanel(new GridBagLayout());
                panelPasos.setBackground(getBackground());
                panelPasos.setName("panelPasos"+i);

            //Establecemos un textArea para el texto del paso y cambiamos sus atributos
            JTextArea texto = new JTextArea(pasos[i][0]);
            texto.setLineWrap(true);
            texto.setEditable(false);
            texto.setBackground(getBackground());
            texto.setForeground(colorFuente);
            texto.setFont(generalFont);

            JLabel imagen = instaciaImagen(pasos[i][1], 270);

            //En función de cual sea, se añadira en un orden u otro para dar mejor aspecto
            if(i%2 == 0)
            {
                pasosConstrait.anchor = GridBagConstraints.WEST;
                pasosConstrait.fill = GridBagConstraints.BOTH;
                pasosConstrait.gridx = 0;
                pasosConstrait.gridwidth = 3;

                panelPasos.add(texto, pasosConstrait);
                //====================================================
                pasosConstrait.anchor = GridBagConstraints.EAST;
                pasosConstrait.gridx =3;
                pasosConstrait.gridwidth = 1;
                pasosConstrait.fill = GridBagConstraints.NONE;


                panelPasos.add(imagen, pasosConstrait);

            }
            else
            {
                pasosConstrait.anchor = GridBagConstraints.EAST;
                pasosConstrait.gridx = 0;
                pasosConstrait.gridwidth = 1;
                pasosConstrait.fill = GridBagConstraints.NONE;

                panelPasos.add(imagen, pasosConstrait);

                //====================================================
                pasosConstrait.anchor = GridBagConstraints.WEST;
                pasosConstrait.fill = GridBagConstraints.BOTH;
                pasosConstrait.gridx = 1;
                pasosConstrait.gridwidth = 3;

                panelPasos.add(texto, pasosConstrait);
            }

            //establecemos constraits globales para añadir el paso al viewport
            cnst.anchor = GridBagConstraints.FIRST_LINE_START;
            cnst.gridwidth = 4;
            cnst.gridx = 0;
            cnst.gridy = 5+nPasos++;
            
            //Lo añadimos al viewport
            add(panelPasos, cnst);
        }
        //volvemos a los constraits generales
        cnst.anchor = GridBagConstraints.CENTER;
    }

    /**
     * Metodo para añadir el boton de volver atrás
     */
    private void addBackBoton() {
        
        JButton back = new JButton("Volver atrás");
        back.addActionListener(this);

        add(back, new GridBagConstraints(2, 6+nPasos, 2, 1, 0, 0, 
        GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE, new Insets(10, 10, 10, 30), 0, 0));

    }


    private JLabel instaciaImagen(String rutaIMG, int MAX_X){
        int MAX_Y = (int) (MAX_X / 1.77f);

        // Cogemos la imagen original
        ImageIcon icon = new ImageIcon(rutaIMG);
        icon = new ImageIcon(icon.getImage().getScaledInstance(MAX_X , MAX_Y, Image.SCALE_SMOOTH));
        // Añadimos el nuevo ImageIcon a la etiqueta y luego añadimos la etiqueta al panel
        return new JLabel(icon);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Recetario.setPCentralSeleccionaReceta();
    }
}
