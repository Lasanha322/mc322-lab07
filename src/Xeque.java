import java.lang.*;

public class Xeque {
	private int x, y;

	public boolean verificaXeque(Campo[][] campo, boolean cor) {
		boolean muv = false;
		int x, y;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (campo[i][j].getClass() == Rei.class && campo[i][j].getCor() == cor) {
					x = i;
					y = j;
				}
			}
		}
		//verificando possibilidade de adversarios
		// verifica se tem bispo
		muv = bispo(campo, cor);
		// verifica se tem cavalo
		if (muv == false) {
			muv = cavalo(campo, cor);
		}
		// verifica se tem peao
		if (muv == false) {
			muv = peao(campo, cor);
		}
		// verifica se tem torre
		if (muv == false) {
			muv = torre(campo, cor);
		}
		// verifica se tem rei
		if (muv == false) {
			muv = rei(campo, cor);
		}
		// falta verificar se tem rainha
		return muv;
	}

	public boolean rei(Campo[][] campo, boolean cor) {
		boolean muv = false;
		if (campo[x + 1][y + 1].getClass() == Rei.class && campo[x + 1][y + 1].getCor() != cor
				|| campo[x + 1][y - 1].getClass() == Rei.class && campo[x + 1][y - 1].getCor() != cor
				|| campo[x - 1][y + 1].getClass() == Rei.class && campo[x - 1][y + 1].getCor() != cor
				|| campo[x - 1][y - 1].getClass() == Rei.class && campo[x - 1][y - 1].getCor() != cor
				|| campo[x][y - 1].getClass() == Rei.class && campo[x][y - 1].getCor() != cor
				|| campo[x][y + 1].getClass() == Rei.class && campo[x][y = 1].getCor() != cor
				|| campo[x - 1][y].getClass() == Rei.class && campo[x - 1][y].getCor() != cor
				|| campo[x + 1][y].getClass() == Rei.class && campo[x + 1][y].getCor() != cor) {
			muv = true;
		}
		return muv;
	}

	public boolean torre(Campo[][] campo, boolean cor) {
		boolean muv = false;
		int j = -1;
		do {
			if (campo[x][y + j].getClass() == Torre.class && campo[x][y + j].getCor() != cor) {
				muv = true;
			}
			j--;
		} while (y + j <= 0 || campo[x][y + j].getPeca() == true);
		if (muv == false) {
			j = 1;
			do {
				if (campo[x][y + j].getClass() == Torre.class && campo[x][y + j].getCor() != cor) {
					muv = true;
				}
				j++;
			} while (y + j <= 7 || campo[x][y + j].getPeca() == true);
		}
		if (muv == false) {
			j = -1;
			do {
				if (campo[x + j][y].getClass() == Torre.class && campo[x + j][y].getCor() != cor) {
					muv = true;
				}
				j--;
			} while (y + j <= 0 || campo[x + j][y].getPeca() == true);
		}
		if (muv == false) {
			j = 1;
			do {
				if (campo[x + j][y].getClass() == Torre.class && campo[x + j][y].getCor() != cor) {
					muv = true;
				}
				j++;
			} while (y + j <= 7 || campo[x + j][y].getPeca() == true);
		}
		return muv;
	}

	public boolean peao(Campo[][] campo, boolean cor) {
		boolean muv = false;
		if (campo[x + 1][y + 1].getClass() == Peao.class && campo[x + 1][y + 1].getCor() != cor
				|| campo[x + 1][y - 1].getClass() == Peao.class && campo[x + 1][y - 1].getCor() != cor
				|| campo[x - 1][y + 1].getClass() == Peao.class && campo[x - 1][y + 1].getCor() != cor
				|| campo[x - 1][y - 1].getClass() == Peao.class && campo[x - 1][y - 1].getCor() != cor) {
			muv = true;
		}
		return muv;
	}

	public boolean cavalo(Campo[][] campo, boolean cor) {
		boolean muv = false;
		if (campo[this.x - 2][this.y - 1].getClass() != Cavalo.class && campo[this.x - 2][this.y - 1].getCor() != cor
				|| campo[this.x - 2][this.y + 1].getClass() != Cavalo.class
						&& campo[this.x - 2][this.y + 1].getCor() != cor
				|| campo[this.x + 2][this.y - 1].getClass() != Cavalo.class
						&& campo[this.x + 2][this.y - 1].getCor() != cor
				|| campo[this.x + 2][this.y + 1].getClass() != Cavalo.class
						&& campo[this.x + 2][this.y + 1].getCor() != cor
				|| campo[this.x - 1][this.y - 2].getClass() != Cavalo.class
						&& campo[this.x - 1][this.y - 2].getCor() != cor
				|| campo[this.x - 1][this.y + 2].getClass() != Cavalo.class
						&& campo[this.x - 1][this.y + 2].getCor() != cor
				|| campo[this.x + 1][this.y - 2].getClass() != Cavalo.class
						&& campo[this.x + 1][this.y - 2].getCor() != cor
				|| campo[this.x + 1][this.y + 2].getClass() != Cavalo.class
						&& campo[this.x + 1][this.y + 2].getCor() != cor) {
			muv = true;
		}
		return muv;
	}

	public boolean bispo(Campo[][] campo, boolean cor) {
		boolean muv = false;
		int i = -1, j = 1;
		// primeiro quadrante
		do {
			if (campo[x + i][y + j].getClass() == Bispo.class && campo[x + i][y + j].getCor() != cor) {
				muv = true;
			}
			i--;
			j++;
		} while (x + i <= 0 || y + j < 8 || campo[x + i][y + j].getPeca() == true);
		// segundo quadrante
		if (muv == false) {
			i = -1;
			j = -1;
			do {
				if (campo[x + i][y + j].getClass() == Bispo.class && campo[x + i][y + j].getCor() != cor) {
					muv = true;
				}
				i--;
				j--;
			} while (x + i <= 0 || y + j <= 0 || campo[x + i][y + j].getPeca() == true);
		}
		// terceiro quadrante
		if (muv == false) {
			i = 1;
			j = -1;
			do {
				if (campo[i][y + j].getClass() == Bispo.class && campo[x + i][y + j].getCor() != cor) {
					muv = true;
				}
				i++;
				j--;
			} while (x + i < 8 || y + j <= 0 || campo[x + i][y + j].getPeca() == true);
		}
		// quarto quadrante
		if (muv == false) {
			i = 1;
			j = 1;
			do {
				if (campo[i][y + j].getClass() == Bispo.class && campo[x + i][y + j].getCor() != cor) {
					muv = true;
				}
				i++;
				j++;
			} while (x + i < 8 || y + j < 8 || campo[x + i][y + j].getPeca() == true);
		}
		return muv;
	}
}
