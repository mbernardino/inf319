package engsoft;

/**
 * ENSOFT
 * INF319 - LAB: PROGRESSOES
 * Jhonny B Moreno 	 RG: 45.752.008-5 - ESOFT26
 * Moisés Bernardino RG: 40.209.255-7 - ESOFT42
 * Tatiana L. Prado  RG: 49.642.905-X - ESOFT57
 */

public class ProgressaoJosephus extends Progressao {
    
    private int size;
    private int step;
    private boolean[] circle;
    private int alive;

    public ProgressaoJosephus() {
        this(41, 2);
    }

    public ProgressaoJosephus(int size, int step) {
        this.size = size;
        this.step = step;
        inicia();
    }

    public int inicia() {
        circle = new boolean[size];
        circle[0] = false;
        for (int i = 1; i < size; i++) {
            circle[i] = true;
        }
        alive = size - 1;
        valCor = 0;
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

}
