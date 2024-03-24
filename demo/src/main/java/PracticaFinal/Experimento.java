package PracticaFinal;
import java.sql.Date;
import java.util.ArrayList;

import PracticaFinal.Poblacion.Luminosidad;

public class Experimento{

    private String nombre;
    private int numBacterias;
    private double temperatura;
    private Dosis dosisComida;
    private ArrayList<Poblacion> poblaciones;

    public Experimento(String nombre, int numBacterias, double temperatura, Dosis dosisComida, ArrayList<Poblacion> poblaciones){
        this.nombre = nombre;
        this.numBacterias = numBacterias;
        this.temperatura = temperatura;
        this.dosisComida = dosisComida;
        this.poblaciones = poblaciones;
    }

    public Experimento(int numBacterias, double temperatura, Dosis dosisComida){
        this.numBacterias = numBacterias;
        this.temperatura = temperatura;
        this.dosisComida = dosisComida;
    }


    //Getters y setters:

    public int getNumeroDeBacterias(){
        return numBacterias;
    }

    public void setNumeroDeBacterias(int numBacterias){
        this.numBacterias = numBacterias;
    }

    public double getTemperatura(){
        return temperatura;
    }

    public void setTemperatura(double temperatura){
        this.temperatura = temperatura;
    }

    public Dosis getDosisComida(){
        return dosisComida;
    }

    public void setDosisComida(Dosis dosisComida){
        this.dosisComida = dosisComida;
    }


    //Métodos:

    public void imprimirPoblaciones(Experimento e){
        for (Poblacion p: e.poblaciones){
            System.out.println(p); 
        }
    }

    public void modificarPoblacion(Poblacion pob, String nuevoNombre, Date nuevafechaInicio, int nuevoNumBacterias, double nuevaTemperatura, Dosis nuevaDosisComida, Luminosidad nuevaLuminosidad){
        pob.setNombre(nuevoNombre);
        pob.setFechaInicio(nuevafechaInicio);
        pob.setNumeroDeBacterias(nuevoNumBacterias);
        pob.setTemperatura(nuevaTemperatura);
        pob.setDosisComida(nuevaDosisComida);
        pob.setNivelLuz(nuevaLuminosidad);
        
    }

    public void guardarArchivo(){

    }

    public void crearPoblacion(String nombre, Date fechaInicio, Date fechaFin, Luminosidad nivelLuz){
        Poblacion p = new Poblacion(nombre, fechaInicio, fechaFin, numBacterias, temperatura, dosisComida, nivelLuz);
        poblaciones.add(p);
    }

    public void borrarPoblacion(Poblacion pob){
        poblaciones.remove(pob);
    }

    //toString:

    public String toString(){
        String texto="";
        texto += "Nombre: "+nombre+"\n";
        texto += "Número de bacterias: "+numBacterias+"\n";
        texto += "Temperatura: "+temperatura+"\n";
        texto += "Dosis de comida: "+dosisComida+"\n";
        texto += "Poblaciones: "+poblaciones+"\n";
        return texto;
    }
    
}