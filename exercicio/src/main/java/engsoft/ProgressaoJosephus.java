package engsoft;

/**
 * 
 * @author Moisés Bernardino 
 * RG 40.209.255-7
 * ensoft57
 *
 */

public class ProgressaoJosephus extends Progressao {
    
    private int size;
    private int step;
    private boolean[] circle;
    private int alive;
    private int inicio;

    public ProgressaoJosephus() {
        this(41, 2);
    }

    public ProgressaoJosephus(int size, int step) {
        this.size = size;
        this.step = step;
        this.setInicio(0);
        inicia();
    }
    
    public ProgressaoJosephus(int size, int step, int inicio) {
        this.size = size;
        this.step = step;
        this.setInicio(inicio);
        inicia();
    }

    public int inicia() {
        circle = new boolean[size];
        circle[0] = false;
        for (int i = 1; i < size; i++) {
            circle[i] = true;
        }
        alive = size - 1;
        valCor = this.getInicio();
        return valCor;
    }

    public int proxTermo() {
        if (alive == 0) {
            return 0;
        }
        for (int i = 0; i < step; i++) {
            do {
                valCor = (valCor + 1) % size;
            } while (!circle[valCor]);
        }
        circle[valCor] = false;
        alive--;
        return valCor;
    }
    
    public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

}
