public class Rainha extends Campo {	
	protected int somadorX, somadorY; //Variaveis que armazeram a direcao do seu movimento
	protected int fatorX, fatorY; //Variaveis usadas para movimentos de mais de 1 espaco

	Rainha(int x, int y, boolean corPreta) {
		super(x, y);
		this.corPreta = corPreta;
		peca=true;
	}

	//Imprime uma rainha no console
	public void mostrarCampo() {
		if (corPreta == true)
			System.out.print("Q ");
		else
			System.out.print("q ");
	}

	//Verifica a validade do movimento da dama
	public boolean verificaMovimento(Campo[][] campo, int x, int y) {
		boolean muv = false;
		
		if (x > this.x)
			fatorX = 1;
		else if (x == this.x)
			fatorX = 0;
		else
			fatorX = -1;

		if (y > this.y)
			fatorY = 1;
		else if (y == this.y)
			fatorY = 0;
		else
			fatorY = -1;

		somadorX = fatorX;
		somadorY = fatorY;
		muv = movimento(campo, x, y);
		
		return muv;
	}

	//Complementa a funcao acima na verificacao do movimento da dama
	public boolean movimento(Campo[][] campo, int x, int y) {
		boolean muv = false;
		
		if ((x != this.x + fatorX && y != this.y + fatorY) 
			|| (x == this.x + fatorX && y != this.y + fatorY)
			|| (x != this.x + fatorX && y == this.y + fatorY)) {
			if (campo[this.x + fatorX][this.y + fatorY].getPeca() == false) {
				fatorX = fatorX + somadorX;
				fatorY = fatorY + somadorY;
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