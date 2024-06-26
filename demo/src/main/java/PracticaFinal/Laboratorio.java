package PracticaFinal;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * Clase que representa un laboratorio
 * @version 1.0, 07/06/2021
 * @autor Blanca Maldonado
 * @param experimentos
 * @param nombreLab
 */

public class Laboratorio{
   
    private ArrayList<Experimento> experimentos;
    private String nombreLab; 

    public Laboratorio(String nombreLab, ArrayList<Experimento> experimentos){
        this.experimentos=experimentos;
        this.nombreLab=nombreLab;
    }

    //Getters y setters:

    public String getNombreLab(){
        return nombreLab;
    }

    public void setNombreLab(String nombreLab){
        this.nombreLab=nombreLab;
    }

    //Métodos:

    /**
     * Método que crea un nuevo archivo
     * @param archivo
     * @return void
     * @throws IOException
     */

    public void createNewFile(File archivo){
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
    }
    
    /**
     * Método que abre un archivo 
     * @param nombreArchivo
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     */

    public String abrirArchivo(String nombreArchivo){
        File archivo= new File(nombreArchivo);
        StringBuilder contenido= new StringBuilder();

        try{
            BufferedReader reader=new BufferedReader(new FileReader(archivo));
            String linea;

            while((linea=reader.readLine())!=null){
                contenido.append(linea);
                contenido.append("\n");
            }
            reader.close();
            System.out.println("Archivo abierto");
        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        }catch(IOException e){
            System.out.println("Error al leer el archivo");
        }

        return contenido.toString();//convierte el StringBuilder a una cadena String

    }

    /**
     * Método que crea un nuevo experimento
     * @return Experimento
     * @throws IOException
     * @throws NumberFormatException
     * @throws IOException
     */

    public Experimento crearExperimento(){
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce el nombre del archivo: ");
        String nombre = "";
        try {
            nombre = teclado.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer la entrada del usuario");
            e.printStackTrace();
        }
        
        File archivo = new File(nombre);
        try {
            PrintWriter writer = new PrintWriter(archivo);
            writer.close();
            System.out.println("Archivo creado");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }

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

        System.out.println("Introduce el numero de poblaciones que quiere para este experimento: ");
        int numeroPobs=0;
        try{
            numeroPobs=Integer.parseInt(teclado.readLine());
        }catch(IOException e){
            System.out.println("Error al leer la entrada del usuario");
            e.printStackTrace();
        }

        Experimento e = new Experimento(numBacterias, temperatura, dosisComida);
        experimentos.add(e);

        for (int i=0; i<=numeroPobs; i++){
             e.crearPoblacion();
        }
        return e;
    }

    /**
     * Método que guarda un archivo
     * @param nombreArchivo
     * @param contenidoArchivo
     * @return void
     * @throws FileNotFoundException
     */

    public void guardar(String nombreArchivo, String contenidoArchivo){
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter writer = new PrintWriter(archivo);
            writer.println(contenidoArchivo);
            writer.close();
            System.out.println("Archivo guardado");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }

    }

    /**
     * Método que guarda un archivo con un nuevo nombre
     * @param contenidoArchivo
     * @return void
     */

    public void guardarComo(String contenidoArchivo){

        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo: ");
        String nombreArchivo= scanner.nextLine();
        guardar(nombreArchivo,contenidoArchivo);
    }

    /**
     * Método que accede a un experimento
     * @return Experimento
     */

    public Experimento accederExperimento(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese el nombre del experimento: ");
        Experimento experimento=null;
        String nombreExperimento= scanner.nextLine();
        for (Experimento e: experimentos){
            if (e.getNombre().equals(nombreExperimento)){
                e=experimento;
            }
        }
        return experimento;
    }
}   