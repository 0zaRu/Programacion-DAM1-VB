package clases_base;
import java.awt.BorderLayout;

import javax.swing.JScrollPane;

/**
 * Clase principal de la aplicación, contiene el main
 */
public class Recetario {

    //Instanciación tando del Frame como de todos los posibles paneles
    static PrincipalJFrame ventana= new PrincipalJFrame();

    static Ingrediente pIngrediente = new Ingrediente("Imagenes/Ingredientes.jpg");
    static MenuEleccion pMenuEleccion = new MenuEleccion("Imagenes/MenuRecetario.jpg");
    static UsuarioLogin pUsuarioLogin = new UsuarioLogin("Imagenes/Usuario.png");
    static UsuarioRegistro pUsuarioRegistro = new UsuarioRegistro("Imagenes/Usuario.png");
    static SeleccionaRecetas pSeleccionaReceta = new SeleccionaRecetas();
    static AddReceta nuevaReceta = new AddReceta();
    static JScrollPane jSPvisor;

    static Receta elegida;
    static VisorReceta verReceta;

    /**
     * Main
     * @param args
     */
    public static void main(String[] args){
        ventana.setVisible(true);

        jSPvisor = new JScrollPane(pUsuarioLogin);
            jSPvisor.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            jSPvisor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        ventana.add(jSPvisor, BorderLayout.CENTER);  
        jSPvisor.revalidate();
        ventana.revalidate();
    }

    /**
     * Poner el panel de ingredientes
     */
    public static void setPCentralIngrediente(){
        jSPvisor.setViewportView(pIngrediente);
        jSPvisor.revalidate();

        ventana.revalidate();
    }

    /**
     * Poner el menu principal de la aplicación
     */
    public static void setPCentralMenuEleccion(){
        jSPvisor.setViewportView(pMenuEleccion);
        jSPvisor.revalidate();

        ventana.revalidate();
    }

    /**
     * Poner el login de usuario
     */
    public static void setPCentralUsuarioLogin(){
        jSPvisor.setViewportView(pUsuarioLogin);
        jSPvisor.revalidate();

        ventana.revalidate();
    }

    /**
     * Poner el registro de nuevo usuario
     */
    public static void setPCentralUsuarioRegistro(){
        jSPvisor.setViewportView(pUsuarioRegistro);
        jSPvisor.revalidate();

        ventana.revalidate();
    }

    /**
     * Poner el panel de selección de una receta
     */
    public static void setPCentralSeleccionaReceta(){
        jSPvisor.setViewportView(pSeleccionaReceta);
        jSPvisor.revalidate();

        ventana.revalidate();
    }
    /**
     * Poner el creador de recetas
     */
    public static void setPCentralNuevaReceta(){
        jSPvisor.setViewportView(nuevaReceta);
        jSPvisor.revalidate();

        ventana.revalidate();
    }

    /**
     * Mostrar la receta recibida por parámetro
     * @param receta
     */
    public static void setPCentralVerReceta(Receta receta){
        verReceta = new VisorReceta(receta);

        jSPvisor.setViewportView(verReceta);
        jSPvisor.revalidate();

        ventana.revalidate();
    }
}