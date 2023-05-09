import java.util.Scanner;
import java.util.Vector;
import java.util.Random;

/*Juego de adivinanzas de palabras.
 Se mostrará un guion por cada letra a adivinar de una palabra preestablecida al azar.
 La persona tiene 10 intentos para adivinar una letra, si lo hace se reemplaza el guion por esta.
 Si acierta todas las letras se le felicita.
 Si usa los 10 intentos, puede meter una palabra y si acierta se felicita, si no se lamentará e informará de la palabra. */
public class T5EJ28
{
	static final int INTENTOS=10;
	static final int LPANTALLA=20;
	static Scanner kb=new Scanner(System.in);
	
	public static void main(String[] args)
	{
		Random rand = new Random();
		
		//Declaro el array de palabras aleatorias y guardo en pAleatorias la palabra alegida al azar.
		String[] palabras= {"Buñuelo", "Alberto", "Programación", "Manzana", "Huevo", "Ejercicio", "String", "Eclipse", "Aleatoio", "Zelda", "Mario", "Hollow", "Link"};
		String pAleatoria = palabras[rand.nextInt(13)];
		
		//Declaro los objetos que voy a necesitar usar
		int intentos = INTENTOS;
		boolean adivinada=false;
		Vector <String> lAcertadas = new Vector<String>();
		
		//Mensaje de entrada, cualquier tecla para continuar
		System.out.print("Vamos a empezar a jugar, tendrás 10 intentos para intentar adivinar las letras de la palabra que saldrá aleatoriamente ...");
		kb.nextLine();
		
		//Bucle que utilizo para que funcione la parte principal del programa
		while(!adivinada && intentos>0) {
		
			//mostrar guión además devuelve si se ha adivinado la palabra o no con la última interacción del usuario
			adivinada = mostrar_guion(pAleatoria, lAcertadas);
			
			//se pide al usuario que introduzca una letra, mostrando los intentos que le quedan, solo se ejecuta si no se ha adivinado todavía la palabra
			if(!adivinada) interaccion(intentos--, pAleatoria, lAcertadas);
			
		}
	
		//Una vez acabo en bucle, si no se ha adivinado la palabra se pide que se introduzca una y se compara si es igual o no
		if(!adivinada) System.out.print("\n\nTe has quedado sin intentos, por favor introduce la palabra que creas que es: ");
		String uIntento = kb.nextLine();
		kb.close();
		
		if(uIntento.equalsIgnoreCase(pAleatoria)) adivinada=true;
		
		//Se muestra victoria o derrota en función de si se ha adivinado o no
		if(adivinada) System.out.println("\n\nENHORABUENA !!\nhas acertado la palabra.");
		else System.out.println("\n\nLO SIENTO MUCHO !!\n No has podido acertar la palabra, la resupeta correcta era "+pAleatoria);
	}
	
	
	
	/**Método que recibe la palabra a comparar y un vector con letras que compara, devuelve booleano true si todas las letras están false en caso contrario*/
	static boolean mostrar_guion(String palabra, Vector<String> letras) {
		boolean adivinada=true;
		
		for(int x=0; x<LPANTALLA; x++) {
			System.out.println("\t");
			
			if(x==LPANTALLA/2) 
				for(int z=0; z<palabra.length(); z++) 
					if(letras.contains(Character.toString(Character.toUpperCase(palabra.charAt(z))))) System.out.print(palabra.charAt(z)+" ");
					else {
						System.out.print("- ");
						adivinada=false;
					}
		}
		return adivinada;
	}

	/**Método void que recibe un entero(intentos), la palabra aleatoria para almacenar la letra introucida por el usuario en el vector pasado como ultimo parámetro, solo si si la letra existe en la palabra*/
	static void interaccion(int intentos, String pAleatoria, Vector<String> lAcertadas) {
		char letra;
		
		System.out.print("Te quedan "+intentos+" intentos\nIntroduce una letra: ");
		letra = kb.nextLine().charAt(0);
	
		if(pAleatoria.toUpperCase().indexOf(Character.toUpperCase(letra))!=-1) lAcertadas.add(Character.toString(Character.toUpperCase(letra)));
	}
	
}