package solucio_exercici3;

public interface IMoviment {
    //Patró Estratègia
    public abstract void moure(int[] posicioFantasma, int[] posicioPacMan);

    public static IMoviment getMoviment(Fantasma.Colors quinFantasma){
        switch (quinFantasma){
            case Blinky:
               return Blinky.getInstanciaUnica();
            case Pinky:
                return Pinky.getInstanciaUnica();
            case Inky:
                return Inky.getInstanciaUnica();
            case Clyde:
                return Clyde.getInstanciaUnica();
            default:
                throw new IllegalArgumentException("tipus incorrecte");
        }
    }
}
