public class Comando extends CSVReader {	
	protected Comando[] comandos;
	
	public Comando() {
		super();
	}
	
	public Comando[] recebeComandos() {
		String[] comandosString = this.requestCommands();
		char[] comandoChar;
		int sX, sY, tX, tY;
		
		comandos = new Comando[comandosString.length];
		
		for (int i = 0; i < comandos.length; i++) {
			comandoChar = comandosString[i].toCharArray();
			if (comandosString[i].length() == 1) {
				//Eh uma transformacao
				comandos[i] = new Transforma(comandoChar[0]);
			} else {
				//Eh uma movimentacao
				sX = 8 - (comandoChar[1] - '0');
				sY = comandoChar[0] - 'a';
				tX = 8 - (comandoChar[4] - '0');
				tY = comandoChar[3] - 'a';
				comandos[i] = new Movimento(sX, sY, tX, tY);
			}			
		}
		
		return comandos;
	}
	
	//Essa funcao eh sobreposta pelas subclasses Movimento e Transforma
	public void executaComando(Tabuleiro tabuleiro) {
		System.out.println("Erro na execucao!");
	}
	
	public void executaJogo() {
		//Geramos o tabuleiro e fazemos sua impressão
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.gerarTabuleiro();
		System.out.println("Tabuleiro inicial:");
		tabuleiro.imprimirTabuleiro();
		
		//Atualizamos o vetor de comandos
		comandos = this.recebeComandos();
		
		//Fazemos o seguinte loop enquanto restarem comandos
		for (int i = 0; i < comandos.length; i++) {
			comandos[i].executaComando(tabuleiro);
		}		
	}
}