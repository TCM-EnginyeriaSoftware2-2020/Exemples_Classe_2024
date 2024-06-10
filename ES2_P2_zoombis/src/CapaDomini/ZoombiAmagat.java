package CapaDomini;
public final class ZoombiAmagat {
    /* Aquesta classe no es pot modificar
     * aquest zoombi està invisible
     * no es desplaça ni ataca
     */

    private int posicio;

    public ZoombiAmagat(int posicio)
    {
        this.posicio = posicio;
    }

    public int getPosicio() { return this.posicio;}

    public boolean isVisible() { return false;}
}
