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

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

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

    public void imprimirPoblaciones(){
        for (Poblacion p: this.poblaciones){
            System.out.println(p); 
        }
    }

    public void modificarPoblacion(Poblacion pob){
        if (this.poblaciones.contains(pob)){//Comprobar que la población pertenece al experimento:
            BufferedReader teclado = new BufferedReader (new InputStreamReader(System.in));
            System.out.println("Introduce el nuevo número de bacterias: ");
            int numBacterias=0;
            try{
                numBacterias=Integer.parseInt(teclado.readLine());
            }
            catch(IOException e){
                System.out.println("Error al leer la entrada del usuario");
                e.printStackTrace();
            }
            pob.setNumeroDeBacterias(numBacterias);

            System.out.println("Introduce la nueva temperatura: ");
            double temperatura=0;
            try{
                temperatura=Double.parseDouble(teclado.readLine());
            }
            catch(IOException e){
                System.out.println("Error al leer la entrada del usuario");
                e.printStackTrace();
            }
            pob.setTemperatura(temperatura);

            System.out.println("Introduce la nueva dosis de comida inicial: ");
            int cantidadInicial=0;
            try{
                cantidadInicial=Integer.parseInt(teclado.readLine());
            }
            catch(IOException e){
                System.out.println("Error al leer la entrada del usuario");
                e.printStackTrace();
            }

            System.out.println("Introduce el nuevo día de stop de incremento: ");
            int diaStopIncremento=0;
            try{
                diaStopIncremento=Integer.parseInt(teclado.readLine());
            }
            catch(IOException e){
                System.out.println("Error al leer la entrada del usuario");
                e.printStackTrace();
            }

            System.out.println("Introduce el nuevo nivel de luminosidad (Alta, Media, Baja): ");
            Luminosidad nivelLuz=Luminosidad.Media;
            try{
                nivelLuz=Luminosidad.valueOf(teclado.readLine());
            }
            catch(IOException e){
                System.out.println("Error al leer la entrada del usuario");
                e.printStackTrace();
            }
            pob.setNivelLuz(nivelLuz);

            pob.setFechaInicio(LocalDate.now());

        }
        else{
            System.out.println("La población no pertenece al experimento: " + this.nombre); 
        }
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
            comprobarCantidadComida(cantidadInicial);
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
            comprobarCantidadComida(dosisDiaStopIncremento);
        }catch(IOException e){
            System.out.println("Error al leer la entrada del usuario");
            e.printStackTrace();
        }

        System.out.println("Introduce la dosis del día 30: ");
        int dosisDia30=0;
        try{
            dosisDia30=Integer.parseInt(teclado.readLine());
            comprobarCantidadComida(dosisDia30);
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
        poblaciones.add(p); //Se añade al experimento actual
    }

    public void borrarPoblacion(Poblacion pob){
        try {
            if(comprobarPoblacion(pob))
            poblaciones.remove(pob);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public int comprobarCantidadComida(int c) throws ArithmeticException{
        if (c<0||c>300) throw new ArithmeticException ("No es válida una dosis negativa o mayor que 300");
        return c;
    }

    //toString:
    @Override
    public String toString(){
        String texto="";
        texto += "Nombre: "+nombre+"\n";
        texto += "Número de bacterias: "+numBacterias+"\n";
        texto += "Temperatura: "+temperatura+"\n";
        texto += "Dosis de comida: "+dosisComida+"\n";
        texto += "Poblaciones: "+poblaciones+"\n";
        return texto;
    }

    public void visualizarPoblaciones(){
        for(Poblacion p: poblaciones){
            System.out.println(p.getNombre);
        }
    
    }

    public boolean comprobarPoblacion(Poblacion p) throws FileNotFoundException{
        for (Poblacion i: poblaciones){
            if(i.getNombre().equals(p.getNombre)){
                p=i;
                return true;
            }
            else throw new FileNotFoundException("No se ha encontrado la poblacion en este experimento");
        }
        return false;
    }
    
}