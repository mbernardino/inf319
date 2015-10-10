package engsoft;

/**
 * ENSOFT
 * INF319 - LAB: PROGRESSOES
 * Jhonny B Moreno 	 RG: 45.752.008-5 - ESOFT26
 * Moisés Bernardino RG: 40.209.255-7 - ESOFT42
 * Tatiana L. Prado  RG: 49.642.905-X - ESOFT57
 */

public abstract class Progressao {

    protected int valCor;

    public abstract int inicia();

    public abstract int proxTermo();

    public int iesimoTermo(int i) {
        int iesimo = inicia();
        for (int j = 0; j < i; j++) {
            iesimo = proxTermo();
        }
        return iesimo;
    }

    public String imprimeProgressao(int n) {
        StringBuilder progressao = new StringBuilder();
        progressao.append(inicia());
        for (int j = 0; j < n; j++) {
            progressao.append(' ');
            progressao.append(proxTermo());
        }
        progressao.append('\n');
        return progressao.toString();
    }

}
