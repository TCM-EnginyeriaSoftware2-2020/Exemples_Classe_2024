package domini.estatsEscensor;

import domini.Ascensor;

public class Pis0 extends EstatAscensor {

	@Override
	public String premerBotoPis0(Ascensor ascensor) throws Exception {
		throw new Exception ("Sense moviement. Ja estás al pis 0");
	}

	@Override
	public String premerBotoPis1(Ascensor ascensor) throws Exception {
		if (this.pesCorrecte(ascensor)) {
			ascensor.tancarPorta();
			ascensor.pararAscensor(new Pis1());
			return "pujant";
		}
		throw new Exception("Hi ha masa pes en l'ascensor.");
	}

	@Override
	public String premerBotoPis2(Ascensor ascensor) throws Exception {
		if (this.pesCorrecte(ascensor)) {
			ascensor.tancarPorta();
			ascensor.pararAscensor(new Pis2());
			return "pujant";
		}
		throw new Exception ("Hi ha masa pes en l'ascensor.");
	}

	@Override
	public int getPisActual() {
		return 0;
	}
}
