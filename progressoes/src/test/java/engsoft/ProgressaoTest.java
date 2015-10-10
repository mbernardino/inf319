package engsoft;

import junit.framework.TestCase;

/**
 * ENSOFT
 * INF319 - LAB: PROGRESSOES
 * Jhonny B Moreno 	 RG: 45.752.008-5 - ESOFT26
 * Moisés Bernardino RG: 40.209.255-7 - ESOFT42
 * Tatiana L. Prado  RG: 49.642.905-X - ESOFT57
 */

public class ProgressaoTest extends TestCase {

	public void testProgressaoAritmetica() {
		Progressao p = new ProgressaoAritmetica();
		assertEquals(0, p.inicia());
		assertEquals(1, p.proxTermo());
		assertEquals(2, p.proxTermo());
		assertEquals(4, p.iesimoTermo(4));
		assertEquals(6, p.iesimoTermo(6));
		assertEquals("0 1 2 3 4 5 6 7 8 9 10\n", p.imprimeProgressao(10));

		p = new ProgressaoAritmetica(5);
		assertEquals(0, p.inicia());
		assertEquals(5, p.proxTermo());
		assertEquals(10, p.proxTermo());
		assertEquals(20, p.iesimoTermo(4));
		assertEquals(30, p.iesimoTermo(6));
		assertEquals("0 5 10 15 20 25 30 35 40 45 50\n",
				p.imprimeProgressao(10));

		// p = new ProgressaoAritmetica(5, 10);
		// assertEquals(10, p.inicia());
		// assertEquals(15, p.proxTermo());
		// assertEquals(20, p.iesimoTermo(2));
		// assertEquals(30, p.iesimoTermo(4));
		// assertEquals("10 15 20 25 30 35 40 45 50 55 60\n",
		// p.imprimeProgressao(10));
	}

	public void testProgressaoGeometrica() {
		Progressao p = new ProgressaoGeometrica();
		assertEquals(1, p.inicia());
		assertEquals(2, p.proxTermo());
		assertEquals(4, p.proxTermo());
		assertEquals(16, p.iesimoTermo(4));
		assertEquals(64, p.iesimoTermo(6));
		assertEquals("1 2 4 8 16 32 64 128 256 512 1024\n",
				p.imprimeProgressao(10));

		p = new ProgressaoGeometrica(5);
		assertEquals(1, p.inicia());
		assertEquals(5, p.proxTermo());
		assertEquals(25, p.proxTermo());
		assertEquals(625, p.iesimoTermo(4));
		assertEquals(15625, p.iesimoTermo(6));
		assertEquals(
				"1 5 25 125 625 3125 15625 78125 390625 1953125 9765625\n",
				p.imprimeProgressao(10));

		p = new ProgressaoGeometrica(5);
		assertEquals(1, p.inicia());
		assertEquals(5, p.proxTermo());
		assertEquals(25, p.proxTermo());
		assertEquals(625, p.iesimoTermo(4));
		assertEquals(15625, p.iesimoTermo(6));
		assertEquals(
				"1 5 25 125 625 3125 15625 78125 390625 1953125 9765625\n",
				p.imprimeProgressao(10));

		// p = new ProgressaoGeometrica(5, 25);
		// assertEquals(25, p.inicia());
		// assertEquals(125, p.proxTermo());
		// assertEquals(625, p.iesimoTermo(2));
		// assertEquals(15625, p.iesimoTermo(4));
		// assertEquals("25 125 625 3125 15625 78125 390625 1953125 9765625\n",
		// p.imprimeProgressao(8));
	}

	public void testProgressaoFibonacci() {
		Progressao p = new ProgressaoFibonacci();
		assertEquals(0, p.inicia());
		assertEquals(1, p.proxTermo());
		assertEquals(1, p.proxTermo());
		assertEquals(3, p.iesimoTermo(4));
		assertEquals(8, p.iesimoTermo(6));
		assertEquals("0 1 1 2 3 5 8 13 21 34 55\n", p.imprimeProgressao(10));

		// p = new ProgressaoFibonacci(5);
		// assertEquals(0, p.inicia());
		// assertEquals(5, p.proxTermo());
		// assertEquals(5, p.proxTermo());
		// assertEquals(10, p.iesimoTermo(3));
		// assertEquals(25, p.iesimoTermo(5));
		// assertEquals("0 5 5 10 15 25 40 65 105 170 275\n",
		// p.imprimeProgressao(10));
	}

	public void testProgressaoJosephus() {
		Progressao p = new ProgressaoJosephus();
		assertEquals(0, p.inicia());
		assertEquals(2, p.proxTermo());
		assertEquals(4, p.proxTermo());
		assertEquals(8, p.iesimoTermo(4));
		assertEquals(12, p.iesimoTermo(6));
		assertEquals("0 2 4 6 8 10 12 14 16 18 20\n", p.imprimeProgressao(10));
		assertEquals(17, p.iesimoTermo(40));
		assertEquals(0, p.iesimoTermo(41));

		p = new ProgressaoJosephus(41, 10);
		assertEquals(0, p.inicia());
		assertEquals(10, p.proxTermo());
		assertEquals(20, p.proxTermo());
		assertEquals(30, p.proxTermo());
		assertEquals(40, p.proxTermo());
		assertEquals(11, p.proxTermo());
		assertEquals(40, p.iesimoTermo(4));
		assertEquals(22, p.iesimoTermo(6));
		assertEquals("0 10 20 30 40 11 22 33 4 16 28\n",
				p.imprimeProgressao(10));
		assertEquals(25, p.iesimoTermo(40));
		assertEquals(0, p.iesimoTermo(41));

		// p = new ProgressaoJosephus(41, 10, 20);
		// assertEquals(20, p.inicia());
		// assertEquals(30, p.proxTermo());
		// assertEquals(40, p.proxTermo());
		// assertEquals(10, p.proxTermo());
		// assertEquals(20, p.proxTermo());
		// assertEquals(31, p.proxTermo());
		//
		// assertEquals("20 30 40 10 20 31 2 13 24 36 8\n",
		// p.imprimeProgressao(10));
		// assertEquals(5, p.iesimoTermo(40));
		// assertEquals(0, p.iesimoTermo(41));

	}

	public void testDesempenho() {
		
		long startTimePARapida = System.nanoTime();
		Progressao pr = new ProgressaoAritmeticaRapida();
		assertEquals(30, pr.iesimoTermo(6));
		long estimatedTimePARapida = System.nanoTime() - startTimePARapida;
		
		long startTimePA = System.nanoTime();
		Progressao p = new ProgressaoAritmetica();
		assertEquals(30, p.iesimoTermo(6));
		long estimatedTimePA = System.nanoTime() - startTimePA;



		assertTrue("Tempo Progressao Original:  " + estimatedTimePA
				+ " Tempo Progressao Rapida: " + estimatedTimePARapida,
				estimatedTimePA > estimatedTimePARapida);

	}
}
