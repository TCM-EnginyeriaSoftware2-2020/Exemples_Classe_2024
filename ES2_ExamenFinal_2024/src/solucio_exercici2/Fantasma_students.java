package solucio_exercici2;

public class Fantasma_students {

    public enum Colors{ Blinky, Pinky, Inky, Clyde }

    private final Colors quinFantasma;
    private int[] posicio;

    public Fantasma_students(Colors quinFantasma, int row, int col) {
        this.quinFantasma = quinFantasma;
        this.posicio = new int[] {row,col};
    }

    public boolean moure( int[] posicioPacMan)
    {
        if( this.posicio[0] == posicioPacMan[0] && this.posicio[1]== posicioPacMan[1])
            return true;
        switch (this.quinFantasma){
            case Blinky:
                //suposa implementat el moviment de Blinky
                break;
            case Pinky:
                //suposa implementat el moviment de Pinky
                break;
            case Inky:
                //suposa implementat el moviment de Inky
                break;
            case Clyde:
                //suposa implementat el moviment de Clyde
                break;
            default:
                throw new IllegalArgumentException("color incorrecte");
        }
        return this.posicio[0] == posicioPacMan[0] && this.posicio[1] == posicioPacMan[1];
    }
}
