package PracticaFinal;
import static PracticaFinal.Laboratorio.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

public class Ejecutar{
public static void main (String[] args){

    BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    Laboratorio Laboratorio = new Laboratorio("Laboratorio1", new ArrayList<Experimento>());
    Experimento experimentoActual;

    System.out.println("Elige una opción: ");
    System.out.println("1. Abrir un archivo ");
    System.out.println("2. Crear un nuevo experimento ");
    System.out.println("3. Crear una población de bacterias y añadirla al experimento actual");
    System.out.println("4. Visualizar los nombres de todas las poblaciones de bacterias del experimento ");
    System.out.println("5. Borrar una población de bacterias del experimento actual");
    System.out.println("6. Ver información detallada de una población de bacterias del experimento actual ");
    System.out.println("7. Guardar  ");
    System.out.println("8. Guardar como ");
    
    int opcion = 0;
    String nombre="";

    try{
        opcion= Integer.parseInt(teclado.readLine());
    }catch(IOException e){
        System.out.println("Error al leer la entrada del usuario");
        e.printStackTrace();//Imprime la traza de la excepción
    }

    switch (opcion) {
        case 1:
            System.out.println("Introduce el nombre del archivo: ");
            try {
                nombre=teclado.readLine();
                Laboratorio.abrirArchivo(nombre); 
            } catch (IOException e) {
                e.printStackTrace();
            }     
            break;
    
        case 2:
            experimentoActual=Laboratorio.crearExperimento();
            break;
            
        case 3: 
            Laboratorio.accederExperimento().crearPoblacion();
            break;

        
        case 4:
            Laboratorio.accederExperimento().visualizarPoblaciones();
            break;
        
        case 5:
            Experimento e= Laboratorio.accederExperimento();
            
            System.out.println("Introduzca el nombre de la Población que quiere eliminar: ");
            try {
                nombre=teclado.readLine();
            } catch (IOException r) {
                r.printStackTrace();
            }
            Poblacion p= e.buscarPoblacion(nombre);
            e.borrarPoblacion(p);
            
            break;

        case 6:
            
                Experimento exp= Laboratorio.accederExperimento();
                System.out.println("Introduzca el nombre de la Población que quiere ver: ");
            try {
                nombre=teclado.readLine();
            } catch (IOException e1) {
               
                e1.printStackTrace();
            }
                Poblacion pob= exp.buscarPoblacion(nombre);
            try {
                exp.comprobarPoblacion(pob);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
                pob.verDetallesPoblacion();

            break;

        case 7:

            Experimento exp1= Laboratorio.accederExperimento();
            String contenidoArchivo1=exp1.toString();
            nombre=exp1.getNombre();
            Laboratorio.guardar(nombre,contenidoArchivo1);

            break;


        case 8:

            Experimento exp2= Laboratorio.accederExperimento();
            String contenidoArchivo2=exp2.toString();
            Laboratorio.guardarComo(contenidoArchivo2);
            
            break;
    }
    

}

}