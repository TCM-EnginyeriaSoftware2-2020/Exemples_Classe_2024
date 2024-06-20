package solucio_exercici3;

public class Clyde implements IMoviment {

    private static Clyde instanciaUnica = new Clyde();
    private Clyde(){}

    public static Clyde getInstanciaUnica() {
        return instanciaUnica;
    }
    @Override
    public void moure(int[] posicioFantasma, int[] posicioPacMan) {
        //suposa implementat el moviment de Clyde
    }
}
