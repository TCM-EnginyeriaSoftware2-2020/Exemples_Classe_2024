package CapaDomini.Mobles;

import CapaAplicacio.EFamily;
import CapaDomini.AbstractComponent;

public class CadiraClassic extends AbstractComponent implements ICadira{
    public CadiraClassic() {
        super(1, EFamily.Classica);
    }
    @Override
    public String getMaterial() {
        return "whip";
    }

    @Override
    public String getColor() {
        return "brown";
    }
}
