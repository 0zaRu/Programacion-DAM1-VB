import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class pruebIoDatos {
	public static void main(String[] args) {
		escribe();
		lee();
	}
	
	static void escribe() {
		
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("datos.arp"));

			for (int x = 0; x < 10; x++) {
				dos.writeInt(x);
			}
			
			dos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Se ha escrito del 0 al 10");
	}
	
	static void lee() {
		System.out.print("El archivo de enteros contiene: ");
		DataInputStream dis=null;
		try {
			dis = new DataInputStream(new FileInputStream("datos.arp"));
			
			while(true)
				try{
					System.out.print("\t"+dis.readInt());
				}catch(EOFException e) {
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
		
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
