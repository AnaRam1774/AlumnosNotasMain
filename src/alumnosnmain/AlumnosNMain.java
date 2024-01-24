
package alumnosnmain;

    /*Excepciones:
    Las Excepciones son el medio que ofrecen ciertos lenguajes de programación,
    para tratar situaciones anómalas que pueden suceder cuando ejecutamos un programa.
    Es decir, el control de errores. 

    NOTA Import Static:
    Característica disponible desde Java 6, apoya bastante la reducción y legibilidad del código.
    Ya que al usar los atributos de la clase constantes lo hace directamente por su nombre,
    sin necesidad de referenciar la clase como con los imports normales. */

import java.util.Scanner;
import registroAlumnos.Alumno;
import static registroAlumnos.ManejoArchivos.*;

public class AlumnosNMain {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        //Variables de Ayuda
        String nombre;
        int nota1,nota2,nota3;
        int opcion;
        double nF;
        String Alaprobado;
        
        do{
            System.out.println("------MENÚ-----");
            System.out.println("1° Registrar Alumno ");
            System.out.println("2° Consultar Notas");
            System.out.println("3° Salir ");
        
            System.out.println("opción: ");
            opcion=sc.nextInt();//guardamos la opción digitada por el usuario
        
            switch(opcion){//Y dependiendo de la opción digitda, entrara en uno de los tres casos
                case 1:// Pedimos al usuario los datos del Alumno y se van escribiendo dentro del Archivo
                    sc.nextLine();
                    System.out.println("Nombre: ");
                    nombre =sc.nextLine();
                    /*Si alguna de las notas (nota1, nota2 o nota3), estan fuera del Rango, siendo el mismo; 
                    sólo números entre 0 y 100. Se enviará un mensaje indicando que el número está fuera del rango y se cerrará la ejecución.*/
                    System.out.println("1era Nota: ");
                    nota1=sc.nextInt();
                    if(nota1<0 || nota1>100){ 
                        sc.close();
                        System.out.println("El número esta fuera del rango");
                    }
                    System.out.println("2da Nota: ");
                    nota2=sc.nextInt();
                    if(nota2<0 || nota2>100){ 
                        sc.close();
                        System.out.println("El número esta fuera del rango");
                    }
                    System.out.println("3era Nota: ");
                    nota3=sc.nextInt();
                    if(nota3<0 || nota3>100){ 
                        sc.close();
                        System.out.println("El número esta fuera del rango");
                    }
                    //Creamos un objeto de tipo Alumno, le mandamos los Datos para que pueda operar.
                    Alumno al = new Alumno(nombre,0.0,nota1,nota2,nota3);
                    /*Llamamos a los métodos, "CalculaNotaFinal"; para que calcule la nota final 
                    y también, llamamos al método "AlumnoAprobado"; para determinar si el alumno Aprueba o Reprueba*/
                    nF=al.CalculaNotaFinal();
                    Alaprobado=al.alumnoAprobado();
                    //Llamamos al método "escribirArchivo", mandando los datos ingresados para finalmente escribirlos dentro del Archivo 
                    escribirArchivo("DatosNotasEstudiantes.txt",nombre,nota1,nota2,nota3,nF,Alaprobado);
                    break;
                case 2:
                    //Llamamos al método "leerArchivo", para mostrar los Datos guardados.
                    leerArchivo("DatosNotasEstudiantes.txt");
                    break;
                case 3:
                    System.out.println("Gracias por utilizar nuestro programa!!! ");
                    break;
                default:
                    /*  Si la opción no es alguna de las indicadas en el menú,
                        se mostrara un mensaje indicando que la misma en invalida*/
                    System.out.println("Opción Invalida");
                    break;
            }
        }while(opcion!=3);
        
    }
    
}
