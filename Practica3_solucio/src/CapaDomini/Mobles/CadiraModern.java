package CapaDomini.Mobles;

import CapaAplicacio.EFamily;
import CapaDomini.AbstractComponent;

public class CadiraModern extends AbstractComponent implements ICadira{

    public CadiraModern() {
        super(1, EFamily.Moderna);
    }

    @Override
    public String getMaterial() {
        return "metal";
    }

    @Override
    public String getColor() {
        return "red";
    }
}
