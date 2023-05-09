package Tema_4;

import java.util.Scanner;

public class T4EJ1 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        kb.useDelimiter(System.getProperty("line.separator"));

        System.out.print("Introduce el primer operado: ");
        float n1=kb.nextFloat();
        System.out.print("\nIntroduce el segundo operando: ");
        float n2=kb.nextFloat(); 

        System.out.print("\nIntroduce un operador (+ | - | * | /): ");
        char o;
        do{
			o=kb.next().charAt(0);
            if(o!='*' && o!='/' && o!='+' && o!='-') System.out.print("\nERROR\nPrueba un operador válido: ");
        }while(o!='*' && o!='/' && o!='+' && o!='-');
        kb.close();

        System.out.println("El resultado de "+n1+ o + +n2+" es "+ opera(n1, n2, o));
    }



    
    static float opera(float v1, float v2, char op){

        float resultado;

        if     (op=='+') resultado=v1+v2;
        else if(op=='-') resultado=v1-v2;
        else if(op=='*') resultado=v1*v2;
        else             resultado=v1/v2;

        return resultado;
    }
}
