package CapaDomini.Mobles;

import CapaAplicacio.EFamily;
import CapaDomini.AbstractComponent;

public class TaulaClassic extends AbstractComponent implements ITaula{

    public TaulaClassic() {
        super(4, EFamily.Classica);
    }

    @Override
    public int getPlaces() {
        return 4;
    }

    @Override
    public String getMaterial() { return "oak"; }

    @Override
    public String getColor() {
        return "brown";
    }
}
