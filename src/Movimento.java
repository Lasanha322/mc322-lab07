public class Movimento extends Comando {
	public int sourceX, sourceY, targetX, targetY;
	
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
		System.out.println("Source: " + charX + charY);
		charX = (char)(8 - targetX + '0');
		charY = (char)(targetY + 'a');
		System.out.println("Target: " + charX + charY);
		
		//Verificamos se ele eh valido
		if (tabuleiro.campos[sourceX][sourceY].verificaMovimento(tabuleiro.campos, targetX, targetY))
			tabuleiro.aplicarMovimento(this);
		
		//Imprimimos o novo estado do tabuleiro
		tabuleiro.imprimirTabuleiro();	
	}	
}