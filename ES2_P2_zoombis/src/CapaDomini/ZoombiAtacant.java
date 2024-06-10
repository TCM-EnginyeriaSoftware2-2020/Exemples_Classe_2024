package CapaDomini;
public final class ZoombiAtacant {
    /* Aquesta classe no es pot modificar
     * aquest zoombi està visible i no es desplaça,
     * sí ataca
     */

    private int damage; // dany que fa
    private int posicio;

    public ZoombiAtacant( int posicio, int damage)
    {
        this.posicio = posicio;
        this.damage = damage;
    }

    public int getDamage() { return this.damage; }

    public int getPosicio() { return this.posicio; }

}
