package exercici4;

public class ViaEuropea {

    public static final int AMPLADA = 1435;
    private ITren elTren;
    public ViaEuropea( ITren elTren){
        if(elTren.comprovaAmplada(AMPLADA))
            this.elTren = elTren;
        else
            throw new RuntimeException("Amplada no coincideix");
    }

    @Override
    public String toString(){
        return "Seients " + this.elTren.getSeients() + " velocitat màxima " + this.elTren.getVelocitatMaxima();
    }

}
