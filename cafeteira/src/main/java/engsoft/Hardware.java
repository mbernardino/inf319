package engsoft;

/**
 * Classe que implementa a interface e encarna o 'hardware' da cafeteira.
 */

public class Hardware {

    // Estados dos componentes do hardware
    private EstadoHardware estadoAquecedor;
    private EstadoHardware estadoEbulidor;
    private EstadoHardware estadoInterruptor;
    private EstadoHardware estadoElementoEbulidor;
    private EstadoHardware estadoElementoAquecedor;
    private EstadoHardware estadoLuzIndicadora;
    private EstadoHardware estadoValvulaPressao;

    // Estado dos reservatórios
    private int nivelDeAgua;
    private int nivelDeCafe;

    // Janela da interface
    private Boolean hasIHC;
    private JanelaCafeteira jc;

    /**
     * Construtor define o estado da maquina ao ser 'ligada' e é independente do
     * estado inicial do software de controle.
     */
    public Hardware(Boolean hasIHC) {
    	
    	this.hasIHC = hasIHC;
    	
        estadoAquecedor = EstadoHardware.ehJarraVazia;
        estadoEbulidor = EstadoHardware.ehEbulidorVazio;
        estadoInterruptor = EstadoHardware.ehInterruptorSolto;
        estadoElementoEbulidor = EstadoHardware.ehEbulidorDesligado;
        estadoElementoAquecedor = EstadoHardware.ehAquecedorDesligado;
        estadoLuzIndicadora = EstadoHardware.ehIndicadoraLigada;
        estadoValvulaPressao = EstadoHardware.ehValvulaFechada;

        nivelDeAgua = 0;
        nivelDeCafe = 0;
        
        jc = null;
        if (this.hasIHC) {
        	jc = new JanelaCafeteira(this);
        }
    }


    // Métodos que implementam a interface do hardware. Esta
    // interface é usada pelo software de controle.

    // Aquecedor
    public EstadoHardware leEstadoAquecedor() {
        return estadoAquecedor;
    }

    public void atuElementoAquecedor(EstadoHardware modo) {
        if (modo.equals(EstadoHardware.ehAquecedorLigado)
                || modo.equals(EstadoHardware.ehAquecedorDesligado)) {
            estadoElementoAquecedor = modo;     
            if (this.hasIHC) { System.out.println("atuElementoAquecedor\n"); jc.atualizaEstado(); }
        }
    }

    // Ebulidor
    public EstadoHardware leEstadoEbulidor() {
        return estadoEbulidor;
    }

    public void atuEstadoElementoEbulidor(EstadoHardware modo) {
        if (modo.equals(EstadoHardware.ehEbulidorLigado)
                || modo.equals(EstadoHardware.ehEbulidorDesligado)) {
            estadoElementoEbulidor = modo;
            if (this.hasIHC) { System.out.println("atuEstadoElmentoEbulidor\n"); jc.atualizaEstado(); }
        }
    }

    // Interruptor
    public EstadoHardware leEstadoInterruptor() {
        EstadoHardware modo = estadoInterruptor;
        estadoInterruptor = EstadoHardware.ehInterruptorSolto;
        return modo;
    }

    // Luz indicadora
    public void atuLuzIndicadora(EstadoHardware modo) {
        if (modo.equals(EstadoHardware.ehIndicadoraLigada)
                || modo.equals(EstadoHardware.ehIndicadoraDesligada)) {
            estadoLuzIndicadora = modo;
            if (this.hasIHC) { System.out.println("atuLuzIndicadora\n"); jc.atualizaEstado(); }
        }
    }

    // Válvula de pressão
    public void atuValvulaPressao(EstadoHardware modo) {
        if (modo.equals(EstadoHardware.ehValvulaAberta)
                || modo.equals(EstadoHardware.ehValvulaFechada)) {
            estadoValvulaPressao = modo;
            if (this.hasIHC) { System.out.println("atuValvulaPressao\n"); jc.atualizaEstado(); }
        }
    }


    // Metodos usados na 'implementação' do harware. São usados pela
    // interface gráfica.
    public EstadoHardware leEstadoLuzIndicadora() {
        return estadoLuzIndicadora;
    }

    public EstadoHardware leEstadoElementoEbulidor() {
        return estadoElementoEbulidor;
    }

    public EstadoHardware leEstadoValvulaPressao() {
        return estadoValvulaPressao;
    }

    public EstadoHardware leEstadoElementoAquecedor() {
        return estadoElementoAquecedor;
    }

    public void colocaJarra() {
        if (nivelDeCafe == 0) {
            estadoAquecedor = EstadoHardware.ehJarraVazia;
        } else {
            estadoAquecedor = EstadoHardware.ehJarraNaoVazia;
        }
    }

    public void removeJarra() {
        estadoAquecedor = EstadoHardware.ehPlacaVazia;
    }

    public void pressionaBotao() {
        estadoInterruptor = EstadoHardware.ehInterruptorPressionado;
    }

    public synchronized int pegaNivelDeAgua() {
        return nivelDeAgua;
    }

    public synchronized int pegaNivelDeCafe() {
        return nivelDeCafe;
    }

    public synchronized void ajustaNivelDeAgua(int nivel) {
        if ((nivel >= 0) && (nivel <= 100)) {
            nivelDeAgua = nivel;
            if (nivelDeAgua == 0) {
                estadoEbulidor = EstadoHardware.ehEbulidorVazio;
            } else {
                estadoEbulidor = EstadoHardware.ehEbulidorNaoVazio;
            }
            if (this.hasIHC) { System.out.println("ajustaNivelDeAgua\n"); jc.atualizaEstado(); }
        }
    }

    public synchronized void ajustaNivelDeCafe(int nivel) {
        if ((nivel >= 0) && (nivel <= 100)) {
            nivelDeCafe = nivel;
            if (!estadoAquecedor.equals(EstadoHardware.ehPlacaVazia)) {
                if (nivelDeCafe == 0) {
                    estadoAquecedor = EstadoHardware.ehJarraVazia;
                } else {
                    estadoAquecedor = EstadoHardware.ehJarraNaoVazia;
                }
            }
            if (this.hasIHC) { System.out.println("ajustaNivelDeCafe\n"); jc.atualizaEstado(); }
        }
    }


    // Implementação do 'funcionamento' do hardware. É totalmente
    // independente do software de controle e engloba a interface
    // gráfica.
    public synchronized void executa() {
        if (estadoEbulidor.equals(EstadoHardware.ehEbulidorNaoVazio)
                && estadoElementoEbulidor.equals(EstadoHardware.ehEbulidorLigado)
                && estadoValvulaPressao.equals(EstadoHardware.ehValvulaFechada)) {
            ajustaNivelDeAgua(pegaNivelDeAgua() - 1);
            ajustaNivelDeCafe(pegaNivelDeCafe() + 1);
        }
    }
    
    public void iniciar() {
        // Inicia a ebulição da água
    	new Serpentina(this).start();
        // Inicia a interface gráfica
        if (this.hasIHC) { System.out.println("iniciar\n"); jc.preparaJanela(); } 
    }
    
    class Serpentina extends Thread {
        
        private Hardware hardware;

        public Serpentina(Hardware hardware) {
            this.hardware = hardware;
        }

		public void run() {
            try {
                while (true) {
                    sleep(500);
                    hardware.executa();
                }
            } catch (InterruptedException e) {
            }
        }
    }
   
    
}

