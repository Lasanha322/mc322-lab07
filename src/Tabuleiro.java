public class Tabuleiro {
	protected Campo[][] campos;
	protected boolean turno; //false para indicar turno da branca, true para indicar turno da preta
	protected int n; //Armazena o tamanho do tabuleiro
	
	void gerarTabuleiro() {
		this.turno = false;
		this.n = 8;
		campos = new Campo[n][n];

		//Comecamos colocando as pecas pretas do topo
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				//Na primeira linha, colocamos diferentes pecas
				campos[i][0] = new Torre(i, 0, true);
				campos[i][1] = new Cavalo(i, 1, true);
				campos[i][2] = new Bispo(i, 2, true);
				campos[i][3] = new Rainha(i, 3, true);
				campos[i][4] = new Rei(i, 4, true);
				campos[i][5] = new Bispo(i, 5, true);
				campos[i][6] = new Cavalo(i, 6, true);
				campos[i][7] = new Torre(i, 7, true);
			} else {				
				//Na linha de baixo, colocamos os peoes				
				for (int j = 0; j < n; j++) {
					campos[i][j] = new Peao(i, j, true);
				}				
			}
		}
		
		//Colocamos os campos do meio
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < n; j++) {
				campos[i][j] = new Campo(i, j);
			}
		}		
		
		//Por fim, colocamos as pecas brancas embaixo
		for (int i = 6; i < 8; i++) {
			if (i == 6) {				
				//Na linha de cima, colocamos os peoes				
				for (int j = 0; j < n; j++) {
					campos[i][j] = new Peao(i, j, false);
				}			
			} else {
				//Na linha de baixo, colocamos diferentes pecas
				campos[i][0] = new Torre(i, 0, false);
				campos[i][1] = new Cavalo(i, 1, false);
				campos[i][2] = new Bispo(i, 2, false);
				campos[i][3] = new Rainha(i, 3, false);
				campos[i][4] = new Rei(i, 4, false);
				campos[i][5] = new Bispo(i, 5, false);
				campos[i][6] = new Cavalo(i, 6, false);
				campos[i][7] = new Torre(i, 7, false);			
			}
		}
	}
	
	void aplicarMovimento(Movimento cmd) {
		//Aplicamos o movimento
		campos[cmd.sourceX][cmd.sourceY].setCoord(cmd.targetX, cmd.targetY);
		campos[cmd.targetX][cmd.targetY] = campos[cmd.sourceX][cmd.sourceY];
		campos[cmd.sourceX][cmd.sourceY] = new Campo(cmd.sourceX, cmd.sourceY);
			
		//Passamos o turno pra outra pessoa
		turno = !turno;
	}

	void imprimirTabuleiro() {
		//Fazemos um loop para cada linha que sera impressa
		for (int i = 0; i < n; i++) {
			//Pra cada linha, imprimimos os elementos nas colunas
			System.out.print(n-i + " ");
			for (int j = 0; j < n; j++) {
				campos[i][j].mostrarCampo();
			}
			System.out.println();
		}
		
		//Na ultima linha, imprimimos as letras
		System.out.println("  a b c d e f g h ");
		System.out.println();
	}	
}