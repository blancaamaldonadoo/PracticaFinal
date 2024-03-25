package PracticaFinal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

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

    public Experimento(int numBacterias, double temperatura, Dosis dosisComida){ //utilizado simplemente en Poblacion
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

    public void modificarPoblacion(Poblacion pob, String nuevoNombre, LocalDate nuevafechaInicio, int nuevoNumBacterias, double nuevaTemperatura, Dosis nuevaDosisComida, Luminosidad nuevaLuminosidad){
        pob.setNombre(nuevoNombre);
        pob.setFechaInicio(nuevafechaInicio);
        pob.setNumeroDeBacterias(nuevoNumBacterias);
        pob.setTemperatura(nuevaTemperatura);
        pob.setDosisComida(nuevaDosisComida);
        pob.setNivelLuz(nuevaLuminosidad);
        
    }

    public void crearPoblacion(){
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce el nombre de la población: ");
        String nombre="";
        try{
            nombre=teclado.readLine();
        }catch(IOException e){
            System.out.println("Error al leer la entrada del usuario");
            e.printStackTrace();
        }
        LocalDate fechaInicio=LocalDate.now();
        LocalDate fechaFin=fechaInicio.plusDays(30);
        System.out.println("Introduce el número de bacterias: ");
        int numBacterias=0;
        try{
            numBacterias=Integer.parseInt(teclado.readLine());
        }catch(IOException e){
            System.out.println("Error al leer la entrada del usuario");
            e.printStackTrace();
        }

        System.out.println("Introduce la temperatura: ");
        double temperatura=0;
        try{
            temperatura=Double.parseDouble(teclado.readLine());
        }catch(IOException e){
            System.out.println("Error al leer la entrada del usuario");
            e.printStackTrace();
        }

        System.out.println("Introduce la dosis de comida: ");
        int cantidadInicial=0;
        try{
            cantidadInicial=Integer.parseInt(teclado.readLine());
        }catch(IOException e){
            System.out.println("Error al leer la entrada del usuario");
            e.printStackTrace();
        }

        System.out.println("Introduce el día de stop de incremento: ");
        int diaStopIncremento=0;
        try{
            diaStopIncremento=Integer.parseInt(teclado.readLine());
        }catch(IOException e){
            System.out.println("Error al leer la entrada del usuario");
            e.printStackTrace();
        }

        System.out.println("Introduce la dosis del día de stop de incremento: ");
        int dosisDiaStopIncremento=0;
        try{
            dosisDiaStopIncremento=Integer.parseInt(teclado.readLine());
        }catch(IOException e){
            System.out.println("Error al leer la entrada del usuario");
            e.printStackTrace();
        }

        System.out.println("Introduce la dosis del día 30: ");
        int dosisDia30=0;
        try{
            dosisDia30=Integer.parseInt(teclado.readLine());
        }catch(IOException e){
            System.out.println("Error al leer la entrada del usuario");
            e.printStackTrace();
        }

        Dosis dosisComida = new Dosis(cantidadInicial, diaStopIncremento, dosisDiaStopIncremento, dosisDia30);

        System.out.println("Introduce la luminosidad (Alta, Media, Baja): ");
        Luminosidad nivelLuz=Luminosidad.Media;
        try{
            nivelLuz=Luminosidad.valueOf(teclado.readLine());
        }catch(IOException e){
            System.out.println("Error al leer la entrada del usuario");
            e.printStackTrace();
        }
        
        Poblacion p = new Poblacion(nombre, fechaInicio, numBacterias, temperatura, dosisComida, nivelLuz);
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