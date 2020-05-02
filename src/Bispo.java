public class Bispo extends Campo {	
	private int fatorX, fatorY, somadorX, somadorY;
	Bispo (int x, int y, boolean corPreta) {
		super(x, y);
		this.corPreta = corPreta;
		peca=true;
	}
	
	public void mostrarCampo() {
		if (corPreta == true)
			System.out.print("B ");
		else
			System.out.print("b ");
	}
	public boolean verificaMovimento(Campo[][] campo, int x, int y) {
		boolean muv=false;
		if(x!=this.x || y!=this.y) {
			if (x > this.x) {
				fatorX = 1;
			}
			if(x < this.x)
				fatorX = -1;
	
			if (y > this.y) {
				fatorY = 1;
			} 
			if(y < this.y) {
				fatorY = -1;
			}
	
			somadorX = fatorX;
			somadorY = fatorY;
			muv = movimento(campo, x, y);
		}
		return muv;
	}
	public boolean movimento(Campo[][] campo, int x, int y) {
		boolean muv=false;
		if (x != this.x + fatorX && y != this.y + fatorY) {
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