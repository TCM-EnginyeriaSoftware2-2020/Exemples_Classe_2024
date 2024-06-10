package CapaDomini;
public final class ZoombiCaminant {
    /* Aquesta classe no es pot modificar
     * aquest zoombi està visible i no ataca,
     * sí es desplaça
     */

    private int posicio;
    private int velocitat; //quantes posicions es desplaça

    public ZoombiCaminant( int posicio, int velocitat)
    {
        this.posicio = posicio;
        this.velocitat = velocitat;
    }

    public boolean moure( int posicioEnemic )
    {
        /* la posició del enemic determina la direcció
         * si ens movem a la dreta o esquerra.
         * retorna true si alcancem l'enemic
         */
        if( Math.abs(posicioEnemic - posicio) < velocitat)
        {
            this.posicio = posicioEnemic;
            return true;
        }
        else if ( posicioEnemic > posicio )
            this.posicio += velocitat;
        else if ( posicioEnemic < posicio )
            this.posicio -= velocitat;
        return false;
    }
}
