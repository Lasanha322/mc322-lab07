public class Rainha extends Campo {
	private int fatorX, fatorY, somadorX, somadorY;

	Rainha(int x, int y, boolean corPreta) {
		super(x, y);
		this.corPreta = corPreta;
		peca=true;
	}

	public void mostrarCampo() {
		if (corPreta == true)
			System.out.print("Q ");
		else
			System.out.print("q ");
	}

	public boolean verificaMovimento(Campo[][] campo, int x, int y) {
		boolean muv = false;
		if (x > this.x) {
			fatorX = 1;
		} else if (x == this.x) {
			fatorX = 0;
		} else
			fatorX = -1;

		if (y > this.y) {
			fatorY = 1;
		} else if (y == this.y) {
			fatorY = 0;
		} else
			fatorY = -1;

		somadorX = fatorX;
		somadorY = fatorY;
		muv = movimento(campo, x, y);
		return muv;
	}

	public boolean movimento(Campo[][] campo, int x, int y) {
		boolean muv = false;
		if ((x != this.x + fatorX && y != this.y + fatorY) || (x == this.x + fatorX && y != this.y + fatorY)
				|| x != this.x + fatorX && y == this.y + fatorY) {
			if (campo[this.x + fatorX][this.y + fatorY].getPeca() == false) {
				fatorX = fatorX + somadorX;
				fatorY = fatorY + somadorY;
				muv = movimento(campo, x, y);
			}
		}
		if (x == this.x + fatorX && y == this.y + fatorY) {
			if (campo[this.x + fatorX][this.y + fatorY].getPeca() == false
					|| (campo[this.x + fatorX][this.y + fatorY].getPeca() == true
							&& campo[this.x + fatorX][this.y + fatorY].getCor() != corPreta)) {
				muv = true;
			}
		}
		return muv;
	}

}