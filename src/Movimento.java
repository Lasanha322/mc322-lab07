public class Movimento extends Comando {
	protected int sourceX, sourceY, targetX, targetY; //Armazena qual peca sera movida e o seu destino
	
	Movimento(int sX, int sY, int tX, int tY) {
		super();
		sourceX = sX;
		sourceY = sY;
		targetX = tX;
		targetY = tY;
	}
	
	public void executaComando(Tabuleiro tabuleiro) {
		//Imprimimos o movimento a ser feito
		char charX, charY;
		charX = (char)(8 - sourceX + '0');
		charY = (char)(sourceY + 'a');
		System.out.println("Source: " + charY + charX);
		charX = (char)(8 - targetX + '0');
		charY = (char)(targetY + 'a');
		System.out.println("Target: " + charY + charX);
		
		//Verificamos se ele eh valido
		if (tabuleiro.campos[sourceX][sourceY].verificaMovimento(tabuleiro.campos, targetX, targetY)
			&& tabuleiro.campos[sourceX][sourceY].getCor() == tabuleiro.getTurno())
			tabuleiro.aplicarMovimento(this);
		
		//Imprimimos o novo estado do tabuleiro
		tabuleiro.imprimirTabuleiro();	
	}	
}