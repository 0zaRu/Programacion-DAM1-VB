package t9ej4;

public class CuentaAhorro extends CuentaCorriente{
	private float interes;
	
	CuentaAhorro(Vecino titular, String nCuenta, double saldo, float interes){
		super(titular, nCuenta, saldo);
		this.interes = interes;
	}
	
	CuentaAhorro(Vecino titular, String nCuenta, float interes){
		super(titular, nCuenta);
		this.interes = interes;
	}
	
	CuentaAhorro(Vecino titular, String nCuenta){
		super(titular, nCuenta);
		this.interes = 2.5f;
	}
	
	
	public void calculaInteres() {
		saldo *= interes/10;
	}
	
	
	public float getInteres() {
		return interes;
	}
}
