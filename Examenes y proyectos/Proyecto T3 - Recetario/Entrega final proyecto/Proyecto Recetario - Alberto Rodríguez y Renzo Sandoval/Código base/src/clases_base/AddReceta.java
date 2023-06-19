package clases_base;

import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Clase para agregar recetas nuevas a la base de datos implementa todos sus listeners necesarios
 * Implementa Key, focus, mouse, action listeners
 */
public class AddReceta extends JPanel implements KeyListener, FocusListener, MouseListener, ActionListener{
    //Creamos todas las constantes necesarias para el correcto funcionamiento
	private static final long serialVersionUID = 1;
	private static Color colorFuente = new Color(8, 80, 95);
	private static Color colorForAddFuente = new Color(8, 80, 96);
    private static Color colorFondoPrincipal = new Color(255, 228, 204);
    private static Color colorprincipalOscuro = new Color(217, 190, 173);
    private static Font generalFont = new Font("Times New Roman", Font.PLAIN, 20);
    
    //Creamos los atributos que son necesarios desde métodos externos al constructor
    String[][] pasos;
    Receta receta = new Receta();
    JPanel principal, etiquetas, jpTag, contieneOtroPaso, panelPasos, creadorIngredientes, backsave;
    JLabel imagenPrincipal, imagenAdd, tag, origenExterno;
    JTextArea nombre, tiempo, dificultad, descripcion, escribeTag;
    JTextField buscaIngre;
    JButton save, back;
    Boolean primeraCarga = true;
    JPopupMenu muestraIngre;
    JMenuItem nuevoIngre;
    
    /**
     * Constructor principal del panel para añadir recetas
     */
    public AddReceta() {
        //Rellenamos los campos necesarios que no pueden estar vacíos
        String pasoVacio = "Introduce un paso (no escribas \"Paso 1:\" porque eso lo hace la aplicación por defecto)///assets/add.png||"; //imagen al 270
        receta.setPasos(pasoVacio);
        receta.setIngredientes("");
        nuevoIngre = new JMenuItem("Crear ingrediente");
        nuevoIngre.addActionListener(this);

        //================================== INSTANCIACIÓN GENERAL ========================================
        //Ponemos la información necesaria para el apartado visual
        setLayout(new GridBagLayout());
        setBackground(colorFondoPrincipal);
        principal = this;

        GridBagConstraints cnst = new GridBagConstraints(0, 0, 2, 4, 0, 0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 10, 30), 0, 0);
        
        //1 añadimos la imagen principal de la receta con este método
        addImagen(cnst);
        
        //añadimos el nombre 
        addNombre(cnst);
        
        //añadimos el tiempo
        addTiempo(cnst);

        //Añadir el panel para agregar la dificultad
        addDificultad(cnst);

        //Añadir el panel para agregar la descripción
        addDescripcion(cnst);
        
        //Añadir el panel para agregar las etiquetas
        addEtiquetas(cnst);
        
        //Añadir el panel para agregar los ingredientes
        addIngredientes(cnst);

        //Añadir el panel para agregar los pasos
        addPasos(cnst);
        
        //Añadir el panel para agregar los botones de ir atrás y guardar
        addBackSaveBoton();

    }

    /**
     * Utilizado junto a los constraits para poner la imagen principal
     * @param cnst
     */
    private void addImagen(GridBagConstraints cnst) {
		//No cambiamos constraits pues los iniciales son para este objeto en específico
		//agregamos la receta como un JLabel con el tamaño de 550 de ancho
        imagenPrincipal = instaciaImagen("assets/add.png", 550);
		
		//Añadimos un listener para que cuando se pulsa con el mouse, salte un file chooser para seleccionar la imagen y se guarde una copia de esta en assets
		imagenPrincipal.addMouseListener(this);
		
        //Lo añadimos al panel
		add(imagenPrincipal, cnst);
	}

    /**
     * Método para añadir el nombre principal arriba a la derecha
     * @param cnst
     */
	private void addNombre(GridBagConstraints cnst) {
        //Cambios necesarios de los constraits
        cnst.gridheight = 1;
        cnst.gridwidth = 2;
        cnst.gridx = 2;
        cnst.gridy = 0;
        
        //Creamos el text area
        nombre = new JTextArea("Introduce el nombre       ");

        //Establecemos fuente, color ... sus parámetros especiales
        nombre.setFont(new Font("Times New Roman", Font.BOLD, 30));
        nombre.setForeground(colorForAddFuente);
        nombre.setBorder(null);
        nombre.setBackground(getBackground());

        //añadimos los listeners para que autoborre cuando se empieza a escribir y para almacenar el campo
        nombre.addKeyListener(this);
        nombre.addFocusListener(this);
        
        //Se añade al viewport
        add(nombre, cnst);
    }

    /**
     * Metodo para agregar el tiempo que se tarda
     * @param cnst
     */
    private void addTiempo(GridBagConstraints cnst) {
        //Cambios necesarios de los constraits
        cnst.gridwidth = 1;
        cnst.gridx = 2;
        cnst.gridy = 1;
        cnst.insets = new Insets(20, 20, 10, 30);

        //Creamos el textfield que lo contendrá
        tiempo = new JTextArea("Añade tiempo de ejecución");
            tiempo.setPreferredSize(new Dimension(220, 80));
            tiempo.setFont(generalFont);
            tiempo.setForeground(colorForAddFuente);
            tiempo.setBorder(null);
            tiempo.setBackground(getBackground());

            tiempo.addKeyListener(this);
            tiempo.addFocusListener(this);
        //Lo añadimos al viewport
        add(tiempo, cnst);

        //Volvemos a poner los separadores originales
        cnst.insets = new Insets(20, 40, 10, 30);
    }

    /**
     * Método para añadir la dificultad de la receta
     * @param cnst
     */
    private void addDificultad(GridBagConstraints cnst) {
        //Cambios necesarios de los constraits
        cnst.insets = new Insets(20, 6, 10, 30);
        cnst.gridx = 3;
        cnst.gridy = 1;
        
        //Creamos y modificamos atributos
        dificultad = new JTextArea("Añade la dificultad");
            dificultad.setPreferredSize(new Dimension(200, 60));
            dificultad.setFont(generalFont);
            dificultad.setForeground(colorForAddFuente);
            dificultad.setBorder(null);
            dificultad.setBackground(getBackground());

            dificultad.addKeyListener(this);
            dificultad.addFocusListener(this);
        //Añadimos a viewport
        add(dificultad, cnst);

        //Volvemos a poner los separadores originales
        cnst.insets = new Insets(20, 20, 10, 30);
    }

    /**
     * Metodo para agregar una descripcion a la receta
     * @param cnst
     */
    private void addDescripcion(GridBagConstraints cnst) {
        //Establecemos constraits específicos
        cnst.gridwidth = 2;
        cnst.gridx = 2;
        cnst.gridy = 2;
        cnst.anchor = GridBagConstraints.FIRST_LINE_START;

        //Creamos el area que lo contedrá y modificamos sus atributos
        descripcion = new JTextArea("Añade una descripción corta para la receta", 6, 30);
            descripcion.setFont(generalFont);
            descripcion.setForeground(colorForAddFuente);
            descripcion.setLineWrap(true);
            descripcion.setBackground(getBackground());

            descripcion.addKeyListener(this);
            descripcion.addFocusListener(this);
        //Añadimos al viewport
        add(descripcion, cnst);

        //Volvemos a poner las características generales de los constraits
        cnst.anchor = GridBagConstraints.CENTER;
    }

    /**
     * Método para agregar el sistema de etiquetas con colores aleatorios
     * @param cnst
     */
    private void addEtiquetas(GridBagConstraints cnst) {
        //Cambiamos los constraits a los necesarios
        cnst.anchor = GridBagConstraints.FIRST_LINE_START;
        cnst.fill = GridBagConstraints.NONE;
        cnst.gridx = 2;
        cnst.gridy = 3;
        
        //Este panel contendrá las etiquetas, y luego se añadirá al principal
        JPanel addTags = new JPanel(new FlowLayout());
        addTags.setBackground(colorprincipalOscuro);

        //Este será el buscador de las recetas
        escribeTag = new JTextArea("Escribe el tag aquí ...", 1, 21);
            escribeTag.setFont(generalFont);
            escribeTag.setForeground(colorForAddFuente);
            escribeTag.addKeyListener(this);
            escribeTag.addFocusListener(this);

        //Creamos la imagen lateral de las tags que sirve también para añadirlas
        imagenAdd = instaciaImagen("assets/add.png", 50);
        imagenAdd.addMouseListener(this);
        
        addTags.add(escribeTag);
        addTags.add(imagenAdd);

        //Iniciamos los objetos necesarios para contener las etiquetas y ponerles color aleatorio
        Random rand = new Random();
        etiquetas = new JPanel(new FlowLayout());
            etiquetas.setBackground(getBackground());
            etiquetas.setPreferredSize(new Dimension(415, 120));

        etiquetas.add(addTags, cnst);

        //Ahora pasamos al visualizador de las etiquetas ya añadidas
        //Pasamos a un array con split
        String cadenaTags = receta.getTags();
        String tags[] = cadenaTags.split("[|]");

        //Las recorremos y agregamos colocando colores rgb aleatorios por encima de 128, 128, 128 para que el texto negro sea legible
        //la comprobación es para evitar errores por el espacio vacío la primera vez que se genere
        if(!primeraCarga)
            for(int i = 0; i < tags.length ; i++){
                //Si el texto está vacio, pasamos al siguiente
                if(tags[i].length() == 0) continue;

                //Creamos un color claro aleatorio
                int r = rand.nextInt(128)+128;
                int g = rand.nextInt(128)+128;
                int b = rand.nextInt(128)+128;

                //Añadimos el tag con el color
                jpTag = new JPanel();
                tag = new JLabel(tags[i]);
                tag.setFont(generalFont);
                tag.setForeground(colorFuente);
                tag.addMouseListener(this);

                jpTag.setBackground(new Color(r, g, b));
                jpTag.add(tag);
                
                etiquetas.add(jpTag);
            }
        
        //Añadimos el contenedor de etiquetas al viewPort
        primeraCarga = false;
        add(etiquetas, cnst);

        //Volvemos a los constrait generales originales
        cnst.anchor = GridBagConstraints.CENTER;
        cnst.fill = GridBagConstraints.BOTH;
    }

    /**
     * Metodo para agregar el seleccionador de ingredientes, añade panel de búsqueda, desplegable popup y tabla de visualización
     * @param cnst
     */
    private void addIngredientes(GridBagConstraints cnst) {
        //Creamos un panel para el apartado de seleccionar ingredientes
        creadorIngredientes = new JPanel(new BorderLayout());
        String ingrediente[][] = null;
        JTable jtIngre = null;

        //Le damos texto y atributos
        buscaIngre = new JTextField("Escribe el ingrediente ...");
            buscaIngre.setFont(generalFont);
            buscaIngre.setForeground(colorForAddFuente);

            buscaIngre.addKeyListener(this);
            buscaIngre.addFocusListener(this);

        //Creamos el popupmenu que muestra las coincidencias de ingredientes
        muestraIngre = new JPopupMenu();
        muestraIngre.setFont(generalFont);

        //Agregamos el buscador al panel
        creadorIngredientes.add(buscaIngre, BorderLayout.NORTH);
        
        //Los ingredientes requieren un doble split, pues almacena [ingrediente , cantidad] | [ingrediente , cantidad]
        if(receta.getIngredientes() != "" && receta.getIngredientes() != null)
        {
            //Separamos los ingredientes
            String ingredientesSinFil = receta.getIngredientes();
            String[] ingreCant = ingredientesSinFil.split("[|]");
        
            //Añadimos el enunciado como una celda más, pues da problemas de visualización si se mete en un scrollPane
            ingrediente = new String[ingreCant.length+1][2];
            ingrediente[0][0] = "<html><body style='background-color: rgb(146, 115, 255); padding: 8px;'><b>&nbsp;&nbsp;&nbsp;&nbsp;Ingrediente&nbsp;&nbsp;&nbsp;&nbsp;</b></body>";
            ingrediente[0][1] = "<html><body style='background-color: rgb(146, 115, 255); padding: 8px;'><b>&nbsp;&nbsp;&nbsp;&nbsp;Cantidad&nbsp;&nbsp;&nbsp;&nbsp;</b></body>";
        
            //Añadimos todos los ingredientes y cantidades a la tabla, separandolos con un split
            for(int i = 0; i < ingreCant.length; i++)
                ingrediente[i+1] = ingreCant[i].split("[,]");
            
            //Creamos la tabla y modificamos sus parámetros
            jtIngre = new JTable(ingrediente, new String[]{"Ingrediente", "Cantidad"});
                jtIngre.setBackground(getBackground());
                jtIngre.setFont(generalFont);
                jtIngre.setForeground(colorFuente);
                jtIngre.setShowGrid(false);
                jtIngre.setRowHeight(30);
                jtIngre.setEnabled(false);
        
            creadorIngredientes.add(jtIngre, BorderLayout.CENTER);
        }

        //Ponemos los constraits generales y añadimos el panel con todo
        cnst.anchor = GridBagConstraints.FIRST_LINE_START;
        cnst.gridwidth = 2;
        cnst.gridheight = 1;
        cnst.gridx = 0;
        cnst.gridy = 4;

        add(creadorIngredientes, cnst);
        //Recolocamos los constraits globales estándares
        cnst.anchor = GridBagConstraints.CENTER;
    }

    /**
     * Metodo para añadir los pasos; su texto, imagen y posibles más pasos
     * @param cnst
     */
    private void addPasos(GridBagConstraints cnst) {
        
        //Primero descomponemos los pasos en una matriz, pues viene junto a su imagen y otros pasos en un solo String
        String[] pasosImagen = receta.getPasos().split("\\|\\|");
        pasos = new String[pasosImagen.length][2];
        
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
            panelPasos = new JPanel(new GridBagLayout());
                panelPasos.setBackground(getBackground());
                panelPasos.setName("panelPasos"+i);

            //Establecemos un textArea para el texto del paso y cambiamos sus atributos
            JTextArea texto = new JTextArea(pasos[i][0]);
            texto.setLineWrap(true);
            texto.setBackground(getBackground());
            texto.setForeground(colorForAddFuente);
            texto.setFont(generalFont);

            texto.addKeyListener(this);
            texto.addFocusListener(this);

            JLabel imagen = instaciaImagen(pasos[i][1], 270);
            imagen.addMouseListener(this);

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
            cnst.gridy = 5+i;
            
            //Lo añadimos al viewport
            add(panelPasos, cnst);


        }
        //volvemos a los constraits generales
        cnst.anchor = GridBagConstraints.CENTER;

        contieneOtroPaso = new JPanel(new BorderLayout());
        contieneOtroPaso.setBackground(colorprincipalOscuro);
        contieneOtroPaso.addMouseListener(this);

        JLabel otroPaso = instaciaImagen("assets/add.png", 300);
        otroPaso.setText("Click para añadir otro paso");

        contieneOtroPaso.add(otroPaso, BorderLayout.CENTER);

        cnst.gridy = 5+pasos.length;

        add(contieneOtroPaso, cnst);
    }

    /**
     * Añade al final del todo los botones para poder volver al panel anterior o guardar la receta
     */
    private void addBackSaveBoton() {
        //Todo va contenido en un panel backsave
        backsave = new JPanel(new FlowLayout());
        backsave.setBackground(colorprincipalOscuro);
        
        //Creamos el botón de guardar
        save = new JButton("Guardar la receta");
        save.addActionListener(this);

        //creamos el botón de volver
        back = new JButton("Volver atrás");
        back.addActionListener(this);

        //Los añadimos al panel, y el panel al visor
        backsave.add(back);
        backsave.add(save);

        add(backsave, new GridBagConstraints(2, 6+pasos.length, 2, 1, 0, 0, 
        GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE, new Insets(10, 10, 10, 30), 0, 0));
    }


    /**
     * El metodo convierte todas las rutas de imagen en un jlabel, del tamañado dado en el segundo paramáetro
     * @param rutaIMG
     * @param MAX_X
     * @return Label con la imagen y tamañado dados
     */
    private JLabel instaciaImagen(String rutaIMG, int MAX_X){
        //Creamos el alto con una escala aproximada para que las i mágenes 16:9 no se deformen
        int MAX_Y = (int) (MAX_X / 1.77f);

        // Cogemos la imagen original
        ImageIcon icon = new ImageIcon(rutaIMG);
        icon = new ImageIcon(icon.getImage().getScaledInstance(MAX_X , MAX_Y, Image.SCALE_SMOOTH));
        // Añadimos el nuevo ImageIcon a la etiqueta y luego añadimos la etiqueta al panel
        return new JLabel(icon);
    }

	/**
     * Metodo para implementar todos los componentes que requieren presionar una tecla
     * (de KeyListener)
     * @Override
     */
	public void keyPressed(KeyEvent e) {
        //Hay dos posibilidades, text areas y fields
        JTextArea origenA;
        JTextField origenF;

        //Si es un area, podrá ser cualquier campo de texto que no sea el buscador de ingredientes
        if(e.getSource() instanceof JTextArea)
        {
            //Se almacena el origen
            origenA = (JTextArea)e.getSource();

            //Si no es una tecla de tabulación o enter, y tiene el color de colorForAddFuente,
            //significa que no se ha modificado aún, así que hacemos un efecto de que
            //cuando se empieze a escribir se borre el texto por defecto, poniendo el color
            //normal de la aplicación (blue de 1 más) para que sea igual pero no lo borre ahora
    		if(origenA.getForeground() == colorForAddFuente) {
                origenA.setText("");
                origenA.setForeground(colorFuente);
		    }
            //Si es un tabulador o enter (y no es la descripción) forzamos que peirda el foco
            if((int)e.getKeyChar() == 9 || ((int)e.getKeyChar() == 10 && e.getSource() != descripcion)){
                //con consume hacemos que no se guarde la tecla para evitar problemas
                e.consume();
                origenA.transferFocus();
            }
        }
        //en caso de que sea un textfield, solo podrá ser el buscador de ingredientes
        else
        {
            //hacemos el mismo proceso inicialmente que con los textArea
            origenF = (JTextField)e.getSource();
            if(origenF.getForeground() == colorForAddFuente) {
                origenF.setText("");
                origenF.setForeground(colorFuente);
            }

            if((int)e.getKeyChar() == 9 || (int)e.getKeyChar() == 10)
            {
                e.consume();
                origenF.transferFocus();
            }
            //en caso de que se pulse CUALQUIER letra que no sea tabulador o enter,
            //se hará una comprobación con la base de ingredientes y se mostrará en tiempo real las coincidencias
            else
            {
                //hacemos la conexión
                Connection con = UConnection.getConnection();
                muestraIngre.removeAll();

                //creamos la sentencia de búsqueda, si no hay nada escrito, para que no se llene la pantalla no se mostrará nada
                String sql = "SELECT nombre FROM ingrediente";
                sql += " WHERE nombre LIKE ?";

                try {
                    //ejecutamos la sentencia y desparametrizamos para buscar coincidencias
                    PreparedStatement pstm = con.prepareStatement(sql);
                    pstm.setString(1, "%"+origenF.getText()+"%");
                    ResultSet rs = pstm.executeQuery();

                    //añadimos al popUpMenu los resultados como jMenuItem 
                    while(rs.next()){
                        muestraIngre.add(new JMenuItem(rs.getString(1)));
                    }
                    //añadimos un separador y luego un botón para añadir ingredientes en caso de que no haya coincidencias
                    muestraIngre.addSeparator();
                    muestraIngre.add(nuevoIngre);

                    //recargamos los componentes para que se visualize bien
                    muestraIngre.revalidate();
                    muestraIngre.setVisible(true);
                    muestraIngre.setLocation(buscaIngre.getX(), buscaIngre.getY()+(int)(buscaIngre.getHeight()*2.6));

                } catch (SQLException er) {
                    System.err.println("Error buscando los ingredientes");
                }
            }
        }
	}

    /**
     * Metodo para reeimplementar el sistema de búsqueda de añadir ingredientes para evitar errores
     * (de KeyListener)
     * @Override
     */
	public void keyTyped(KeyEvent e) 
    {
        JTextField origenF;

        if(e.getSource() instanceof JTextArea)
        {
        
        }
        else
        {
            origenF = (JTextField)e.getSource();
            if(origenF.getForeground() == colorForAddFuente) {
                origenF.setText("");
                origenF.setForeground(colorFuente);
            }

            if((int)e.getKeyChar() == 9 || (int)e.getKeyChar() == 10)
            {
                e.consume();
                origenF.transferFocus();
            }
            else
            {
                Connection con = UConnection.getConnection();
                muestraIngre.removeAll();

                String sql = "SELECT nombre FROM ingrediente";
                sql += " WHERE nombre LIKE ?";

                try {
                    PreparedStatement pstm = con.prepareStatement(sql);
                    pstm.setString(1, "%"+origenF.getText()+e.getKeyChar()+"%");
                    ResultSet rs = pstm.executeQuery();

                    while(rs.next()){
                        JMenuItem ingredienteEncontrado = new JMenuItem(rs.getString(1));
                        ingredienteEncontrado.addActionListener(this);

                        muestraIngre.add(ingredienteEncontrado);
                    }
                    muestraIngre.addSeparator();
                    muestraIngre.add(nuevoIngre);
                    muestraIngre.setVisible(false);
                    muestraIngre.setVisible(true);
                    muestraIngre.revalidate();
                    muestraIngre.setLocation(creadorIngredientes.getX(), creadorIngredientes.getY()+(int)(buscaIngre.getHeight()*2.6));
                    
                    creadorIngredientes.revalidate();

                } catch (SQLException er) {
                    System.err.println("Error buscando los ingredientes");
                }                
            }
        }
    }

    /**
     * Metodo para interpretar la pérdida de foco de los componentes
     * (de FocusListener)
     * @Override
     */
    public void focusLost(FocusEvent e) {
        //Si es un textfield es del buscador de ingredientes, se hará para ocultar el PopUpMenu cuando se pieda el foco
        if(e.getSource() instanceof JTextField)
        {

            muestraIngre.setVisible(false);
            muestraIngre.revalidate();

            creadorIngredientes.revalidate();
            principal.revalidate();
        }
        //En caso de ser un TextArea, será información directa de la receta, la almacenaremos en su debido lugar
        else
        {
            JTextArea origen = (JTextArea)e.getSource();
            if(origen == nombre)
                receta.setNombre(origen.getText());
            
            else if(origen == tiempo)
                receta.setDuracion(origen.getText());

            else if(origen == dificultad)
                receta.setDificultad(origen.getText());

            else if(origen == descripcion)
                receta.setDescripcion(origen.getText());
            
            //En caso de ser los tagss, requiere ser procesado para guardarlos con los separadores
            else if(origen == escribeTag){
                String tagsPrevios = receta.getTags();

                if(tagsPrevios.length() == 0)
                    tagsPrevios = escribeTag.getText();
                else
                    tagsPrevios += "|"+escribeTag.getText();

                receta.setTags(tagsPrevios);
                principal.remove(etiquetas);
                etiquetas = null;
                addEtiquetas(new GridBagConstraints(2, 3, 2, 1, 0, 0,
                GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(20, 20, 10, 30), 0, 0));

                etiquetas.revalidate();

            }
            //si tiene dos paneles contenedores, será solo los pasos, que requieren como las etiquetas, ser procesados
            else if(origen.getParent().getParent() == principal){
                String pasoImg[] = receta.getPasos().split("\\|\\|");

                    JPanel padre = (JPanel)origen.getParent();
                    receta.setPasos("");
                    for (int i = 0; i < pasoImg.length; i++) {
                        String pasos[] = pasoImg[i].split("///");
                        
                        if(padre.getName().contains(Integer.toString(i)))
                            receta.setPasos(receta.getPasos()+origen.getText()+"///");
                        
                        else
                            receta.setPasos(receta.getPasos()+pasos[0]+"///");

                        receta.setPasos(receta.getPasos()+pasos[1]+"||");
                    }

                    Component[] components = principal.getComponents();
                    for (Component component : components) {
                        if (component instanceof JPanel && component.getName() != null && component.getName().contains("panelPasos")) {
                            principal.remove(component);
                        }
                    }
                    principal.revalidate();
                    principal.remove(contieneOtroPaso);
                    principal.remove(backsave);

                    addPasos(new GridBagConstraints(0, 5, 4, 1, 0, 0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 10, 30), 0, 0));
                    
                    addBackSaveBoton();

                    revalidate();
                    panelPasos.revalidate();
                    principal.repaint();
            }
        }
    }

    /**
     * @Override
     * Metodo para interpretar la adquisición del foco
     * (de FocusListener)
     */
    public void focusGained(FocusEvent e) {
        //Solo puede ser el buscador de ingredientes, cuando gana el foco, se muestra el popupmenu de coincidencias
        if(e.getSource() instanceof JTextField){
            muestraIngre.setVisible(true);
            muestraIngre.setLocation(buscaIngre.getX(), buscaIngre.getY()+(int)(buscaIngre.getHeight()*2.6));
            creadorIngredientes.revalidate();
            muestraIngre.revalidate();
        }
    }

    /**
     * @Override
     * Metodo para interpretar todo lo que requierda un clic con el mouse
     * (de MouseListener)
     */ 
    public void mouseClicked(MouseEvent e) {
        JLabel origen;

        //En caso de que sea un Label y sea el de la imagen principal,
        if(e.getSource() instanceof JLabel && (JLabel)e.getSource() == imagenPrincipal){
            //Creamos el fileChooser para elegir las imágenes (sin gif, que no se visualizan)
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", "png", "jpeg", "jpg", "webp"));
            
            //Si hay una selección de imagen
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                //Copiamos la imagen a la carpeta de assets para que siempre sea accesible
                try {
                    Files.copy(Paths.get(fileChooser.getSelectedFile().getPath()), Paths.get("assets/"+fileChooser.getSelectedFile().getName()));
                } catch (IOException e1) {
                    System.err.println("Error haciendo la copia del archivo de imagen");
                }
                //Almacenamos la imagen en el objeto que luego irá a la base de datos
                receta.setImagenPrincipal("assets/"+fileChooser.getSelectedFile().getName());
                
                //Eliminamos la imagen que había antes, y añadimos la seleccionada a la ventana
                principal.remove(imagenPrincipal);
                imagenPrincipal = instaciaImagen((String)receta.getImagenPrincipal(), 550);
                imagenPrincipal.addMouseListener(this);

                //Ponemos sus constraits originales y la agregamos
                add(imagenPrincipal, new GridBagConstraints(0, 0, 2, 4, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 10, 30), 0, 0));
                
                revalidate();
            }
        }
        //En caso de que sea de un paso, tendrá el panel principal a 2 Parent por encima,
        else if(e.getSource() instanceof JLabel && ((JLabel)e.getSource()).getParent().getParent() == principal){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", "png", "jpeg", "jpg", "webp"));

            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                //Copiamos la imagen a la carpeta de assets para que siempre sea accesible
                try {
                    Files.copy(Paths.get(fileChooser.getSelectedFile().getPath()), Paths.get("assets/"+fileChooser.getSelectedFile().getName()));
                } catch (IOException e1) {
                    System.err.println("Error haciendo la copia del archivo de imagen");
                }
                //Almacenamos la imagen en el objeto que luego irá a la base de datos
                String pasoImg[] = receta.getPasos().split("\\|\\|");

                JLabel source = (JLabel)e.getSource();
                JPanel padre = (JPanel)source.getParent();
                receta.setPasos("");
                for (int i = 0; i < pasoImg.length; i++) {
                    String pasos[] = pasoImg[i].split("///");
                    receta.setPasos(receta.getPasos()+pasos[0]+"///");
                    
                    if(padre.getName().contains(Integer.toString(i)))
                    receta.setPasos(receta.getPasos()+"assets/"+fileChooser.getSelectedFile().getName()+"||");
                    
                    else
                        receta.setPasos(receta.getPasos()+pasos[1]+"||");
                        
                }

                Component[] components = principal.getComponents();
                for (Component component : components) {
                    if (component instanceof JPanel && component.getName() != null && component.getName().contains("panelPasos")) {
                        principal.remove(component);
                    }
                }
                principal.revalidate();
                principal.remove(contieneOtroPaso);
                principal.remove(backsave);

                addPasos(new GridBagConstraints(0, 5, 4, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 10, 30), 0, 0));
                
                addBackSaveBoton();

                revalidate();
                panelPasos.revalidate();
                principal.repaint();
            }

        }
        else if(e.getSource() instanceof JLabel && (JLabel)e.getSource() == imagenAdd){
            origen = (JLabel)e.getSource();
            origen.requestFocus();
        }
        //En caso de que sea un panel, será solo el de añadir nuevos pasos, se añade uno y se recarga todo
        else if (e.getSource() instanceof JPanel){

            receta.setPasos(receta.getPasos() + "Introduce un paso (no escribas \"Paso n:\" porque eso lo hace la aplicación por defecto)///assets/add.png||");
            
            Component[] components = principal.getComponents();
            for (Component component : components) {
                if (component instanceof JPanel && component.getName() != null && component.getName().contains("panelPasos")) {
                    principal.remove(component);
                }
            }
            principal.revalidate();
            principal.remove(contieneOtroPaso);
            principal.remove(backsave);
            
            addPasos(new GridBagConstraints(0, 5, 4, 1, 0, 0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 10, 30), 0, 0));
            
            addBackSaveBoton();

            revalidate();
            panelPasos.revalidate();
            principal.repaint();
        }
    }

    /**
     * @Override
     * MousePresed para la opción deborrar etiquetas
     * (de MoseListener)
     */
    public void mousePressed(MouseEvent e) {
        //Si es un JLabel y es el triger del sistema, al pulsar una etiqueta con clic derecho sale la opción de borrar
        if(e.getSource() instanceof JLabel){
            origenExterno = (JLabel)e.getSource();

            if(origenExterno.getParent().getParent() == etiquetas && e.isPopupTrigger()){
                JPopupMenu tagPM = new JPopupMenu();
                
                JMenuItem borraTag = new JMenuItem("Borrar la etiqueta");
                borraTag.addMouseListener(this);
                
                tagPM.add(borraTag);
                tagPM.show(e.getComponent(), e.getX(), e.getY());
            }
        }
        //si se ha pulsado la opcion del popUp, se procesa el borrado
        if(e.getSource() instanceof JMenuItem){
            principal.remove(etiquetas);
            etiquetas = null;

            String[] etiquetas = receta.getTags().split("[|]");
            
            receta.setTags("");

            for(int i = 0; i < etiquetas.length; i++){
                if(etiquetas[i].equals(origenExterno.getText()))
                    etiquetas[i] = "";
                else{
                    if(receta.getTags().length() == 0)
                        receta.setTags(etiquetas[i]);
                    else
                        receta.setTags("|"+etiquetas[i]);
                }
            }

            addEtiquetas(new GridBagConstraints(2, 3, 2, 1, 0, 0,
            GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(20, 20, 10, 30), 0, 0));

            principal.revalidate();
            jpTag.revalidate();
        }
    }

    /**
     * @Override
     * Metodo de MouseListener para procesar la otra posibilidad del trigger del sistema
     */
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() instanceof JLabel){
            origenExterno = (JLabel)e.getSource();

            if(origenExterno.getParent().getParent() == etiquetas && e.isPopupTrigger()){
                JPopupMenu tagPM = new JPopupMenu();
                
                JMenuItem borraTag = new JMenuItem("Borrar la etiqueta");
                borraTag.addMouseListener(this);
                
                tagPM.add(borraTag);
                tagPM.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    /**
     * @Override
     * Metodo de ActionListener para procesar los eventos de acción
     */
    public void actionPerformed(ActionEvent e) {
        // Implementación para el botón de guardado
        if(e.getSource() instanceof JButton && e.getSource() == save)
        {
            //Se crea la conexión y la sentencia parametrizada
            Connection con = UConnection.getConnection();
            String sql = "INSERT INTO receta (imagenPrincipal, nombre, duracion, dificultad, descripcion, tags, ingredientes, pasos) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            try {
                //vamos desparametrizando de uno en uno, en caso de que falte algo por añadir, saltará un mensaje de error y se cancelará
                PreparedStatement pstm = con.prepareStatement(sql);
                if(!receta.getImagenPrincipal().contains("add.png"))
                    pstm.setString(1, receta.getImagenPrincipal());
                else{
                    System.out.println(receta.getImagenPrincipal());
                    JOptionPane.showMessageDialog(principal, "Error. Debes añadir una imagen principal", "Error de registro", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(!receta.getNombre().contains("Introduce el nombre"))
                    pstm.setString(2, receta.getNombre());
                else{
                    JOptionPane.showMessageDialog(principal, "Error. Debes añadir un nombre", "Error de registro", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(receta.getDuracion().length() > 0)
                    pstm.setString(3, receta.getDuracion());
                else{
                    JOptionPane.showMessageDialog(principal, "Error. Debes añadir una duración", "Error de registro", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(receta.getDificultad().length() > 0)
                    pstm.setString(4, receta.getDificultad());
                else{
                    JOptionPane.showMessageDialog(principal, "Error. Debes añadir una dificultad", "Error de registro", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(receta.getDescripcion().length() > 0)
                    pstm.setString(5, receta.getDescripcion());
                else{
                    JOptionPane.showMessageDialog(principal, "Error. Debes añadir una descripción", "Error de registro", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(receta.getTags().length() > 0)
                    pstm.setString(6, receta.getTags());
                else{
                    JOptionPane.showMessageDialog(principal, "Error. Debes añadir una etiqueta", "Error de registro", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(receta.getIngredientes().length() > 0)
                    pstm.setString(7, receta.getIngredientes());
                else{
                    JOptionPane.showMessageDialog(principal, "Error. Debes añadir un ingrediente como mínimo", "Error de registro", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(!receta.getPasos().contains("Introduce un paso (no escribas") || !receta.getPasos().contains("Introduce un paso (no escribas")){    
                    
                    receta.setPasos(receta.getPasos().replaceAll("assets/add.png", "assets/vacio.png"));

                    pstm.setString(8, receta.getPasos());
                }

                else{
                    JOptionPane.showMessageDialog(principal, "Error. Debes añadir un algun paso o tienes uno sin poner", "Error de registro", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(pstm.executeUpdate() == 1)
                {
                    JOptionPane.showMessageDialog(principal, "¡¡Receta añadida!!", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    Recetario.setPCentralMenuEleccion();
                }
                else
                    JOptionPane.showMessageDialog(principal, "Error desconocido añadiendo la receta a la base datos", "Error de registro", JOptionPane.WARNING_MESSAGE);

            } catch (SQLException er) {
                er.printStackTrace();
            }
        
        }
        //En caso de que sea el botón de volver atrás solo se carga ese panel
        else if(e.getSource() instanceof JButton && e.getSource() == back)
        {
            Recetario.setPCentralMenuEleccion();
        }

        //si fue un MenuItem, significa que se selecciono un ingrediente, por lo que se preguntará que cantidad de éste se quiere y se añadirá a la tabla
        else if(e.getSource() instanceof JMenuItem)
        {
            if(((JMenuItem)e.getSource()).getText() != nuevoIngre.getText())
            {
                String respuesta = JOptionPane.showInputDialog(principal, "¿Qué cantidad de "+((JMenuItem)e.getSource()).getText()+" hace falta?:");
                receta.setIngredientes(receta.getIngredientes()+((JMenuItem)e.getSource()).getText()+","+respuesta+"|");

                creadorIngredientes.removeAll();
                principal.remove(creadorIngredientes);
                addIngredientes(new GridBagConstraints(0, 0, 2, 4, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 10, 30), 0, 0));

                creadorIngredientes.revalidate();
                principal.revalidate();
            }
            //Si entra por aquí solo podra ser "añadir ingrediente", así que se pedirá para añadirlo
            else
            {
                String[] campos = {"Nombre:", "Precio:", "origen:", "Estado:"};
                JTextField[] textFields = new JTextField[campos.length];
                JPanel panel = new JPanel(new GridLayout(campos.length, 1));
                
                for (int i = 0; i < campos.length; i++) {
                    JLabel label = new JLabel(campos[i]);
                    textFields[i] = new JTextField();
                    panel.add(label);
                    panel.add(textFields[i]);
                }
                int option = JOptionPane.showOptionDialog(principal, panel, "Ingrese los datos del ingrediente:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
                if (option == JOptionPane.OK_OPTION) {
                    
                    Connection con = UConnection.getConnection();
                    String sql = "INSERT INTO ingrediente (nombre, precio, origen, estado_preferente) VALUES (?, ?, ?, ?)";

                    try {
                        PreparedStatement pstm = con.prepareStatement(sql);

                        pstm.setString(1, textFields[0].getText());
                        pstm.setString(2, textFields[1].getText());
                        pstm.setString(3, textFields[2].getText());
                        pstm.setString(4, textFields[3].getText());

                        pstm.executeUpdate();

                    } catch (SQLException er) {
                        er.printStackTrace();
                    }
                }
            }
        }
    }

	@Override
	public void keyReleased(KeyEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
