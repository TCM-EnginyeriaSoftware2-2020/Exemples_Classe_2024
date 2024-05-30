
package CapaPresentacio;

import CapaAplicacio.Registre;

public class Prova {
    
    public static void main (String [] arg) {
        Registre ctl = new Registre ();
        float totalVenda = ctl.getTotalVenda ();
        System.out.println ("Import Total de la venda: " + totalVenda);
        System.out.println(ctl.getDescompte());
    }
    
}