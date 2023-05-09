package t9ej4;

public class CuentaCorriente {

	private Vecino titular;
	private String nCuenta;
	protected double saldo;
	
	CuentaCorriente(Vecino titular, String nCuenta, double saldo){
		this.titular = titular;
		this.nCuenta = nCuenta;
		this.saldo = saldo;
	}
	
	CuentaCorriente(Vecino titular, String nCuenta){
		this.titular = titular;
		this.nCuenta = nCuenta;
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
	
	public String getNCuenta() {
		return nCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public Vecino getTitular() {
		return titular;
	}
}
