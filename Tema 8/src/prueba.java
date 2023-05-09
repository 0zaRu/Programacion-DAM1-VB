import java.util.Scanner;

public class prueba {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Notas progra = new Notas(9.1f);
		
//		Si descomentas la siguiente línea, comprobarás que no está permitido pues son variables públicas
//		System.out.println("Nota de progra: " + progra.nota +". ¿Está aprobado?: "+ progra.aprobado);

		System.out.println("Nota de progra: " + progra.getNota() +". ¿Está aprobado?: "+ progra.getAprobado());
		System.out.print("\n\nVamos a reemplazar la nota y ver si se cambia a la vez el boleano aprobado, introduce una nota suspensa: ");
		progra.setNota(kb.nextFloat());
		kb.close();
		
		System.out.println("\n\nNota de progra: " + progra.getNota() +". ¿Está aprobado?: "+ progra.getAprobado());		
	}
}


class Notas {
	private float nota;
	private boolean aprobado;
	
	/**Método constructor, recibe una nota float y debine el aprobado en función*/
	Notas(float n){
		nota = n;
		
		if(n >= 5) 
			aprobado = true;
		
		else
			aprobado = false;
		
	}
	
	/**Muestra la nota, pues es privada*/
	public float getNota() {
		return nota;
	}
	
	/**Edita la nota y con ello el boolean aprobado, pues son privados para el main*/
	public void setNota(float n) {
		if((nota = n) >= 5)
			aprobado = true;
		
		else
			aprobado = false;
	}
	
	/**Muestras si está aprobado o no*/
	public boolean getAprobado() {
		return aprobado;
	}

	//No hay setAprobado para eliminar la opción de generar inconsistencias por parte de un programador que modifique el lugar desde el cual se invoca esta clase
	
}