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

    public int getCantidadInicial(){
        return cantidadInicial;
    }

    public void setCantidadInicial(int cantidadInicial){
        this.cantidadInicial = cantidadInicial;
    }

    public int getDiaStopIncremento(){
        return diaStopIncremento;
    }

    public void setDiaStopIncremento(int diaStopIncremento){
        this.diaStopIncremento = diaStopIncremento;
    }

    public int getDosisDiaStopIncremento(){
        return dosisDiaStopIncremento;
    }

    public void setDosisDiaStopIncremento(int dosisDiaStopIncremento){
        this.dosisDiaStopIncremento = dosisDiaStopIncremento;
    }

    public int getDosisDia30(){
        return dosisDia30;
    }

    public void setDosisDia30(int dosisDia30){
        this.dosisDia30 = dosisDia30;
    }

    
    /**
     * Método que calcula la dosis diaria de comida que se debe suministrar a las bacterias
     * @return
     */

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

    @Override
    public String toString(){
        return "Dosis [cantidadInicial=" + cantidadInicial + ", diaStopIncremento=" + 
        diaStopIncremento + ", dosisDiaStopIncremento=" + dosisDiaStopIncremento + ", dosisDia30=" 
        + dosisDia30 + "]";
    }
}