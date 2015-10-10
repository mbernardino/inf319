package engsoft;

/**
 * ENSOFT
 * INF319 - LAB: PROGRESSOES
 * Jhonny B Moreno 	 RG: 45.752.008-5 - ESOFT26
 * Moisés Bernardino RG: 40.209.255-7 - ESOFT42
 * Tatiana L. Prado  RG: 49.642.905-X - ESOFT57
 */

public class ProgressaoAritmetica extends Progressao {
    
    private int incremento;

    public ProgressaoAritmetica() {
        this(1);
    }

    public ProgressaoAritmetica(int incremento) {
        this.incremento = incremento;
        inicia();
    }

    public int inicia() {
        valCor = 0;
        return valCor;
    }

    public int proxTermo() {
        valCor += incremento;
        return valCor;
    }

}
