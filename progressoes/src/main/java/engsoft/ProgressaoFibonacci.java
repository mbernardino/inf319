package engsoft;

/**
 * ENSOFT
 * INF319 - LAB: PROGRESSOES
 * Jhonny B Moreno 	 RG: 45.752.008-5 - ESOFT26
 * Moisés Bernardino RG: 40.209.255-7 - ESOFT42
 * Tatiana L. Prado  RG: 49.642.905-X - ESOFT57
 */

public class ProgressaoFibonacci extends Progressao {

	private int valPrev;

	ProgressaoFibonacci() {
		inicia();
	}

	public int inicia() {
		valCor = 0;
		valPrev = 1;
		return valCor;
	}

	public int proxTermo() {
		valCor += valPrev;
		valPrev = valCor - valPrev;
		return valCor;
	}
}
