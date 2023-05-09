package t8ej9;

public interface Cent_Est_Legislable {
	public static final int nMinPisos = 2;
	public static final int nMinAulas = 10;
	public static final int nMinDespachos = 3;
	
	public int getAprobados(float[] notas);
	public int getSuspensos(float[] notas);
	public float getMedia(float[] notas);
}
