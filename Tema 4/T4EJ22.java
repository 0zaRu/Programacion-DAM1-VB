package Tema_4;
import java.util.Scanner;

public class T4EJ22 {
	
	static Scanner kb=new Scanner(System.in);

	public static void main (String[] args) {
		
		Circunferencia circu = new Circunferencia();

		System.out.print("Introduce el radio para saber la longuitud y área de su circunferencia: ");
		float radio = rellenar();
		kb.close();
		
		valores_circulo(radio, circu);
		System.out.println("La longuitud de la circunferencia de radio "+radio+" es: "+circu.longuitud);
		System.out.println("El area de la circunferencia de radio "+radio+" es: "+circu.area);
	}

	static void valores_circulo(float r, Circunferencia circu){
		circu.longuitud=2*Math.PI*r;
		circu.area=Math.pow(r, 2)*Math.PI;
	}

	static float rellenar(){
        float v;

		do{
            v=kb.nextInt();
            if(v<0) System.out.print("ERROR || Prueba un valor real positivo: ");
        }while(v<0);

        return v;
    }
}

class Circunferencia{
	double longuitud;
	double area;
}