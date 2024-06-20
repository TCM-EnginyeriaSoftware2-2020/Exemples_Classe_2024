package solucio_exercici3;

public class Blinky implements IMoviment {
    private static Blinky instanciaUnica = new Blinky();
    private Blinky(){}

    public static Blinky getInstanciaUnica() {
        return instanciaUnica;
    }

    @Override
    public void moure(int[] posicioFantasma, int[] posicioPacMan) {
        posicioFantasma[0]++;
        //suposa implementat el moviment de Blinky
    }
}
