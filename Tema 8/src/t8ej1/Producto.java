package t8ej1;

public class Producto {
	
	private String nombre;
	private float precio;
	private int referencia;
	
	/** Constructor vacio de un producto */
	Producto(){
		nombre = "";
		precio = 0f;
		referencia = 0;
	}
	
	/** Constructor de un producto que recibe todos sus datos por parámetros */
	Producto(String nombre, float precio, int referencia){
		this.nombre = nombre;
		this.precio = precio;
		this.referencia = referencia;
	}

	/** Devuelve el nombre del producto */
	public String getNombre() {
		return nombre;
	}
	
	/** Devuelve el precio del producto */
	public float getPrecio() {
		return precio;
	}
	
	/** Devuelve la referencia del producto */
	public int getReferencia() {
		return referencia;
	}
}
