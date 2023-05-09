package t8ej1;

import java.util.Scanner;
import java.util.Vector;

public class Almacén {
	
	static final String PRECIO = "precio";
	static final String REFE   = "referencia";
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		Vector<Producto> productos = new Vector<Producto>();
		productos.add(new Producto("Agua", 1.3f, 2));
		productos.add(new Producto("Pan", 0.7f, 1));
		productos.add(new Producto("Leche", 1.8f, 3));
		productos.add(new Producto("Donete", 1f, 4));
		productos.add(new Producto("Pipas", 0.8f, 5));
		productos.add(new Producto("Donete", 1.2f, 6));

		Indice indice = new Indice(productos, REFE);

		System.out.println("Productos mostrados por referencia: \n");
		indice.mostrarProductos(indice.getProductos());
		
		System.out.println("\nProductos mostrados por precio: \n");
		indice.ordenar(PRECIO);
		indice.mostrarProductos(indice.getProductos());

		System.out.println("\nVamos a añadir el producto Nesquik ...\n");
		indice.insertar(new Producto("Nesquik", 1.7f, 0));
		indice.mostrarProductos(indice.getProductos());
		
		System.out.print("\n\nintroduce el nombre de uno de los productos: ");
		String nombre = kb.nextLine();
		kb.close();
		
		Vector<Producto> encontrados = indice.buscar(nombre);
		if(encontrados == null)
			System.out.println("No se han encontrado productos con ese nombre");
		
		else {
			System.out.println("Se van a mostrar todos los productos encontrados: \n");
			indice.mostrarProductos(encontrados);
		}
	}
}
