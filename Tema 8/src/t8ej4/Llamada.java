package t8ej4;

public abstract class Llamada {
	private final String num_origen;
	private final String num_destino;
	protected long duracion;
	
	Llamada (String num_origen, String num_destino, long duracion){
		this.num_origen = num_origen;
		this.num_destino = num_destino;
		this.duracion = duracion;
	}

	
	public String getNum_origen() {
		return num_origen;
	}
	
	public String getNum_destino() {
		return num_destino;
	}
	
	public long getDuracion() {
		return duracion;
	}
	
	public abstract long getCoste();
	
	public String toString() {
		return "Llamada realizada:\t Origen: "+this.num_origen+"\tDestino: "+this.num_destino+"\tDuracion: "+this.duracion+" s\t";
	}
}