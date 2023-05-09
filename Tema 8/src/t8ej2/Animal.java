package t8ej2;

public class Animal {
	
	private int edad;
	private float peso;
	
	public void comer() {
		System.out.print("Estoy comiendo");
	}
	
	public int getEdad() {
		return edad;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
}
