package t8ej3;

public class CuentaCorriente {
	private String nombre;
	private String apellidos; 
	private String nCuenta;
	private int edad;
	protected double saldo;
	
	CuentaCorriente(String nombre, String apellidos, String nCuenta, int edad, double saldo){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nCuenta = nCuenta;
		this.edad = edad;
		this.saldo = saldo;
	}
	
	CuentaCorriente(String nombre, String apellidos, String nCuenta, int edad){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nCuenta = nCuenta;
		this.edad = edad;
		this.saldo = 15.3f;
	}
	
	
	public void ingresar(float ingreso) {
		saldo += ingreso;
	}
	
	public void reintegro(float reintegro) {
		saldo -= reintegro;
	}
	
	public void imprimirCuenta() {
		System.out.println("La cuenta \""+this.nCuenta+"\" tiene un saldo de: "+this.saldo+" euros.");
	}
	
	static boolean comparaCuentas(CuentaCorriente n1, CuentaCorriente n2) {
		if(n1.nCuenta == n2.nCuenta) return true;
		else return false;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public String getNCuenta() {
		return nCuenta;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public double getSaldo() {
		return saldo;
	}
}
