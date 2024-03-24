
public class Experimento extends Poblacion{

    public Experimento(String nombre, Date fechaInicio, int numBacterias, double temperatura, Dosis dosisComida, poblacion Poblacion[])

    this.nombre=nombre;
    this.fechaInicio=fechaInicio;
    this.numBacterias=numBacterias;
    this.temperatura=temperatura;
    this.dosisComida=dosisComida;
    this.Poblacion=Poblacion;
    this.fechaFin=fechaInicio+30;
    super(nombre, fechaInicio, numBacterias, temperatura, dosisComida);
}