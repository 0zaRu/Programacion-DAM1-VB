package t8ej2;

public class Vaca extends Animal{
	
	private String color = "blanco y negro";
	
	@Override
	public void comer() {
		super.comer();
		System.out.print(" hierba");
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
}
