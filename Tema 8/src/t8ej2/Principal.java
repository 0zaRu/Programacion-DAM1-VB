package t8ej2;

public class Principal {
	public static void main(String[] args) {
		Animal  animal  = new Animal();
		animal.setEdad(14);
		animal.setPeso(45);
		
		Vaca    vaca    = new Vaca();
		vaca.setEdad(6);
		vaca.setPeso(450);
		vaca.setColor("Marron");
		
		Tiburon tiburon = new Tiburon();
		tiburon.setEdad(23);
		tiburon.setPeso(623);
		
		System.out.println("Datos del animal: ");
		datos(animal);
		
		System.out.println("Datos de la vaca: ");
		datos(vaca);
		
		System.out.println("Datos del tiburon: ");
		datos(tiburon);
	}
	
	static void datos(Animal animal) {
		System.out.print("-Edad: "+animal.getEdad()+"\n");
		System.out.print("-Peso: "+animal.getPeso()+"\n");
		animal.comer();
		System.out.println("\n");
		
	}
}