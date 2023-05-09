package t8ej1;

import java.util.Vector;

/** Clase indice, contiene un vector de productos y los ordena segun el parámetro criterio */
public class Indice {
	private Vector<Producto> productos = new Vector<Producto>();
	private String criterio;

	/** Constructor con parámetro obligatorios para ordenar un vector pasado segun un criterio pasado */
	Indice(Vector<Producto> productos, String criterio){
		this.productos = productos;
		this.productos = ordenar(criterio);
	}
	
	
	/** Método ordenar que modifica el orden del vector del objeto que lo llame en función del criterio pasado por parámetro */
	public Vector<Producto> ordenar (String criterio) {
		this.criterio = criterio;
		
		if (this.criterio != "precio" && this.criterio != "referencia") {
			System.err.println("No se ha establecido un criterio de ordenación válido. Se ha ordenado por referencia (la otra opción era precio).");
			this.criterio = "referencia";
		}
		
		Vector<Producto> ordena = new Vector<Producto>();
		int indiceMenor;

		do{
			indiceMenor = 0;

			for(int j=0; j < productos.size(); j++) {
				if(orderBy(productos.elementAt(j), criterio) < orderBy(productos.elementAt(indiceMenor), criterio))
					indiceMenor = j;
			}

			ordena.add(productos.remove(indiceMenor));
		
		}while(productos.size()!=0);
		
		productos = ordena;
		return this.getProductos();
	}

	/** Método de apoyo para ordena, se utiliza para no duplicar código a la hora de ordenar por criterio */
	private float orderBy (Producto p, String orden) {
		if(orden == "precio")
			return p.getPrecio();
		
		return p.getReferencia();
	}
	
	/** Método que recibe u producto, lo añade al vector del objeto y lo reordena por el criterio establecido */
	public void insertar (Producto newPro) {
		productos.add(newPro);
		ordenar(this.criterio);
	}
	
	/** Método que recibe un String y devuelve un vector con todos los objetos que tengan el nombre pasado */
	public Vector<Producto> buscar(String nombre){
		Vector<Producto> pedidos = new Vector<Producto>();
		
		for(int i=0; i<productos.size(); i++)
			if(productos.elementAt(i).getNombre().equalsIgnoreCase(nombre))
				pedidos.add(productos.elementAt(i));
		
		if(pedidos.size() == 0) 
			pedidos = null;
		
		return pedidos;
	}
	
	/** Método de apoyo para mostrar los productos del vector de un objeto de indice */
	public void mostrarProductos(Vector<Producto> productos){
		for(int i=0; i<productos.size(); i++)
		System.out.println((i+1)+". "+productos.elementAt(i).getNombre()+" vale "
		+productos.elementAt(i).getPrecio()+" euros con la referencia "
		+productos.elementAt(i).getReferencia());
	}
	
	/** Devuelve el vector de productos del indice */
	public Vector<Producto> getProductos(){
		return productos;
	}
	
	/** devuelve el criterio de ordenación de este indice */
	public String getCriterio() {
		return criterio;
	}
}