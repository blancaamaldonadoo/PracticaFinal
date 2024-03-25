package PracticaFinal;
import java.sql.Date;
import java.time.LocalDate;

public class Poblacion extends Experimento{

    private String nombre;
    private LocalDate fechaInicio;
    private Date fechaFin;
    private Luminosidad nivelLuz;

    public Poblacion(String nombre, LocalDate fechaInicio, int numBacterias, double temperatura, Dosis dosisComida, Luminosidad nivelLuz){
        super(numBacterias, temperatura, dosisComida);
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.nivelLuz = nivelLuz;  
        this.fechaFin=Date.valueOf(fechaInicio.plusDays(30));     
    }

    public enum Luminosidad{Alta, Media, Baja};

    //Getters y setters: 

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio(){
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio){
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin(){
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin){
        this.fechaFin = fechaFin;
    }

    public Luminosidad getNivelLuz(){
        return nivelLuz;
    }

    public void setNivelLuz(Luminosidad nivelLuz){
        this.nivelLuz = nivelLuz;
    }

    //Métodos:

    public void verDetallesPoblacion(){
        System.out.println(toString());
    }

    //toString:

    public String toString(){
        String texto="";
        texto += "Nombre: "+nombre+"\n";
        texto += "Fecha de inicio: "+fechaInicio+"\n";
        texto += "Fecha de fin: "+fechaFin+"\n";
        texto += "Número de bacterias: "+ getNumeroDeBacterias()+"\n";
        texto += "Temperatura (ºC): "+ getTemperatura()+"\n";
        texto += "Dosis de comida: "+ getDosisComida()+"\n";
        texto += "Nivel de luz: "+ nivelLuz+"\n";
        return texto;
    }
    

}