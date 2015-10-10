package engsoft;

import java.util.ArrayList;

public class ProgressaoRapida extends Progressao {

    private Progressao progressao;
    private int termoCor;
    private ArrayList<Integer> cache;
    
    public ProgressaoRapida(Progressao progressao) {
        this.progressao = progressao;
        cache = new ArrayList<Integer>();
        cache.add(new Integer(progressao.inicia()));
        inicia();
    }
    
    public int inicia() {
        termoCor = 0;
        return ((Integer) cache.get(0)).intValue();
    }

    public int proxTermo() {
        termoCor++;
        if (termoCor < cache.size()) {
            return ((Integer) cache.get(termoCor)).intValue();
        }
        int value = progressao.proxTermo();
        cache.add(new Integer(value));
        return value;
    }

    public int iesimoTermo(int i) {
        if (i < cache.size()) {
            return ((Integer) cache.get(i)).intValue();
        }
        int iesimo = proxTermo();
        for (int j = termoCor; j < i; j++) {
            iesimo = proxTermo();
        }
        return iesimo;
    }

}
