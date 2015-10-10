package engsoft;

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
