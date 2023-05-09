package Tema_4;
import java.util.Scanner;

public class T4EJ26 {
	
	static final int LINEAS=30;
	static final int SALIR=6;
	
	static Scanner kb=new Scanner(System.in);
	
	public static void main (String[] args) {
		kb.useDelimiter(System.getProperty("line.separator"));
		int opcion;
		
		do{
			
			opcion = menu();
			limpiar();
			
			switch(opcion){
			
				case 1:
					System.out.print("Introduce un valor entero: ");
					int n1=kb.nextInt();
					System.out.print("Introduce otro valor entero: ");
					int n2=kb.nextInt();
					
					System.out.println("El resultado es: "+n1+" + "+n2+" = "+suma(n1, n2));
					break;
				
				case 2:
					System.out.print("Introduce un valor entero: ");
					int v1=kb.nextInt();
					System.out.print("Introduce otro valor entero: ");
					int v2=kb.nextInt();
					System.out.print("Introduce otro valor entero: ");
					int v3=kb.nextInt();
					
					System.out.println("El resultado es: "+v1+" + "+v2+" + "+v3+" = "+suma(v1, v2, v3));
					break;
				
				case 3:
					System.out.print("Introduce un valor entero: ");
					float m1=kb.nextFloat();
					System.out.print("Introduce otro valor entero: ");
					float m2=kb.nextFloat();
					System.out.print("Introduce otro valor entero: ");
					float m3=kb.nextFloat();

					System.out.println("El resultado es: "+m1+" + "+m2+" + "+m3+" = "+suma(m1, m2, m3));
					break;

				case 4:
					System.out.print("Introduce una cadena de caracteres: ");
					String c1=kb.next();
					System.out.print("Introduce otra cadena de caracteres: ");
					String c2=kb.next();
					
					System.out.println("La suma de las 2 cadenas es: "+suma(c1, c2));
					break;
						
				case 5:
					System.out.println("La suma de todos los valores introducidos es: "+suma());
					break;
				
				case SALIR:
					break;
					
				default:
					System.out.println("La opción seleccionada no existe, por favor pruebe con una del menú ...");
					kb.next();
				}
				
			continuar();
			limpiar();
			
		}while(opcion != SALIR);
			
		kb.close();
	}
	
	static int menu(){
		System.out.println("\tELIJA UNA OPCION");
		System.out.println("\t----------------\n");
		System.out.println("1. Recibe 2 enteros y proporciona la suma");
		System.out.println("2. Recibe 3 enteros y proporciona la suma");
		System.out.println("3. Recibe 3 reales y proporciona la suma");
		System.out.println("4. Recibe 2 cadenas y devuelve su concatenación");
		System.out.println("5. Solicita sucesivos enteros hasta 0 y devuelve la suma");
		System.out.println(SALIR+". Salir.");
		System.out.print  ("\n\t\tElija una opcion: ");
		return kb.nextInt();
	}
	
	static int suma(int n1, int n2){
		return n1+n2;
	}
	
	static int suma(int n1, int n2, int n3){
		return n1+n2+n3;
	}
	
	static float suma(float n1, float n2, float n3){
		return n1+n2+n3;
	}
	
	static String suma(String c1, String c2){
		return c1+c2;
	}
	
	static int suma(){
		int s=0, n;
		do{
			System.out.print("Introduce un valor entero a sumar (0 para salir): ");
			s+= n=kb.nextInt();			
		}while(n!=0);
		
		return s;
	}
	
	static void limpiar(){
		for(int x=0; x<=LINEAS; x++)
			System.out.println();
	}

	static void continuar(){
		System.out.print("Pulsa enter para continuar ...");
		kb.next();
	}
}
