package t8ej4;

public class LlamadaLocal extends Llamada{
	static final int COSTE_MIN = 15;
	
	private final long coste;
	
	LlamadaLocal(String num_origen, String num_destino, long duracion){
		super(num_origen, num_destino, duracion);
		coste = getCoste();
	}
	
	public long getCoste() {
		return this.duracion/60*COSTE_MIN;
	}
	
	public String toString() {
		String linea = super.toString();
		return linea += "\tCoste: "+this.coste+" cent. (coste local)";
	}
}