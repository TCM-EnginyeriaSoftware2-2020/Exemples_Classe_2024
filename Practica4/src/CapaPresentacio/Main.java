package CapaPresentacio;

import CapaDomini.Impressora;
import CapaDomini.PDF;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        Impressora TCM1 = new Impressora("TCM1");
        Impressora TCM6 = new Impressora("TCM6");
        System.out.println(TCM1);


        for( int pag : new int[]{10,20,30,20,10,20,30})
            System.out.println(TCM1.imprimirDocument(new PDF(pag)) );

        System.out.println(TCM1+"\n");
        System.out.println(TCM6+"\n");

        System.out.println(TCM6.imprimirDocument(new PDF(150)) );
        System.out.println(TCM6.omplirFulls());
        System.out.println(TCM6.imprimirDocument(new PDF(150)) );


        System.out.println(TCM6);
    }
}