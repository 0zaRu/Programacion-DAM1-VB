package t8ej5_ej7;

public class C_XOR extends Codigo{
	C_XOR(long codigo) {
		super(codigo);
	}
	
	public long encriptar(int clave) {
		this.setCodigo(this.getCodigo()^clave);
		return this.getCodigo();
	}
	
	public long desencriptar(int clave) {
		return this.encriptar(clave);
	}
}
