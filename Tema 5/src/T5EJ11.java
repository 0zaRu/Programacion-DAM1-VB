public class T5EJ11 {
	public static void main(String[] args) {
		
		String mayus="", minus="";
		
		for(int x=0; x<args[0].length(); x++) {
			mayus += Character.toUpperCase(args[0].charAt(x));
			minus += Character.toLowerCase(args[0].charAt(x));
		}
		
		System.out.println(mayus +"\n"+ minus);
	}
}
