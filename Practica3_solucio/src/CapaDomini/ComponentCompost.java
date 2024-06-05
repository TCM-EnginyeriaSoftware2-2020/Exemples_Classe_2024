package CapaDomini;

import CapaAplicacio.EFamily;
import CapaAplicacio.Etipus;

import java.util.ArrayList;

public class ComponentCompost extends AbstractComponent{
    private Etipus tipus;
    private ArrayList<AbstractComponent> llistat;
    public ComponentCompost(int area, EFamily style, Etipus tipus) {
        super(area, style);
        this.llistat = new ArrayList<>();
        this.tipus = tipus;
    }

    public boolean add(AbstractComponent nou) {
        if( nou == null ) return false;
        if( nou == this ) return false;
        if( this.style != nou.style ) return false;
        if( ! isTipus(nou) ) return false;
        if( isRepetit(nou) ) return false;
        if( availableArea() < nou.getArea()) return false;
        return this.llistat.add(nou);
    }

    private boolean isRepetit(AbstractComponent nou)
    {
        for (AbstractComponent item : this.llistat) {
            if( item == nou )
                return true;
            if( item instanceof ComponentCompost && ((ComponentCompost) item).isRepetit(nou))
                return true;
        }
        return false;
    }

    private boolean isTipus(AbstractComponent nou){
        if( this.tipus == Etipus.Casa && nou instanceof ComponentCompost && ((ComponentCompost) nou).tipus == Etipus.Habitacio)
            return true;
        if( this.tipus == Etipus.Habitacio && ! (nou instanceof ComponentCompost) )
            return true;
        return false;
    }

    private int availableArea(){
        int area = this.area;
        for (AbstractComponent item: llistat ) {
            area -= item.getArea();
        }
        return area;
    }
}
