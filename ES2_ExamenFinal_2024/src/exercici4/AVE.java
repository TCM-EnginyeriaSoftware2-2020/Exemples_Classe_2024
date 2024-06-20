package exercici4;

public class AVE extends AbstractTren{
    public AVE( int seients)
    { super(1435, seients);}

    @Override
    protected int getVelocitatMaxima(){ return 300; }

}
