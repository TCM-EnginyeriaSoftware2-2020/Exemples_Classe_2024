package domini.estatsEscensor;

import domini.Ascensor;

public abstract class EstatAscensor {

	public static void getEstatInicial(Ascensor ascensor) {
		ascensor.pararAscensor(new Pis0());		
	}
	protected boolean pesCorrecte (Ascensor ascensor) {
		return ascensor.getPesActual() <= ascensor.getPES_MAXIM();
	}

	public abstract String premerBotoPis0(Ascensor ascensor) throws Exception;
	
	public abstract String premerBotoPis1(Ascensor ascensor) throws Exception;
	
	public abstract String premerBotoPis2(Ascensor ascensor) throws Exception;

	public abstract int getPisActual();
}