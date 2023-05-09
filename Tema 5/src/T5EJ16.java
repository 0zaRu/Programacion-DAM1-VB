public class T5EJ16 {
	
	static final int NUM_TABLAS_MULTI=100;
	static final int NUM_DE_RESULTADOS=15;
	
	public static void main(String[] args) {

		int tabla[][] = new int[NUM_TABLAS_MULTI][NUM_DE_RESULTADOS];
		rellenar_tabla(tabla);
		
		String lineas[] = new String[NUM_TABLAS_MULTI];
		for(int x=0; x<lineas.length; x++)
			lineas[x]="";
			
		cadena_constructor(tabla, lineas);
		mostrar_array(lineas);
	}
	
	/**Rellenar una matriz 10*10 con las tablas de multiplicar*/
	static void rellenar_tabla(int[][] tabla) {
		
		for(int x=0; x<tabla.length; x++)
			for(int y=0; y<tabla[x].length; y++)
				tabla[x][y]=(x+1)*(y+1);
	}
	
	/**Constructor de cadenas de caracteres de una tabla en un array de Strings del mismo numero de filas*/
	static void cadena_constructor(int[][]tabla, String[]lineas) {
		
		for(int x=0; x<tabla.length; x++)
			for(int y=0; y<tabla[x].length; y++) {
				lineas[x] += tabla[x][y];
				lineas[x] += "*\t";
			}
	}
	
	/**Mostrar un array separando en líneas las posicionse*/
	static void mostrar_array(String[] lineas) {
		
		for(int x=0; x<lineas.length; x++)
			System.out.println(lineas[x]);
	}
}