
package registroAlumnos;


public class Alumno implements Aprobado {
    //Atributos
    protected String nombre; //Nombre de cada alumno
    protected double notaFinal; //La nota final de cada Alumno
    //Atributos adicionales
    protected int Pnota1,Snota2,Tnota3; //Cada nota del Alumno, las cuales le dan vida a la notaFinal

    //Constructor por defecto
    public Alumno(){
        nombre="";
        notaFinal=0.0;
        Pnota1=0;
        Snota2=0;
        Tnota3=0;
    }
    //Constructor Paramétrico
    public Alumno(String nombre, double notaFinal,int Pnota1,int Snota2,int Tnota3){
        this.nombre=nombre;
        this.notaFinal=notaFinal;
        this.Pnota1=Pnota1;
        this.Snota2=Snota2;
        this.Tnota3=Tnota3;
    }
    //Método CalculaNotaFinal, permite calcular la nota final del alumno.
    public double CalculaNotaFinal(){
        notaFinal=(Pnota1+Snota2+Tnota3)/3;//Sumamos cada nota y dividimos el resultado entre 3.
        return notaFinal;
    }

    @Override
    public String alumnoAprobado() {//Podemos escribir el código que determina cúal Alumno Aprueba.
        //Variable Adicional de tipo String, que nos indica si el Alumno aprobo o no.
         String Al;
        if(notaFinal>=50){//Si la nota Final es mayor o igual a 50, el Alumno Aprueba, en caso contrario Reprueba
            Al="Alumno Aprobado";
        }else{
            Al="Alumno Reprobado";
        }
        return Al;
    }
}
