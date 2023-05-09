import java.util.Scanner;

public class T5EJ25 {
	public static void main(String[] args) {
		Scanner kb=new Scanner(System.in);
		
		System.out.print("Introduce el número del que quieres hacer la conversión: ");
		int n=kb.nextInt();
		kb.close();
		
		System.out.println("El numero "+n+" en decimal, es "+ aBinario(n)+" en binario.");
		System.out.println("El numero "+n+" en decimal, es "+ aOctal(n)  +" en octal.");
		System.out.println("El numero "+n+" en decimal, es "+ aHexa(n)   +" en hexadecimal.");
	}
	
	static String aBinario(int n) {
		if(n<=1) return Integer.toString(n);
		else    return aBinario(n/2) + n%2;
	}
	
	static String aOctal(int n) {
		if(n<=7) return Integer.toString(n);
		else    return aOctal(n/8) + n%8;
	}
	
	static String aHexa(int n) {
		if(n<=15) return cambioHexa(n);
		else    return aHexa(n/16)+cambioHexa(n%16);

	}
	
	static String cambioHexa(int n) {
	String devolver="";
	
		switch(n) {
		case 10:
			devolver+='A';
			break;
		case 11:
			devolver+='B';
			break;
		case 12:
			devolver+='C';
			break;
		case 13:
			devolver+='D';
			break;
		case 14:
			devolver+='E';
			break;
		case 15:
			devolver+='F';
			break;
		default:
			devolver+=n;
		}
	return devolver;		
	}
}
