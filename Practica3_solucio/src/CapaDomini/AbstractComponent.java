package CapaDomini;

import CapaAplicacio.EFamily;
import CapaAplicacio.Etipus;

public abstract class AbstractComponent {
    protected int area;
    protected EFamily style;
    public AbstractComponent (int area, EFamily style){
        this.area = area;
        this.style = style;
    }

    public int getArea() {return this.area; }
    public EFamily getStyle() { return this.style; }

}
