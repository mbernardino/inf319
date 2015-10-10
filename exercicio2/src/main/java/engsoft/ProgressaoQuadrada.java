package engsoft;

public class ProgressaoQuadrada extends Progressao {

	// pensei em colocar um referência para progressao
    private Progressao progressao;
	
    public ProgressaoQuadrada() {}
    
    //receber esta progressao no construtor e ao chamar o inicia da minha classe
    // irá chamar o inicia da progressão específica
    public ProgressaoQuadrada(Progressao progressao) {
    	this.progressao = progressao;
    	inicia();
	}
    
	@Override
	public int inicia() {
	    // irá chamar o inicia da progressão específica da progressão passada no cosntrutor
		return progressao.inicia();
	}

	@Override
	public int proxTermo() {
		// chama o proxTermo e calcula o quadrado
		return calcularQuadrado(progressao.proxTermo());
	}
	
	// método para calcular o quadrado
	public int calcularQuadrado (int q) {
		return (int) Math.pow(q, 2);
	}
	
	// chama o iesimoTermo e calcula o quadrado
    public int iesimoTermo(int i) {
		return (int) Math.pow(progressao.iesimoTermo(i), 2);

    }

}
