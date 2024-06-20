package solucio_exercici3;

public class Pinky implements IMoviment {
    private static Pinky instanciaUnica = new Pinky();
    private Pinky(){}

    public static Pinky getInstanciaUnica() {
        return instanciaUnica;
    }
    @Override
    public void moure(int[] posicioFantasma, int[] posicioPacMan) {
        //suposa implementat el moviment de Pinky
    }
}
