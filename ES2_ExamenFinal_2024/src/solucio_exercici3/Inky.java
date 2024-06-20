package solucio_exercici3;

public class Inky implements IMoviment {
    private static Inky instanciaUnica = new Inky();
    private Inky(){}

    public static Inky getInstanciaUnica() {
        return instanciaUnica;
    }
    @Override
    public void moure(int[] posicioFantasma, int[] posicioPacMan) {
        //suposa implementat el moviment de Inky
    }
}
