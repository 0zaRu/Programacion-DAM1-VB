package t8ej5_ej7;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Introduce el código numerico que deseas encriptar: ");
		long codigo = kb.nextLong();
		
		System.out.print("Introduce el número con el que se va a encriptar: ");
		int clave = kb.nextInt();

		Codigo codeM = new C_Multiplica(codigo);
		Codigo codeX = new C_XOR(codigo);
		Codigo codeD = new C_Diferencia(codigo);
		
		System.out.println("Código encriptado mediante multiplicación: " + codeM.encriptar(clave));
		System.out.println("Código encriptado mediante XOR: "+ codeX.encriptar(clave));
		System.out.println("Código encriptado mediante diferencia:" + codeD.encriptar(clave));
		
		System.out.print("\n\nIntroduzca la clave inicial para desencriptarlo: ");
		clave = kb.nextInt();
		kb.close();
		
		System.out.println("Código desencriptado mediante multiplicación: "+ codeM.desencriptar(clave));
		System.out.println("Código desencriptado mediante XOR: "+ codeX.desencriptar(clave));
		System.out.println("Código desencriptado mediante diferencia:" + codeD.desencriptar(clave));
	}
}
