package engsoft;

/**
 * 
 * @author Moisés Bernardino 
 * RG 40.209.255-7
 * ensoft57
 *
 */

public class ProgressaoFibonacci extends Progressao {
    
    private int valPrev;
    private int inicio;
    private int next;

	ProgressaoFibonacci() {
    	this.setInicio(0);
    	this.setNext(1);
        inicia();
    }
    
    ProgressaoFibonacci(int n) {
    	this.setInicio(0);
    	this.setNext(n);
        inicia();
    }

    public int inicia() {
	if (this.getInicio() != 0) {
		valCor = this.getNext();
	} else {
		valCor = this.getInicio();
	}
	valPrev = this.getNext();
	return valCor;
    }

    public int proxTermo() {
        valCor += valPrev;
        valPrev = valCor - valPrev;
	return valCor;
    }
    
    public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	
    public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}
    
}
