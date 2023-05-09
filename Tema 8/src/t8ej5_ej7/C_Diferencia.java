package t8ej5_ej7;

public class C_Diferencia extends Codigo{
	C_Diferencia(long codigo) {
		super(codigo);
	}
	
	public long encriptar(int clave) {
		this.setCodigo(this.getCodigo()-clave);
		return this.getCodigo();
	}
	
	public long desencriptar(int clave) {
		return this.encriptar(clave*(-1));
	}
}