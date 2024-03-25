package PracticaFinal;
import java.sql.Date;

public class Dosis{

    private int cantidadInicial;
    private int diaStopIncremento;
    private int dosisDiaStopIncremento;
    private int dosisDia30;
    private int diaActual;

    public Dosis(int cantidadInicial, int diaStopIncremento, int dosisDiaStopIncremento, int dosisDia30){
        this.cantidadInicial = cantidadInicial;
        this.diaStopIncremento = diaStopIncremento;
        this.dosisDiaStopIncremento = dosisDiaStopIncremento;
        this.dosisDia30 = dosisDia30;
        this.diaActual=0;
    }


    public int calcularDosisDiaria(){
        int dosisDiaria=0;
        if (diaActual<diaStopIncremento){
            dosisDiaria=cantidadInicial + diaActual*(dosisDiaStopIncremento - cantidadInicial)/diaStopIncremento;
        }else{
            dosisDiaria=dosisDiaStopIncremento+ (diaActual - diaStopIncremento)*(dosisDia30- dosisDiaStopIncremento)/(30-diaStopIncremento);

        }
        diaActual++;
        return dosisDiaria;
    }


}