package t8ej4;

public class LlamadaProvincial extends Llamada{
	static final int COSTE_F1 = 20;
	static final int COSTE_F2 = 25;
	static final int COSTE_F3 = 30;
	
	private final long coste;
	private final int franja;
	
	LlamadaProvincial(String num_origen, String num_destino, long duracion, int franja){
		super(num_origen, num_destino, duracion);
		
		if(franja < 1 || franja > 3) franja = 3;
		this.franja = franja;
		
		this.coste = getCoste();
	}
	
	public long getCoste() {
		long coste;
		
		switch(this.franja) {
		case 1:
			coste = duracion/60*COSTE_F1;
			break;
			
		case 2:
			coste = duracion/60*COSTE_F2;
			break;
			
		case 3:
			coste = duracion/60*COSTE_F3;
			break;
			
		default:
			System.out.println("Franja erronea, se establece la franja 3 (la más cara)");
			coste = duracion/60*COSTE_F3;
			
		}
		return coste;
	}
	
	public String toString() {
		String linea = super.toString();
		return linea += "\tCoste: "+this.coste+" cent. (coste pronincial F:"+this.franja+")";
	}
}
