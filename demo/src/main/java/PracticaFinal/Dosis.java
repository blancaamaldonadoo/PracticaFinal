package PracticaFinal;
import java.sql.Date;

public class Dosis{

    private int cantidadInicial;
    private Date diaStopIncremento;
    private Dosis dosisDiaStopIncremento;
    private Dosis dosisDia30;

    public Dosis(int cantidadInicial, Date diaStopIncremento, Dosis dosisDiaStopIncremento, Dosis dosisDia30){
        this.cantidadInicial = cantidadInicial;
        this.diaStopIncremento = diaStopIncremento;
        this.dosisDiaStopIncremento = dosisDiaStopIncremento;
        this.dosisDia30 = dosisDia30;
    }
}