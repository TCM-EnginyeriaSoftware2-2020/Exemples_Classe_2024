package solucio_exercici3;

public class Fantasma {

    public enum Colors{ Blinky, Pinky, Inky, Clyde }

    private final Colors quinFantasma;
    private int[] posicio;
    private IMoviment mov;

    public Fantasma(Colors quinFantasma, int row, int col) {
        this.quinFantasma = quinFantasma;
        this.posicio = new int[] {row,col};
        mov = IMoviment.getMoviment(this.quinFantasma);
    }

    public boolean moure( int[] posicioPacMan)
    {
        if( this.posicio[0] == posicioPacMan[0] && this.posicio[1]== posicioPacMan[1])
            return true;

        mov.moure(this.posicio, posicioPacMan);

        return this.posicio[0] == posicioPacMan[0] && this.posicio[1] == posicioPacMan[1];
    }
}
