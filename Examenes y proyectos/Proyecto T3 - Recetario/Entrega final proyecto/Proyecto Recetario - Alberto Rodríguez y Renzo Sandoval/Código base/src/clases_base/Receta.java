package clases_base;

/**
 * Clase para almacenar los objetos de la receta
 */
public class Receta {
    //Todos los posibles atributos de una receta
    private int ID;
    private String imagenPrincipal;
    private String nombre;
    private String duracion;
    private String dificultad;
    private String descripcion;
    private String tags;
    private String ingredientes;
    private String pasos;
    /**
     * Constructor sin parámetros
     */
    public Receta(){
        this.imagenPrincipal = "";
        this.nombre = "";
        this.duracion = "";
        this.dificultad = "";
        this.descripcion = "";
        this.tags = "";
        this.ingredientes = "";
        this.pasos = "";
    }
    
    /**
     * 
     * @param imagenPrincipal
     * @param nombre
     * @param duracion
     * @param dificultad
     * @param descripcion
     * @param tags
     * @param ingredientes
     * @param pasos
     * 
     * Constructor con todos los parametros menos la ID
     */
    public Receta(String imagenPrincipal, String nombre, String duracion, String dificultad, String descripcion, String tags, String ingredientes, String pasos){
        this.imagenPrincipal = imagenPrincipal;
        this.nombre = nombre;
        this.duracion = duracion;
        this.dificultad = dificultad;
        this.descripcion = descripcion;
        this.tags = tags;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
    }

    /**
     * 
     * @param ID
     * @param imagenPrincipal
     * @param nombre
     * @param duracion
     * @param dificultad
     * @param descripcion
     * @param tags
     * @param ingredientes
     * @param pasos
     * 
     * COnstructor con la ID para cuando se rescata una receta de la base de datos
     */
    public Receta(int ID, String imagenPrincipal, String nombre, String duracion, String dificultad, String descripcion, String tags, String ingredientes, String pasos){
        this.ID = ID;
        this.imagenPrincipal = imagenPrincipal;
        this.nombre = nombre;
        this.duracion = duracion;
        this.dificultad = dificultad;
        this.descripcion = descripcion;
        this.tags = tags;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
    }
    /**
     * 
     * @return
     */
    public int getID() {
        return ID;
    }
    /**
     * 
     * @return
     */
    public String getImagenPrincipal() {
        return imagenPrincipal;
    }
    /**
     * 
     * @param imagenPrincipal
     */
    public void setImagenPrincipal(String imagenPrincipal) {
        this.imagenPrincipal = imagenPrincipal;
    }
    /**
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return
     */
    public String getDuracion() {
        return duracion;
    }
    /**
     * 
     * @param duracion
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    /**
     * 
     * @return
     */
    public String getDificultad() {
        return dificultad;
    }
    /**
     * 
     * @param dificultad
     */
    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
    /**
     * 
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * 
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * 
     * @return
     */
    public String getTags() {
        return tags;
    }
    /**
     * 
     * @param tags
     */
    public void setTags(String tags) {
        this.tags = tags;
    }
    /**
     * 
     * @return
     */
    public String getIngredientes() {
        return ingredientes;
    }
    /**
     * 
     * @param ingredientes
     */
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    /**
     * 
     * @return
     */
    public String getPasos() {
        return pasos;
    }
    /**
     * 
     * @param pasos
     */
    public void setPasos(String pasos) {
        this.pasos = pasos;
    }
}