package t8ej3;

public class Principal {
	public static void main(String[] args) {
		CuentaCorriente persona1 = new CuentaCorriente("Alberto", "Rodríguez Pérez", "ES32 1234 5678", 20, 380.97);
		persona1.getNCuenta();
		
		CuentaCorriente persona2 = new CuentaCorriente("Achraf", "Ape1 Ape2", "ES32 8765 4321", 22);
		persona2.getApellidos();
		
		CuentaAhorro persona3 = new CuentaAhorro("Alberto", "Rodríguez Pérez", "ES32 1234 56778", 200);
		
		//No tiene sentido este if el se porque sé que son diferentes pero por probar el método
		if(CuentaCorriente.comparaCuentas(persona1, persona2))
			System.out.println("Las cuentas son la misma");
		else
			System.out.println("Las cuentas son diferentes");
		
		
		if(CuentaCorriente.comparaCuentas(persona1, persona3))
			System.out.println("Las cuentas son la misma");
		else
			System.out.println("Las cuentas son diferentes");
	}
}
