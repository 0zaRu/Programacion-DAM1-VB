package t8ej5_ej7;

public abstract class Codigo implements Encriptable {
	private long codigo;

	Codigo(long codigo){
		this.codigo = codigo;
	}
	
	protected void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public long getCodigo() {
		return codigo;
	}
}
