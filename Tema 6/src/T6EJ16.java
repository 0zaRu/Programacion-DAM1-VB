import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;


public class T6EJ16 {

	static Scanner kb = new Scanner(System.in);
	
	static final int LINEAS = 30;
	
	static final byte AÑADE = 1;
	static final byte BUSCATLF = 2;
	static final byte CANTALM = 3;
	static final byte LEEENTRD = 4;
	static final byte LEETODO = 5;
	static final byte ACTUALIZA = 6;
	static final byte BORRA = 7;
	static final byte SALIR = 8;
		
	public static void main(String[] args) {
		kb.useDelimiter(System.getProperty("line.separator"));
		
		if(args.length != 1) {
			System.err.println("ERROR. Parámetros incorrectos.\nUso: <java T6EJ16 <ruta>");
			return;
		}

		File ruta = new File(args[0]);
		
		if(!ruta.isFile()) {
			System.err.println("ERROR. La ruta especificada no es un fichero.");
			return;
		}
		
		boolean salir = false;
		
		while(!salir) {
			switch(mostrar_menu()) {
			case AÑADE:
				
				if(agregar_entrada(ruta))
					System.out.println("\n\nSe ha agregado una entrada correctamente ...");
				else 
					System.out.println("\n\nLa entrada no se ha podido agregar ...");
				
				break;
			
			case BUSCATLF:
				
				if(!buscar_tlf(ruta)) System.out.println("\n\nHa ocurrido un error mientras se buscaba el teléfono ...");
				
				break;
				
			case CANTALM:
				
				if(!cant_registros(ruta)) System.out.println("\n\nHa ocurrido un error mientras se contaba cuantos alumnos hay registrados ...");
				
				break;
				
			case LEEENTRD:
				
				if(!leer_entrada(ruta)) System.out.println("\n\nHa habido un problema durante la lectura del alumno ...");
				
				break;
				
			case ACTUALIZA:
				
				if(actualizar_registro(ruta)) System.out.println("\n\nEl registro se ha actualizado con exito ...");
				else System.out.println("\n\nHa habido un problema durante la actualización del registro ...");
				
				break;
				
			case BORRA:
				
/*				if(borra_registro(ruta)) System.out.println("\n\nEl registro se ha borrado con exito ...");
				else System.out.println("\n\nHa ");
				break;
*/				
			case SALIR:
				salir = true;
				break;
			
			default:
				System.out.println("Se ha elegido una opción no válida ...");
			}
			kb.nextLine();
			limpiar_pantalla();
		}
	}
	
	static void limpiar_pantalla(){
		for (int i = 0; i < LINEAS; i++) 
			System.out.println();
	}
	
	static byte mostrar_menu() {
		System.out.println("ELIGE UNA OPCIÓN");
		System.out.println("================");
		System.out.println();
		System.out.println("\t"+AÑADE+". Añadir un alumno.");
		System.out.println("\t"+BUSCATLF+". Busca el teléfono del usuario especificado.");
		System.out.println("\t"+CANTALM+". Consulta la cantidad de alumnos que hay.");
		System.out.println("\t"+LEEENTRD+". Lee la entrada específica que quieras.");
		System.out.println("\t"+LEETODO+". Lee todas las entradas.");
		System.out.println("\t"+ACTUALIZA+". Actualiza una entrada de un alumno.");
		System.out.println("\t"+BORRA+". Borra un alumno de la agenda.");
		System.out.println("\t"+SALIR+". Salir.");
		System.out.print("\n\n\tOpción: ");
		Byte devolver = kb.nextByte();
		kb.nextLine();
		return devolver;
	}
	
	static boolean agregar_entrada(File ruta) {
		Alumno a = new Alumno();
		boolean valido;
		
		System.out.println("\n\n\nVamos a introducir los datos del nuevo alumno.");
		
		do {
			valido = true;
		
			try {
				System.out.print("\nIntroduce el nombre del alumno: ");
				a.nombre= kb.nextLine();
				System.out.print("\nIntroduce el teléfono del alumno: ");
				a.tlf = kb.nextInt();
				System.out.println("\nIntroduce el curso del alumno: ");
				a.curso = kb.next();
				System.out.println("\nIntroduce la letra del curso: ");
				a.letra_c = kb.next().charAt(0);
			
			}catch(Exception e){
				valido = false;
			}
			
		}while(!valido);
		
		ObjectOutputStream oos = null;
		MiObjectOutputStream moos = null;
		valido = true;
		
		if(ruta.length() == 0) {
			try {
				oos = new ObjectOutputStream(new FileOutputStream(ruta));
				oos.writeObject(a);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				valido = false;
			} catch (IOException e) {
				e.printStackTrace();
				valido = false;
			
			}finally {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else {
			
			try {
				moos = new MiObjectOutputStream(new FileOutputStream(ruta, true));
				moos.writeObject(a);
		
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				valido = false;
				
			} catch (IOException e) {
				e.printStackTrace();
				valido = false;
			}finally {
				try {
					moos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(!valido) return false;
		return true;
	}	

	static boolean buscar_tlf(File ruta) {
		boolean valido = true;
		int cont = 1;
		
		System.out.println("\n\nSe van a mostrar todos los nombres de los alumnos, por favor escribe el nombre del cual quieras consultar el teléfono ...");
		kb.nextLine();
		limpiar_pantalla();
		
		ObjectInputStream ois = null;
		Alumno a = null;
		
			try {
				
				System.out.println("ALUMNOS");
				System.out.println("====================================");
				ois = new ObjectInputStream(new FileInputStream(ruta));
				
				while((a = (Alumno)ois.readObject()) != null)
					System.out.println("\t"+(cont++) +". "+a.nombre);	
				
			} catch (EOFException e) {
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				valido = false;
						
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				valido = false;
				
			} catch (IOException e) {
				e.printStackTrace();
				valido = false;
				
			}
			finally {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(!valido) return false;
			}
		
			System.out.print("\n\nIntroduce el nombre del alumno del que quieres el telefono: ");
			String nombre = kb.nextLine();
			
			try {
				ois = new ObjectInputStream(new FileInputStream(ruta));
				
				while((a = (Alumno)ois.readObject()) != null)
					if(nombre.equalsIgnoreCase(a.nombre)) {
						System.out.println("El teléfono de "+nombre+" es: "+a.tlf+".");
						break;
					}
			} catch (EOFException e) {
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				valido = false;
						
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				valido = false;
				
			} catch (IOException e) {
				e.printStackTrace();
				valido = false;
				
			}
			finally {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(!valido) return false;
			}
		return true;
	}

	static boolean cant_registros(File ruta) {
		boolean valido = true;
		int cont = 0;
		
		ObjectInputStream ois = null;
		
		try {
			
			System.out.println("ALUMNOS");
			System.out.println("====================================");
			ois = new ObjectInputStream(new FileInputStream(ruta));
			
			while((Alumno)ois.readObject() != null)
				cont++;	
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			valido = false;
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			valido = false;
			
		} catch (IOException e) {
			e.printStackTrace();
			valido = false;
			
		}
		finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(!valido) return false;
		}
		
		System.out.println("\n\nHay "+cont+" registros.");
		
		return true;
	}

	static boolean leer_entrada(File ruta) {
		
		System.out.print("introduce la posición de la agenda que deseas leer: ");
		int numero = kb.nextInt();
		
		boolean valido = true;
		boolean seguir = true;
		int cont = 1;
		
		ObjectInputStream ois = null;
		Alumno a = null;
		
		try {
			
			System.out.println("ALUMNOS");
			System.out.println("====================================");
			ois = new ObjectInputStream(new FileInputStream(ruta));
			
			while(seguir && (a = (Alumno)ois.readObject()) != null)
				if(cont++ == numero) seguir = false;
			
		} catch (EOFException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			valido = false;
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			valido = false;
			
		} catch (IOException e) {
			e.printStackTrace();
			valido = false;
			
		}
		finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(!valido) return false;
		}
		
		System.out.println("\n\nNombre: "+a.nombre);
		System.out.println("Teléfono: "+a.tlf);
		System.out.println("Clase y curso: "+a.curso+a.letra_c);
		
		return true;
	}
	
	static boolean actualizar_registro(File ruta) {
		boolean valido = true;
		boolean seguir = true;
		int cont = 1;
		
		System.out.println("\n\nSe van a mostrar todos los nombres de los alumnos, por favor escribe el nombre del cual quieras actualizar los datos ...");
		kb.nextLine();
		limpiar_pantalla();
		
		ObjectInputStream ois = null;
		Alumno a = null;
		
			try {
				
				System.out.println("ALUMNOS");
				System.out.println("====================================");
				ois = new ObjectInputStream(new FileInputStream(ruta));
				
				while((a = (Alumno)ois.readObject()) != null)
					System.out.println("\t"+(cont++) +". "+a.nombre);	
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				valido = false;
						
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				valido = false;
				
			} catch (IOException e) {
				e.printStackTrace();
				valido = false;
				
			}
			finally {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(!valido) return false;
			}
		
			System.out.print("\n\nIntroduce el nombre del alumno del que quieres el telefono: ");
			String nombre = kb.nextLine();
			//int contador = 0;
			
			try {
				ois = new ObjectInputStream(new FileInputStream(ruta));
				
				while(seguir && (a = (Alumno)ois.readObject()) != null) {
					if(nombre.equalsIgnoreCase(a.nombre)) {
						System.out.print("Introduce el nuevo teléfono: ");
						System.out.print("Introduce el nuevo curso: ");
						
						
						seguir = false;
					}
				cont++;
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				valido = false;
						
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				valido = false;
				
			} catch (IOException e) {
				e.printStackTrace();
				valido = false;
				
			}
			finally {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(!valido) return false;
			}
		return true;
	}
	
}





class Alumno implements Serializable{
	
	private static final long serialVersionUID = 20230223;
	
	String nombre;
	int tlf;
	String curso;
	char letra_c;
	
	
}