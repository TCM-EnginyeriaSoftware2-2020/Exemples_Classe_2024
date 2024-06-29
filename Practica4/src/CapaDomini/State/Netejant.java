package CapaDomini.State;

public class Netejant implements IEstat{

    private final long startTime;

    public Netejant()
    {
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public IEstat peticioImpressio(Boolean potImprimir)
        {
            throw new RuntimeException("Impressora fent neteja de capçals.");
        }

    @Override
    public IEstat fiImpressio(Boolean calNeteja) {
        throw new RuntimeException("Impressora fent neteja de capçals.");
    }

    @Override
    public IEstat fiNeteja() {
        if( System.currentTimeMillis() - this.startTime >= 5000)
            return StandBy.getInstanciaUnica();
        throw new RuntimeException("Impressora fent neteja de capçals.");
    }

    @Override
    public IEstat carregarFulls() {
        throw new RuntimeException("Impressora fent neteja de capçals");
    }

    public String toString(){
        return "impressora en neteja";
    }
}
