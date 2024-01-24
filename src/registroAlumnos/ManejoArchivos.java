
package registroAlumnos;

import java.io.*;

public class ManejoArchivos {
    
    public static void escribirArchivo(String nombreArchivo,String nombreAlumno,int nota01,int nota02 , int nota03,double ntF,String alA){
        //Creamos un objeto de tipo File (es decir de tipo Archivo), y le asignamos el nombre;
        File archivo = new File(nombreArchivo);  
        
        try{
            /*PrintWriter es una clase que nos sirve para crear y escribir en el archivo.*/
            try (PrintWriter salida = new PrintWriter(new FileWriter(archivo,true))) {
                //Con el objeto tipo PrintWriter (salida), podemos guardar dentro del archivo los datos suministrados
                salida.println(nombreAlumno+","+nota01+","+nota02+","+nota03+","+ntF+","+alA);
            }
            System.out.println("Se escribio el archivo");
        }catch(FileNotFoundException ex){
            /*utilizamos el printStackTrace para imprimir el registro del stack,
            donde se ha iniciado la excepción. A su vez, lo mandamos a la consola.*/ 
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void leerArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        
        try{
            /*BufferedReader es una clase que nos ayuda a leer un archivo (el contenido).
            Creamos un objeto de tipo BufferedReader, al mismo tiempo que un FileReader, para indicar
            cúal es el archivo que queremos leer*/
            try (BufferedReader entrada = new BufferedReader(new FileReader(archivo))) {
                //Para leer cada línea del archivo, creamos una variable de tipo String (lectura);
                String lectura = entrada.readLine();//Leemos la primera línea
                while(lectura!=null){
                    /*Con while, mientras hayan mas lineas por leer dentro del archivo
                    se seguirán guardando dentro de lectura, hasta que no hayan mas datos.*/
                    System.out.println(lectura);
                    lectura = entrada.readLine();
                }
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
