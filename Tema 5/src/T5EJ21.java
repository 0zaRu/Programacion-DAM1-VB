import java.util.Scanner;

//Introducir usuario y contraseña
//verificar +6 caract., 2 dígitos y usuario no puede ser parte de la contraseña

public class T5EJ21 {
	public static void main(String[] args) {
		Scanner kb=new Scanner(System.in);
		
		System.out.print("Introduce tu nombre de usuario: ");
		String user = kb.nextLine();
				
		boolean valido;
		do {
			valido=true;
			
			System.out.print("\nIntroduce tu contraseña: ");
			String pass = kb.nextLine();
			
			//Comprobamos que es mayor a 6 caracteres
			if(pass.length()<6) {
				System.out.println("Contraseña no válida, debe tener almenos 6 caracteres.");
				valido=false;
				continue;
			}
			
			//Comprobamos que el usuario no está incluido en la contraseña, aunque tenga mayus o minus diferentes
			if((pass.toUpperCase()).indexOf(user.toUpperCase())==0) {
				System.out.println("Contraseña no válida, el usuario no debe estar incluido.");
				valido=false;
				continue;
			}
			
			//Comprobamos que almenos 2 son dígitos
			for(int x=0, cont=0; x<pass.length(); x++) {
				
				if(pass.charAt(x)>='0' && pass.charAt(x)<='9') ++cont;
				if(x == pass.length()-1 && cont<2) {
					System.out.println("Contraseña no válida, debe contener almenos 2 dígitos");
					valido=false;
				}
			}
			
		}while(!valido);
		kb.close();
		
		System.out.println("Usuario y contraseña válidos.");
	}
}
