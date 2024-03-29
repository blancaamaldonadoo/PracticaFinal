package PracticaFinal;
/**
 * Clase que representa la dosis de comida que se suministra a las bacterias
 * @version 1.0, 07/06/2021
 * @autor Blanca Maldonado
 */

public class Dosis{

    private int cantidadInicial;
    private int diaStopIncremento;
    private int dosisDiaStopIncremento;
    private int dosisDia30;

    public Dosis(int cantidadInicial, int diaStopIncremento, int dosisDiaStopIncremento, int dosisDia30){
        this.cantidadInicial = cantidadInicial;
        this.diaStopIncremento = diaStopIncremento;
        this.dosisDiaStopIncremento = dosisDiaStopIncremento;
        this.dosisDia30 = dosisDia30;
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

     public void calcularDosisDiaria(){
        int dosisDiaria[]= new int[30];
        for (int i=0; i<30; i++){
        if (i<=diaStopIncremento){
            dosisDiaria[i]=cantidadInicial + i*(dosisDiaStopIncremento - cantidadInicial)/diaStopIncremento;
        }else{
            dosisDiaria[i]=dosisDiaStopIncremento+ (i - diaStopIncremento)*(dosisDia30- dosisDiaStopIncremento)/(30-diaStopIncremento);

        }
        System.out.println("Dosis del día " + (i+1) +" : " + dosisDiaria[i]+ " gramos.");
    }
    }

    @Override
    public String toString(){
        return "Dosis [cantidadInicial=" + cantidadInicial + ", diaStopIncremento=" + 
        diaStopIncremento + ", dosisDiaStopIncremento=" + dosisDiaStopIncremento + ", dosisDia30=" 
        + dosisDia30 + "]";
    }
}