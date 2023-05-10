package t8ej4;

import java.util.Scanner;
import java.util.Random;
import java.util.Vector;

public class Principal {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Vector<Llamada> registro = new Vector<Llamada>();
		Random genAleat = new Random();
		
		boolean salir = false;
		int tipo, franja;
		String num_origen, num_destino;
		long duracion;
		
		do {
			tipo = genAleat.nextInt(2);
			//num_origen = Long.toString(genAleat.nextLong(999999999-600000000)+6000000000l);
			num_origen = Long.toString(genAleat.nextInt(999999999-600000000)+6000000000l);
			//num_destino = Long.toString(genAleat.nextLong(999999999-600000000)+6000000000l);
			num_destino = Long.toString(genAleat.nextInt(999999999-600000000)+6000000000l);
			//duracion = genAleat.nextLong(2399)+1;
			duracion = genAleat.nextInt(2399)+1;
			
			if(tipo == 0) //Llamada local
			{
				registro.add(new LlamadaLocal(num_origen, num_destino, duracion));
			}
			
			else		  //Llamada provincial
			{
				franja = genAleat.nextInt(3)+1;
				registro.add(new LlamadaProvincial(num_origen, num_destino, duracion, franja));
			}
			
			System.out.println(registro.lastElement());
			System.out.println("El coste total registrado con todas las llamdas es de: "+ getCosteTotal(registro)+" cent. ("+(float)getCosteTotal(registro)/100+" euros)");
			
			System.out.print("\nEnter para seguir, cualquier caracter para salir ... ");
			if(!kb.nextLine().isEmpty()) salir = true;
			
			System.out.println();
			
		}while(!salir);
		kb.close();
		
		System.out.println("\nEl coste total que ha sido registrado durante la ejecucion es: "+ getCosteTotal(registro)+" cent. ("+(float)getCosteTotal(registro)/100+" euros)");
	}
	
	public static long getCosteTotal(Vector<Llamada> registro) {
		long sumatorio = 0;
		
		for (int i = 0; i < registro.size(); i++)
			sumatorio += registro.elementAt(i).getCoste();
		
		return sumatorio;
	}
}
