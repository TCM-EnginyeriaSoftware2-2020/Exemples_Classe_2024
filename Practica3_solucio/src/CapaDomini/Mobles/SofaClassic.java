package CapaDomini.Mobles;

import CapaAplicacio.EFamily;
import CapaDomini.AbstractComponent;

public class SofaClassic extends AbstractComponent implements ISofa{
    public SofaClassic() {
        super(3, EFamily.Classica);
    }
    @Override
    public int getPlaces() {
        return 3;
    }

    @Override
    public String getColor() {
        return "brown";
    }
}
