public class Torre extends Campo {	
	protected int somadorX, somadorY; //Variaveis que armazeram a direcao do seu movimento
	protected int fatorX, fatorY; //Variaveis usadas para movimentos de mais de 1 espaco

	Torre(int x, int y, boolean corPreta) {
		super(x, y);
		this.corPreta = corPreta;
		peca = true;
	}

	//Imprime uma torre na tela
	public void mostrarCampo() {
		if (corPreta == true)
			System.out.print("T ");
		else
			System.out.print("t ");
	}

	//Verifica a validade do movimento da torre
	public boolean verificaMovimento(Campo[][] campo, int x, int y) {
		boolean muv = false;
		
		if (x == this.x && y != this.y) {
			fatorX = 0;
			if (y > this.y)
				fatorY = 1;
			else
				fatorY = -1;
		}
		
		if (x != this.x && y == this.y) {
			fatorY = 0;
			if (x > this.x)
				fatorX = 1;
			else
				fatorX = -1;

		}

		somadorX = fatorX;
		somadorY = fatorY;
		muv = movimento(campo, x, y);
		
		return muv;
	}

	//Complementa a funcao acima na verificacao da torre
	public boolean movimento(Campo[][] campo, int x, int y) {
		boolean muv = false;

		if (fatorX == 0 && y != this.y + fatorY) {
			if (campo[this.x][this.y + fatorY].getPeca() == false) {
				fatorY = fatorY + somadorY;
				muv = movimento(campo, x, y);
			}
		}
		
		if (fatorY == 0 && x != this.x + fatorX) {
			if (campo[this.x + fatorX][this.y].getPeca() == false) {
				fatorX = fatorX + somadorX;
				muv = movimento(campo, x, y);
			}
		}
		
		if (x == this.x + fatorX && y == this.y + fatorY
			&& (campo[this.x + fatorX][this.y + fatorY].getPeca() == false
				|| (campo[this.x + fatorX][this.y + fatorY].getPeca() == true
					&& campo[this.x + fatorX][this.y + fatorY].getCor() != corPreta)))
			muv = true;
			
		return muv;
	}
}