package engsoft;

/**
 * 
 * @author Moisés Bernardino 
 * RG 40.209.255-7
 * ensoft57
 *
 */

public class ProgressaoAritmetica extends Progressao {
    
    private int incremento;
    private int inicio;

	public ProgressaoAritmetica() {
        this(1);
    }

    public ProgressaoAritmetica(int incremento) {
        this.incremento = incremento;
        inicia();
    }

    public ProgressaoAritmetica(int incremento, int inicio) {
        this.incremento = incremento;
        this.setInicio(inicio);
        inicia();
    }
    
    public int inicia() {
        valCor = getInicio();
        return valCor;
    }

    public int proxTermo() {
        valCor += incremento;
        return valCor;
    }

    public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	
}
