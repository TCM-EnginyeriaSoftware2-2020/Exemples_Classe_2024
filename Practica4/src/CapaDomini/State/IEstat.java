package CapaDomini.State;

public interface IEstat {
    public abstract IEstat peticioImpressio(Boolean potImprimir);
    public abstract IEstat fiImpressio(Boolean calNeteja);
    public abstract IEstat fiNeteja();
    public abstract IEstat carregarFulls();

    public static IEstat getEstatInicial() {
        return StandBy.getInstanciaUnica();
    }
}
