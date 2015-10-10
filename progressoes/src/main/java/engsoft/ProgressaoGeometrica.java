package engsoft;

/**
 * ENSOFT
 * INF319 - LAB: PROGRESSOES
 * Jhonny B Moreno 	 RG: 45.752.008-5 - ESOFT26
 * Moisés Bernardino RG: 40.209.255-7 - ESOFT42
 * Tatiana L. Prado  RG: 49.642.905-X - ESOFT57
 */

public class ProgressaoGeometrica extends Progressao {
    
    private int base;

    public ProgressaoGeometrica() {
        this(2);
    }

    public ProgressaoGeometrica(int base) {
        this.base = base;
        inicia();
    }

    public int inicia() {
        valCor = 1;
        return valCor;
    }

    public int proxTermo() {
        valCor *= base;
        return valCor;
    }

}
