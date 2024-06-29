package CapaDomini;

import CapaDomini.State.IEstat;

public class Impressora {
    private static final int PAQUET_NOU = 100;
    private int fulls;
    private final String ubicacio;
    private IEstat estatActual;

    public Impressora(String ubicacio) {
        this.ubicacio = ubicacio;
        this.fulls = PAQUET_NOU;
        this.estatActual = IEstat.getEstatInicial();
    }

    public String omplirFulls() {
        try{
            this.estatActual = this.estatActual.carregarFulls();
            this.fulls += PAQUET_NOU;
            return "S'han afegit fulls";
        }catch (Exception e){
            return "No es pot afegir fulls" + e.getMessage();
        }
    }

    public String imprimirDocument(PDF document)
    {
        String missatge = this.toString() + " es vol imprimir un document de "+document.getFulls()+" pàgines \n";
        try{
            this.estatActual = this.estatActual.fiNeteja();
            missatge += "S'ha acabat la neteja \n";
        }catch(Exception e) {
            // no cal fer res
        }

        try{
            this.estatActual = this.estatActual.peticioImpressio(this.fulls >= document.getFulls());
            missatge += this.estatActual.toString() + " \n";
            this.estatActual = this.estatActual.fiImpressio(Math.random() > 0.8);
            this.fulls -= document.getFulls();
            missatge += "S'ha imprés el document de " + document.getFulls() + " pàgines\n";
            missatge += this.estatActual.toString() + " \n";
        }catch(Exception e) {
            missatge += this.estatActual.toString() + " \n";
        }

        return missatge;
    }

    public String toString()
    { return "Impressora a " + this.ubicacio + " amb " + this.fulls + " fulls, estat " + this.estatActual; }


}
