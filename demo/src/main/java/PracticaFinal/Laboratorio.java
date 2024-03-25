package PracticaFinal;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Laboratorio{
   
    private ArrayList<Experimento> experimentos;
    private String nombreLab; 

    public Laboratorio(String nombreLab, ArrayList<Experimento> experimentos){
        this.experimentos=experimentos;
        this.nombreLab=nombreLab;
    }

    public void realizarExperimento(Experimento e){
        
    }
    
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

        return contenido.toString();

    }

    public void crearExperimento(String nombre, int numBacterias, double temperatura, Dosis dosisComida, ArrayList<Poblacion> poblacion){
        Experimento nuevoExperimento = new Experimento(nombre, numBacterias, temperatura, dosisComida, poblacion);
        File archivo = new File(nombre);
        try {
            PrintWriter writer = new PrintWriter(archivo);
            writer.close();
            System.out.println("Archivo creado");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }

    }

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

    public void guardarComo(String contenidoArchivo){

        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo: ");
        String nombreArchivo= scanner.nextLine();
        guardar(nombreArchivo,contenidoArchivo);

    }
}