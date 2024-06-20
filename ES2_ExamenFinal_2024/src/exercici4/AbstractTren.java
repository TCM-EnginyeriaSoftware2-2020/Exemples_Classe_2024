package exercici4;

public abstract class AbstractTren {
    protected int amplada;
    protected int seients;

    public AbstractTren( int amplada, int seients)
    {
        this.amplada = amplada;
        this.seients = seients;
    }

    public int getAmplada(){ return this.amplada;}

    protected int getVelocitatMaxima(){ return 120; }
}
