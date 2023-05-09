import java.util.Scanner;

class Asig{
		
		String asignatura;
		int horas;
		String profe;
		byte nota;
		char letra;
	
}

public class EJ4 {
	
	public static void main (String[] args) {
		
		Scanner kb = new Scanner(System.in);		
		kb.useDelimiter(System.getProperty("line.separator"));
		
		Asig miAsig = new Asig();

		
		System.out.print("Introduzca el nombre de su asignatura: ");
		miAsig.asignatura = kb.next();
		
		System.out.print("\nIntroduce el numero de horas de "+ miAsig.asignatura + ": ");
		miAsig.horas = kb.nextInt();
			
		System.out.print("\nEl nombre del profesor de "+ miAsig.asignatura +" es: ");
		miAsig.profe = kb.next();
			
		System.out.print("\nLa nota obtenida en "+ miAsig.asignatura +" es: ");
		miAsig.nota = kb.nextByte();
			
		System.out.print("\nUna letra para identificar a "+ miAsig.asignatura +" es: ");
		miAsig.letra= kb.next().charAt(0);
		kb.close();

		System.out.println("\nNombre de la asignatura: "+ miAsig.asignatura +"\nNumero de horas: "+ miAsig.horas +"\nNombre del profesor: "+ miAsig.profe +
							"\nNota obtenida: "+ miAsig.nota +"\nLetra relacionada: "+ miAsig.letra);
		
	}
}

