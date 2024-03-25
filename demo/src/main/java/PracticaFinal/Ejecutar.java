package PracticaFinal;
import static PracticaFinal.Laboratorio.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

public class Ejecutar{
public static void main (String[] args){

    BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

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
    
    try{
        opcion= Integer.parseInt(teclado.readLine());
    }catch(IOException e){
        System.out.println("Error al leer la entrada del usuario");
        e.printStackTrace();//Imprime la traza de la excepción
    }

    switch (opcion) {
        case 1:
            

            break;
    
        case 2:
            
        
            break;
        
        case 3: 
        
        crearPoblacion();
            
            break;

        
        case 4:
            break;
        
        case 5:

            
            break;

        case 6:

            break;

        case 7:

            break;


        case 8:
            
                break;
    }




    


    Poblacion poblacion1 = new Poblacion("Poblacion1", LocalDate.of(2021, 5, 1), 100, 25, new Dosis(10, 10, 20, 30), Poblacion.Luminosidad.Media);
    Poblacion poblacion2 = new Poblacion("Poblacion2", LocalDate.of(2021, 5, 1), 100, 25, new Dosis(10, 10, 20, 30), Poblacion.Luminosidad.Media);
    ArrayList<Poblacion> poblaciones = new ArrayList<Poblacion>();
    poblaciones.add(poblacion1);
    poblaciones.add(poblacion2);

    Experimento experimento1 = new Experimento("Experimento1", 100, 25, new Dosis(10, 10, 20, 30), poblaciones);
}

}