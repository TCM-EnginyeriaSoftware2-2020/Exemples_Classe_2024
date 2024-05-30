package domini;

import domini.estatsEscensor.EstatAscensor;

public class Ascensor {

	private final int PES_MAXIM;
	private boolean portaOberta;
	private int pesActual;
	private EstatAscensor pis;

	public Ascensor(int pes) {
		super();
		PES_MAXIM = pes;
		this.portaOberta = true;
		EstatAscensor.getEstatInicial(this);
	}

	public int getPis() {
		return pis.getPisActual();
	}

	public void pararAscensor(EstatAscensor estat) {
		this.pis = estat;
		this.obrirrPorta();
		this.pesActual = 0;
	}

	private String moviment(String direccio, int pisInici) {
		return "Ascensor " + direccio + " del pis " + pisInici + " al pis " + pis.getPisActual();
	}

	public String premerBotoPis0(int pes) throws Exception  {
		pesActual = pes;
		int pisInici = pis.getPisActual();
		String direccio = this.pis.premerBotoPis0(this);
		return moviment(direccio, pisInici);		
	}

	public String premerBotoPis1(int pes) throws Exception {
		pesActual = pes;
		int pisInici = pis.getPisActual();
		String direccio = this.pis.premerBotoPis1(this);
		return moviment(direccio, pisInici);
	}

	public String premerBotoPis2(int pes) throws Exception {
		pesActual = pes;
		int pisInici = pis.getPisActual();
		String direccio = this.pis.premerBotoPis2(this);
		return moviment(direccio, pisInici);
	}

	public void tancarPorta() {
		this.portaOberta = false;
	}

	public void obrirrPorta() {
		this.portaOberta = true;
	}

	public int getPES_MAXIM() {
		return PES_MAXIM;
	}

	public int getPesActual() {
		return this.pesActual;
	}
}