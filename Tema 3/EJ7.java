import java.util.Scanner;

//2 operandos y 1 operador binario (suma, resta, multiplicación, división). Se mete el operador y opera los 2 operandos.

class EJ7{
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        kb.useDelimiter(System.getProperty("line.separator"));

        System.out.print("Introduce el primer operado: ");
        float v1=kb.nextFloat();
        System.out.print("\nIntroduce el segundo operando: ");
        float v2=kb.nextFloat(); 
        
        System.out.print("\nIntroduce un operador (+ | - | * | /): ");
//      char o=kb.nextLine().charAt(0);
        
        char o;
        do{o=kb.next().charAt(0);
            if(o!='*' && o!='/' && o!='+' && o!='-') System.out.print("\nERROR\nPrueba un operador válido: ");
        }while(o!='*' && o!='/' && o!='+' && o!='-');
        kb.close();

        if(o=='+') System.out.println("La suma de "+v1+" + "+v2+" es "+ (v1+v2));
        else if(o=='-') System.out.println("La resta de "+v1+" - "+v2+" es "+ (v1-v2));
        else if(o=='*') System.out.println("La multiplicación de "+v1+" x "+v2+" es "+ v1*v2);
        else System.out.println("La división de "+v1+" / "+v2+" es "+ v1/v2);
    }
}