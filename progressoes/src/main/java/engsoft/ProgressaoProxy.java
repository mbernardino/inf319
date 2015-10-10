package engsoft;

import java.util.LinkedList;
import java.util.List;

/**
 * ENSOFT
 * INF319 - LAB: PROGRESSOES
 * Jhonny B Moreno 	 RG: 45.752.008-5 - ESOFT26
 * Moisés Bernardino RG: 40.209.255-7 - ESOFT42
 * Tatiana L. Prado  RG: 49.642.905-X - ESOFT57
 */

public abstract class ProgressaoProxy extends Progressao {

	private List<Integer> cache;
	
	public ProgressaoProxy(){
		cache = new LinkedList<Integer>();
	}

	public ProgressaoProxy(int valor) {
		cache = new LinkedList<Integer>();
		super.valCor = valor;
	}

	public int iesimoTermo(int i) {
		if (cache.get(i) == null) {
			for (int j = cache.size(); j < i; j++) {
				cache.add(proxTermo());
			}
		}

		return cache.get(i);
	}
}
