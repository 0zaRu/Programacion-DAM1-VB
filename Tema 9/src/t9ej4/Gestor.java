package t9ej4;

import java.util.LinkedList;
import java.util.Random;

public class Gestor {
	public static void main(String[] args) {
		Random rand = new Random();
		Vecino comunidad = new Vecino("Comunidad");
		CuentaCorriente CAComunidad = new CuentaAhorro(comunidad, "0000", 1000);
		
		LinkedList<Vecino> colaBanco = new LinkedList<Vecino>();
		colaBanco.add(new Vecino("Sergio", "Perez Perez", 1, 'A'));
		colaBanco.add(new Vecino("Charo", "Lopez Lopez", 2, 'B'));
		colaBanco.add(new Vecino("Juan", "Martin Martin", 3, 'C'));
		colaBanco.add(new Vecino("Silvia", "Saez Saez", 4, 'D'));
		colaBanco.add(new Vecino("Angel", "Matin Matin", 5, 'E'));
		colaBanco.add(new Vecino("Beatriz", "Diez Diez", 6, 'F'));
		
		float ingreso = 0, ingresoTotal = 0;
		float reintegro = 0, reintegroTotal = 0;
		long tAtencion = 0, tTotalAtencion = 0;
		int cantAtendidos = 0, cantIngresos = 0, cantReintegros = 0;
		
		while(colaBanco.size() != 0) {
			System.out.println("\nGente en la cola: "+ colaBanco.size());
			System.out.println("Atendiendo a un vecino ...");
			try {
				Thread.sleep(tAtencion = (rand.nextInt(4)+1)*1000);
				tTotalAtencion += tAtencion;
				
				//Si sale true se ingresa, false saca
				if(rand.nextBoolean()) {
					//CAComunidad.ingresar(ingreso = rand.nextFloat(95f)+5f);
					CAComunidad.ingresar(ingreso = rand.nextInt(95)+5);
					System.out.println("\nVecino: "+ colaBanco.poll().toString()+" ha ingresado: "+ingreso);
					ingresoTotal += ingreso;
					cantIngresos++;
				}else {
					//CAComunidad.reintegro(reintegro = rand.nextFloat(95f)+5f);
					CAComunidad.reintegro(reintegro = rand.nextInt(95)+5);	
					System.out.println("\nVecino:"+ colaBanco.poll().toString()+" ha sacado: "+reintegro);
					reintegroTotal += reintegro;
					cantReintegros++;
				}
				cantAtendidos++;
				
			} catch (InterruptedException e) {
				System.err.println("Se interrumpio el sistema."+e.getMessage());
			} catch (Exception e) {
				System.err.println("Error durante la contabilidad."+e.getMessage());
			}
		}
		
		System.out.println("\n\nEstadísticas: ");
		System.out.println("=============");
		System.out.println("Número de vecinos atendidos: "+ cantAtendidos);
		System.out.println("Número de vecinos que ingresaron: "+ cantIngresos);
		System.out.println("Cantidad de dinero ingresado: "+ ingresoTotal);
		System.out.println("Número de vecinos que sacaron dinero: "+ cantReintegros);
		System.out.println("Cantidad de dinero sacado: "+ reintegroTotal);
		System.out.println("\nBalance total despues de las operaciones: " + (ingresoTotal - reintegroTotal));
		System.out.println("Saldo que queda en la cuenta (empezó en 1000): "+ CAComunidad.getSaldo());
		System.out.println("\nEl tiempo medio de atención a los vecinos fue de: "+ (float)(tTotalAtencion / cantAtendidos)/1000+" segundos");
	}
}
