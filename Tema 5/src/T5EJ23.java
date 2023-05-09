import java.util.Scanner;
import java.util.StringTokenizer;

public class T5EJ23 {
	public static void main(String[] args) {
		Scanner kb= new Scanner(System.in);
		
		//Array con los meses y días de un año
		int año[][] = new int[12][];
		año[0] = new int[31];
		año[2] = new int[31];
		año[4] = new int[31];
		año[6] = new int[31];
		año[7] = new int[31];
		año[9] = new int[31];
		año[11]= new int[31]; 
		año[3] = new int[30];
		año[5] = new int[30];
		año[8] = new int[30];
		año[10]= new int[30];
		año[1] = new int[28];
		
		Fecha pedida = new Fecha();
		
		System.out.print("Introduce un día, mes y año. (dd/mm/aaaa): ");
		pedida.fecha=kb.nextLine();
		kb.close();
		
		StringTokenizer st = new StringTokenizer(pedida.fecha, "/");
		pedida.n_día=Integer.parseInt(st.nextToken());
		pedida.mes = Integer.parseInt(st.nextToken());
		pedida.año = Integer.parseInt(st.nextToken());
		
		int dias_pasados = 0;
		int años_pasados=0;
		
		if(pedida.año<2023) años_pasados=2023-pedida.año; 
		else				años_pasados=pedida.año-2023;
			
		boolean flag=false;
			
		for(int z=0; z<=años_pasados && !flag; z++)
			for(int x=0; x<año.length && !flag; x++)
				for(int y=0; y<año[x].length && !flag; y++)
					
					if((x+1)!= pedida.mes || (y+1)!=pedida.n_día || z != años_pasados) {
						dias_pasados++;
					}
					else 	flag=true;
		
		System.out.println("Han pasado "+dias_pasados+" días desde que empezó el año 2023 hasta la fecha indicada.");
		
	}
}

class Fecha{
	String fecha;
	int n_día;
	int mes;
	int año;
	
/*	static String toString() {
		String devolver="Introducido: ";
		devolver+= n_día;
		devolver+=" ";
		devolver+=enviar.mes;
		devolver+=" ";
		devolver+=enviar.año;
		return devolver;
		*/
}