import java.util.Random;

//Voy a hacer que tanto el float como los n decimales.
public class T5EJ14 {
	public static void main(String[] args) {
		Random aleatorio= new Random();
		
		float valor     = aleatorio.nextFloat()*aleatorio.nextInt(100);
		String cadenado = Float.toString(valor);
		
		int pos_punto=0;

		for(int x=0; x<cadenado.length(); x++)
			if(cadenado.charAt(x)=='.'){
				pos_punto=x+1;
				break;
			}

		int decimales = aleatorio.nextInt(cadenado.length()-pos_punto-1)+1;
	
		System.out.print("Se ha generado el "+valor+" y se va a imprimir los "+decimales+" primeros decimales por separado: ");
		for(int x=pos_punto; x<pos_punto+decimales; x++)
			System.out.print(cadenado.charAt(x));
	}
}