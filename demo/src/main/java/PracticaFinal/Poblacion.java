package PracticaFinal;
import java.sql.Date;

public class Poblacion{

    String nombre;
    Date fechaInicio;
    Date fechaFin;
    int numBacterias;
    double temperatura;
    Luminosidad luminosidad;
    Dosis dosisComida;

    public Poblacion(String nombre, Date fechaInicio, Date fechaFin, int numBacterias, double temperatura, Dosis dosisComida){
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numBacterias = numBacterias;
        this.temperatura = temperatura;
        this.dosisComida = dosisComida;
    }

    //Métodos:


    //toString:

    public String toString({
        String texto="";
        texto += "Nombre: "+nombre+"\n";
        texto += "Fecha de inicio: "+fechaInicio+"\n";
        texto += "Fecha de fin: "+fechaFin+"\n";
        texto += "Número de bacterias: "+numBacterias+"\n";
        texto += "Temperatura: "+temperatura+"\n";
        texto += "Dosis de comida: "+dosisComida+"\n";
        return texto;
    }
    

}