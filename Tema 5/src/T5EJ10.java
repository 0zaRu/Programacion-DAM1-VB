public class T5EJ10 {
	public static void main(String[] args) {

		String inverso="";

		for(int x=args[0].length()-1; x>=0; x--)
			inverso += args[0].charAt(x);
		
		System.out.println(inverso);		
	}
}