package t8ej5_ej7;

public class C_Multiplica extends Codigo{
	C_Multiplica(long codigo) {
		super(codigo);
	}
	
	public long encriptar(int clave) {
		this.setCodigo(this.getCodigo()*clave);
		return this.getCodigo();
	}
	
	public long desencriptar(int clave) {
		this.setCodigo(this.getCodigo()/clave);
		return this.getCodigo();
	}
	
	//Como funciona con enteros, no puedo reutilizar "encriptar" en "desencriptar"
	//Se podría haber hecho de ser doubles enviando 1/clave a "encriptar"
}
