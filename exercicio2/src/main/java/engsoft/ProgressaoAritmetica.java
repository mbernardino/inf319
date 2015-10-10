package engsoft;

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
