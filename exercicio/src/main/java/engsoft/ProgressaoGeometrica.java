package engsoft;

public class ProgressaoGeometrica extends Progressao {
    
    private int base;
    private int inicio;

    public ProgressaoGeometrica() {
        this(2);
    }

    public ProgressaoGeometrica(int base) {
        this.base = base;
    	this.setInicio(1);
        inicia();
    }
    
    public ProgressaoGeometrica(int base, int inicio) {
        this.base = base;
        this.setInicio(inicio);
        inicia();
    }

    public int inicia() {
        valCor = this.getInicio();
        return valCor;
    }

    public int proxTermo() {
        valCor *= base;
        return valCor;
    }
    
    public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

}
