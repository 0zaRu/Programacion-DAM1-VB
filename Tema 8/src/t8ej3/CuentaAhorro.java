package t8ej3;

public class CuentaAhorro extends CuentaCorriente{
	private float interes;
	
	CuentaAhorro(String nombre, String apellidos, String nCuenta, int edad, double saldo, float interes){
		super(nombre, apellidos, nCuenta, edad, saldo);
		this.interes = interes;
	}
	
	CuentaAhorro(String nombre, String apellidos, String nCuenta, int edad, float interes){
		super(nombre, apellidos, nCuenta, edad);
		this.interes = interes;
	}
	
	CuentaAhorro(String nombre, String apellidos, String nCuenta, int edad){
		super(nombre, apellidos, nCuenta, edad);
		this.interes = 2.5f;
	}
	
	
	public void calculaInteres() {
		saldo *= interes/10;
	}
	
	
	public float getInteres() {
		return interes;
	}
}
