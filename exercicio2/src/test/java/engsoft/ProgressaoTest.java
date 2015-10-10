package engsoft;

import junit.framework.TestCase;

public class ProgressaoTest extends TestCase { 

    public void testProgressaoAritmetica() {
        Progressao p = new ProgressaoAritmetica();
        assertEquals(0, p.inicia());
        assertEquals(1, p.proxTermo());
        assertEquals(2, p.proxTermo());
        assertEquals(4, p.iesimoTermo(4));
        assertEquals(6, p.iesimoTermo(6));
        assertEquals("0 1 2 3 4 5 6 7 8 9 10\n",
                     p.imprimeProgressao(10));

        p = new ProgressaoAritmetica(5);
        assertEquals(0, p.inicia());
        assertEquals(5, p.proxTermo());
        assertEquals(10, p.proxTermo());
        assertEquals(20, p.iesimoTermo(4));
        assertEquals(30, p.iesimoTermo(6));
        assertEquals("0 5 10 15 20 25 30 35 40 45 50\n",
                     p.imprimeProgressao(10));
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
        assertEquals("1 5 25 125 625 3125 15625 78125 390625 1953125 9765625\n",
                     p.imprimeProgressao(10));
    }
    
    public void testProgressaoFibonacci() {
        Progressao p = new ProgressaoFibonacci();
        assertEquals(0, p.inicia());
        assertEquals(1, p.proxTermo());
        assertEquals(1, p.proxTermo());
        assertEquals(3, p.iesimoTermo(4));
        assertEquals(8, p.iesimoTermo(6));
        assertEquals("0 1 1 2 3 5 8 13 21 34 55\n",
                     p.imprimeProgressao(10));
    }

    public void testProgressaoJosephus() {
        Progressao p = new ProgressaoJosephus();
        assertEquals(0, p.inicia());
        assertEquals(2, p.proxTermo());
        assertEquals(4, p.proxTermo());
        assertEquals(8, p.iesimoTermo(4));
        assertEquals(12, p.iesimoTermo(6));
        assertEquals("0 2 4 6 8 10 12 14 16 18 20\n",
                     p.imprimeProgressao(10));
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
    }
    
    public void testProgressaoRapida() {
        Progressao p = new ProgressaoRapida(new ProgressaoAritmetica());
        // Speed test: begin.
        Progressao q = new ProgressaoAritmetica();
        int it = p.iesimoTermo(100);
	long pt = System.nanoTime();
	it = p.iesimoTermo(100);
        pt = System.nanoTime() - pt;
        long bt = System.nanoTime();
        int iq = q.iesimoTermo(100);
        bt = System.nanoTime() - bt;
        assertEquals(it,iq);
        assertTrue((bt - pt) > 0); 
        // Speed test: end.
        q.iesimoTermo(100);
        assertEquals(0, p.inicia());
        assertEquals(1, p.proxTermo());
        assertEquals(2, p.proxTermo());
        assertEquals(4, p.iesimoTermo(4));
        assertEquals(6, p.iesimoTermo(6));
        assertEquals("0 1 2 3 4 5 6 7 8 9 10\n",
                     p.imprimeProgressao(10));

        p = new ProgressaoRapida(new ProgressaoGeometrica());
        // Speed test: begin.
        q = new ProgressaoGeometrica();
        it = p.iesimoTermo(50);
	pt = System.nanoTime();
	it = p.iesimoTermo(50);
        pt = System.nanoTime() - pt;
        bt = System.nanoTime();
        iq = q.iesimoTermo(50);
        bt = System.nanoTime() - bt;
        assertEquals(it,iq);
        assertTrue((bt - pt) > 0); 
        // Speed test: end.
        assertEquals(1, p.inicia());
        assertEquals(2, p.proxTermo());
        assertEquals(4, p.proxTermo());
        assertEquals(16, p.iesimoTermo(4));
        assertEquals(64, p.iesimoTermo(6));
        assertEquals("1 2 4 8 16 32 64 128 256 512 1024\n",
                     p.imprimeProgressao(10));
        
        p = new ProgressaoRapida(new ProgressaoFibonacci());
        // Speed test: begin.
        q = new ProgressaoFibonacci();
        it = p.iesimoTermo(50);
	pt = System.nanoTime();
	it = p.iesimoTermo(50);
        pt = System.nanoTime() - pt;
        bt = System.nanoTime();
        iq = q.iesimoTermo(50);
        bt = System.nanoTime() - bt;
        assertEquals(it,iq);
        assertTrue((bt - pt) > 0); 
        // Speed test: end.
        assertEquals(0, p.inicia());
        assertEquals(1, p.proxTermo());
        assertEquals(1, p.proxTermo());
        assertEquals(3, p.iesimoTermo(4));
        assertEquals(8, p.iesimoTermo(6));
        assertEquals("0 1 1 2 3 5 8 13 21 34 55\n",
                     p.imprimeProgressao(10));

        p = new ProgressaoRapida(new ProgressaoJosephus());
        // Speed test: begin.
        q = new ProgressaoJosephus();
        it = p.iesimoTermo(40);
	pt = System.nanoTime();
	it = p.iesimoTermo(40);
        pt = System.nanoTime() - pt;
        bt = System.nanoTime();
        iq = q.iesimoTermo(40);
        bt = System.nanoTime() - bt;
        assertEquals(it,iq);
        assertTrue((bt - pt) > 0); 
        // Speed test: end.
        assertEquals(0, p.inicia());
        assertEquals(2, p.proxTermo());
        assertEquals(4, p.proxTermo());
        assertEquals(8, p.iesimoTermo(4));
        assertEquals(12, p.iesimoTermo(6));
        assertEquals("0 2 4 6 8 10 12 14 16 18 20\n",
                     p.imprimeProgressao(10));
        assertEquals(17, p.iesimoTermo(40));
        assertEquals(0, p.iesimoTermo(41));
    }

    public void testProgressaoQuadrada() {
    	Progressao p = new ProgressaoQuadrada(new ProgressaoAritmetica(1));
    	assertEquals(0, p.inicia());
    	assertEquals(1, p.proxTermo());
    	assertEquals(4, p.proxTermo());
    	assertEquals(9, p.proxTermo());
    	assertEquals(16,p.proxTermo());
    	assertEquals("0 1 4 9 16 25\n",p.imprimeProgressao(5));
    	
    	Progressao q = new ProgressaoQuadrada(new ProgressaoGeometrica());
    	assertEquals(1, q.inicia());
    	assertEquals(4, q.proxTermo());
        assertEquals(16, q.proxTermo());
        
        Progressao f = new ProgressaoQuadrada(new ProgressaoFibonacci());
        assertEquals(0, f.inicia());
        assertEquals(1, f.proxTermo());
        assertEquals(1, f.proxTermo());
        assertEquals(9, f.iesimoTermo(4));
        assertEquals(64, f.iesimoTermo(6));
    }
}



