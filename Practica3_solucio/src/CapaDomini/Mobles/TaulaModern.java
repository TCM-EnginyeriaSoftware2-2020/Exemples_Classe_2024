package CapaDomini.Mobles;

import CapaAplicacio.EFamily;
import CapaDomini.AbstractComponent;

public class TaulaModern extends AbstractComponent implements ITaula{

    public TaulaModern() {
        super(6, EFamily.Moderna);
    }
    public TaulaModern(int area){
        super(area, EFamily.Moderna);
    }

    @Override
    public int getPlaces() {
        return 6;
    }

    @Override
    public String getMaterial() { return "metal and glass"; }

    @Override
    public String getColor() {
        return "red";
    }
}
