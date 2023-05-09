package Tema_4;
import java.util.Scanner;

//Menú para calcular elegir de triángulo, cuadrilátero, circunferencia
//Opción 4 Salir

//Una vez elegido, mostrar submenú donde elegit perímetro, área 
//Opción 4 volver al menú

public class T4EJ14 {

    static Scanner kb = new Scanner(System.in);

    public static void main(String[] args){
	int tipo=0, figura=0;

	do{		
		limpiar_pantalla();

		figura=menu_figura();
		if (figura==4) break;
	
		limpiar_pantalla();
	
		tipo=menu_tipo();
	}while(tipo==3);

	switch(tipo){
		case 1: mostrar_perimetro(figura);
		break;
		
		case 2: mostrar_area(figura);
		}
	}
    
    
    static int menu_figura(){
        int figura=0;
        
        System.out.println("===================================");
        System.out.println("|        Elige una opción         |");
        System.out.println("|=================================|");
        System.out.println("| 1. Triángulo                    |");
        System.out.println("| 2. Cuadrilátero                 |");
        System.out.println("| 3. Circunferencia               |");
        System.out.println("| 4. Salir                        |");
        System.out.println("===================================");
        System.out.print("\nOpción: ");

        do{
            figura = kb.nextInt();
            if(figura<1 || figura>4) System.out.print("ERROR\nIntroduce un valor válido: ");
		}while(figura<1 || figura>4);
		
		return figura;
	}
	
	static int menu_tipo(){
	int tipo=0;

    System.out.println("===================================");
    System.out.println("|        Elige una opción         |");
    System.out.println("|=================================|");
    System.out.println("| 1. Perímetro                    |");
    System.out.println("| 2. Área comprendida             |");
    System.out.println("| 3. Volver                       |");
    System.out.println("===================================");
    System.out.print("\nOpción: ");
    
    do{
        tipo = kb.nextInt();
        if(tipo<1 || tipo>3) System.out.print("ERROR\nIntroduce un valor válido: ");
    }while(tipo<1 || tipo>3);
            
    return tipo;
	}
	
	static void mostrar_perimetro(int figura){
		switch(figura){
        case 1:         //TRIANGULO
            System.out.println("\nPerímetro del triángulo.");
            System.out.print("Introduce la medida del primer lado: ");
            float l1=kb.nextFloat();
            System.out.print("Introduce la medida del segundo lado: ");
            float l2=kb.nextFloat();
            System.out.print("Introduce la medida del tercer lado: ");
            float l3=kb.nextFloat();
            kb.close();

            System.out.println("El perímetro del triángulo de l1="+l1+" , l2="+l2+" y l3="+l3+" es "+(l1+l2+l3));
            break;

		case 2:         //CUADRILATERO
			System.out.println("\nPerímetro de un cuadrilátero");
            System.out.print("Introduce la medida del primer lado: ");
            float p1=kb.nextFloat();
            System.out.print("Introduce la medida del segundo lado: ");
            float p2=kb.nextFloat();
            System.out.print("Introduce la medida del tercer lado: ");
            float p3=kb.nextFloat();
            System.out.print("Introduce la medida del cuarto lado: ");
            float p4=kb.nextFloat();
            kb.close();

            System.out.println("El perímetro del cuadrado de l1="+p1+" ,l2="+p2+" , l3="+p3+" y l4="+p4+" es "+(p1+p2+p3+p4));
            break;                    

        case 3:         //CIRCUNFERENCIA
			System.out.println("\nPerímetro de una circunferencia");
            System.out.print("Introduce el radio del círculo: ");
            float r=kb.nextFloat();
            kb.close();

            System.out.println("El perímetro del circulo de radio "+r+" es: "+ 2*Math.PI*r);
        }
	}

	static void mostrar_area(int figura){
		switch(figura){
		case 1:
			System.out.println("\nÁrea de un triángulo.");
			System.out.print("Introduce la base: ");
			float base=kb.nextFloat();
			System.out.print("Introduce la altura: ");
			float altura=kb.nextFloat();
			kb.close();

			System.out.println("El área del triángulo de base "+base+" y altura "+altura+" es: "+ base*altura/2);
			break;
		case 2:
			System.out.println("\nÁrea de un cuadrilátero.");
			System.out.print("Introduce la base: ");
			float b=kb.nextFloat();
			System.out.print("Introduce la altura: ");
			float h=kb.nextFloat();
			kb.close();

			System.out.println("El área del cuadrilátero de base "+b+" y altura "+h+" es: "+ b*h);
			break;
		case 3:
			System.out.println("\nÁrea de una circunferencia.");
			System.out.print("Introduce el radio de la circunferencia: ");
			float radio=kb.nextFloat();
			kb.close();

			System.out.println("El area de la circunferencia de radio "+radio+" es: "+ Math.PI*Math.pow(radio, 2));
        }
	}

	static void limpiar_pantalla(){
		for(int x=0; x<25; x++)
			System.out.println();
	}
}
