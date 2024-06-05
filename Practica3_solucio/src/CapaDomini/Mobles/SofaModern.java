package CapaDomini.Mobles;

import CapaAplicacio.EFamily;
import CapaDomini.AbstractComponent;

public class SofaModern extends AbstractComponent implements ISofa{

    public SofaModern() {
        super(4, EFamily.Moderna);
    }

    @Override
    public int getPlaces() {
        return 4;
    }

    @Override
    public String getColor() {
        return "white";
    }
}
