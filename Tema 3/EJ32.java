import java.util.Scanner;
import java.util.Locale;
import java.util.Random;

class Arrayclassprueba {

    static final int MAX=10;
    static final int MIN=0;

    public static void main(String[] args){
        //declarar escaner de datos y modificar el separador de linea
        Random aleatorio= new Random();

        Scanner kb=new Scanner(System.in);
        kb.useDelimiter(System.getProperty("line.separator"));
        kb.useLocale(Locale.ENGLISH);
        
        boolean flag;

        do{
            //limpiar pantalla del sistema
            System.out.print("\033[H\033[2J");
            System.out.flush();

            //introducir cantidad de valores que tendrá el objeto_array de la clase Alumno
            System.out.print("Mete la cantidad de alumnos: ");
            int n=kb.nextInt();

            //crear objeto de la clase Alumno
            Alumno[] al=new Alumno[n];

            //bucle for para instanciar arrays del objeto y rellenar sus datos
            for(int x=0; x<n; x++){
                //instanciar la posición del array
                al[x]=new Alumno();

                //pedir nombres de los alumnos
                System.out.print("\nIntroduce el nombre del alumno nº"+(x+1)+": ");
                al[x].nombre=kb.next();

                //pedir notas (la cantidad de notas va en función de una constante creada al principio de la clase Alumno)
                for(int y=0; y<Alumno.NEXAM; y++){
                    System.out.print("\nIntroduce la nota nº"+(y+1)+" de "+al[x].nombre+": ");
                    al[x].notas[y]=kb.nextFloat();
                }
            }

            //bucle for para mostrar las medias individuales y crear parte de la media de la clase
            float media_clase=0;

            for(int x=0; x<n; x++){
                for(int y=0; y<Alumno.NEXAM; y++)
                    al[x].media+=al[x].notas[y];

                al[x].media/=Alumno.NEXAM;
                media_clase+=al[x].media;

                System.out.print("\nLa nota media de "+al[x].nombre+" es: "+al[x].media+"\n");
                    if(al[x].media<5)    System.out.println("SUSPENSO");
                    else                 System.out.println("APROBADO");
            }

        
            //Preguntar si se quiere ver la media de la clase y enseñarla diciendo la nota implícita
            System.out.print("Desea ver la media de la clase? Y/N: ");
            char comp=kb.next().charAt(0);
        
            if(comp == 'Y' || comp == 'y'){
                //Terminar de calcular la media y mostrarla
                media_clase/=n;

                System.out.println("\nLa nota media de la clase es: "+ media_clase);
                if(media_clase<5) System.out.println("SUSPENSO");
                else if (media_clase>=5 && media_clase<7) System.out.println("APROBADO");
                else if (media_clase>=7 && media_clase<9) System.out.println("NOTABLE");
                else if (media_clase>=9 && media_clase<10) System.out.println("SOBERSALIENTE");
                else System.out.println("MATRÍCULA DE HONOR");
            }

            //Mostrar un menú donde se elgie el valor de un switch "gracioso".

            System.out.println("\n\nTeniendo en cuenta los resultados, que desea hacer?");
            System.out.println("==================================================================");
            System.out.println("|                       Elige una opción                         |");
            System.out.println("|================================================================|");
            System.out.println("| 1. Felicitar a la clase                                        |");
            System.out.println("| 2. Decepcionarse con la clase                                  |");        
            System.out.println("| 3. Aumentar los exámenes                                       |");
            System.out.println("| 4. Cambiar nota media por un nº aleatorio (por su bien)        |");
            System.out.println("| 5. No hacer nada (terminar)                                    |");
            System.out.println("==================================================================");
            System.out.print("\nOpción: ");
            int opcion;

            //Bucle para que el dato introducido sea correcto
            do{
                opcion=kb.nextInt();
                if(opcion<1 || opcion>5) System.out.print("ERROR\nIntroduzca un valor válido: ");
            }while(opcion<1 || opcion>5);

            //Switch para elegir la salida
            switch(opcion){
                case 1:
                    System.out.println("Se ha enviado un correo a toda la clase diciendo lo buenos alumnos que son.");
                    break;
                case 2:
                    System.out.println("Se ha enviado su numero de cuenta a todos los alumnos para que hagan una transferencia para comprar el aprobado");
                    break;
                case 3:
                    System.out.println("Edite la constante de la clase Alumno (NEXAM).");
                    break;
                case 4:
                    media_clase=aleatorio.nextFloat(MAX-MIN+1)+MIN;
                    System.out.println("Ahora la nota media de la clase es: "+media_clase);
            }
    
            //Bloque para ver si se quiere reempezar el programa con bandera boolean
            System.out.print("\n\nDesea volver a usar el programa desde 0? Y/N: ");
           comp=kb.next().charAt(0);
    
            if(comp == 'Y' || comp == 'y') flag=false;
            else flag=true;
    
            if(flag) kb.close();
        }while(!flag);
    }
}

//Clase plantilla para Alumno
class Alumno {
    //Constante para la cantidad de examenes 
    public static final int NEXAM=3;
    //Datos de la clase
    String nombre;
    float media;

    //Array de floats dentro de una clase de NEXAM valores
    float notas[]=new float[NEXAM];
}
