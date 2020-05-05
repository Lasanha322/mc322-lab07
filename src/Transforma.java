public class Transforma extends Comando {
	protected char novaPeca; //Armazena qual peca o peao deve virar
	
	Transforma(char novaPeca) {
		super();
		this.novaPeca = novaPeca;
	}
	
	public void executaComando(Tabuleiro tabuleiro) {
		int x = 0, y = 0; //Armazena as coordenadas da peca transformada
		boolean cor = false; //Armazena cor da peca transformada
		Campo peca = new Campo(0, 0); //Objeto usado pra armazenar a nova peca
		
		//A transformacao eh feita apos um peao chegar no outro lado do tabuleiro
		//Verificamos qual peao conseguiu fazer isso
		Peao peao = new Peao(0, 0, false);
		for (int i = 0; i < 8; i++) {
			if (tabuleiro.campos[0][i].getClass() == peao.getClass()
				&& tabuleiro.campos[0][i].getCor() == false) {
				y = 0;
				x = i;
				cor = false;
			} else if (tabuleiro.campos[7][i].getClass() == peao.getClass()
				&& tabuleiro.campos[7][i].getCor() == true) {
				y = 7;
				x = i;
				cor = true;
			}
		}
		
		//Localizamos o peao, entao o proximo passo eh gerar a peca na qual ele vai se transformar
		if (novaPeca == 't' || novaPeca == 'T')
			peca = new Torre(x, y, cor);
		else if (novaPeca == 'h' || novaPeca == 'H')
			peca = new Cavalo(x, y, cor);
		else if (novaPeca == 'b' || novaPeca == 'B')
			peca = new Bispo(x, y, cor);
		else if (novaPeca == 'q' || novaPeca == 'Q')
			peca = new Rainha(x, y, cor);
		else
			peca = new Peao(x, y, cor);
		
		//Com a nova peca gerada, sobrepomos o peao com a peca nova
		tabuleiro.campos[x][y] = peca;
		
		//Finalmente, fazemos a impressao do tabuleiro
		System.out.println("Source: " + (char)(y + 'a') + (char)(8 - x + '0'));
		System.out.println("Target: " + novaPeca);
		tabuleiro.imprimirTabuleiro();		
	}	
}