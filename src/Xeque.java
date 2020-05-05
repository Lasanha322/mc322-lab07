public class Xeque {
	protected int x, y;

	Xeque(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean verificaXeque(Campo[][] campo, boolean cor) {
		boolean muv = false;
		// procura posição do rei
		//retorna true se o rei esta em xeque
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (campo[i][j].getClass() == Rei.class && campo[i][j].getCor() == cor) {
					x = i;
					y = j;
				}
			}
		}
		// verificando possibilidade de adversarios
		// verifica se tem bispo
		muv = bishop(campo, cor);
		// verifica se tem cavalo
		if (muv == false) {
			muv = horse(campo, cor);
		}
		// verifica se tem peao
		if (muv == false) {
			muv = paw(campo, cor);
		}
		// verifica se tem torre
		if (muv == false) {
			muv = tower(campo, cor);
		}
		// verifica se tem rei
		if (muv == false) {
			muv = king(campo, cor);
		}
		// verifica se tem rainha
		if (muv == false) {
			muv = queen(campo, cor);
		}
		return muv;
	}

//procura nas direções possiveis de cada peça
	public boolean queen(Campo[][] campo, boolean cor) {
		boolean muv = false;
		// leste
		muv = direcoes(campo, cor, 0, 1, new Rainha(0, 0, false));
		// nordeste
		if (muv == false) {
			muv = direcoes(campo, cor, -1, 1, new Rainha(0, 0, false));
		}
		// norte
		if (muv == false) {
			muv = direcoes(campo, cor, -1, 0, new Rainha(0, 0, false));
		}
		// noroeste
		if (muv == false) {
			muv = direcoes(campo, cor, -1, -1, new Rainha(0, 0, false));
		}
		// oeste
		if (muv == false) {
			muv = direcoes(campo, cor, 0, -1, new Rainha(0, 0, false));
		}
		// sudoeste
		if (muv == false) {

			muv = direcoes(campo, cor, 1, -1, new Rainha(0, 0, false));
		}
		// sul
		if (muv == false) {
			muv = direcoes(campo, cor, 1, 0, new Rainha(0, 0, false));
		}
		// sudeste
		if (muv == false) {
			muv = direcoes(campo, cor, 1, 1, new Rainha(0, 0, false));
		}
		return muv;
	}

	public boolean king(Campo[][] campo, boolean cor) {
		boolean muv = false;
		if (this.x + 1 < 8 && this.y + 1 < 8 && campo[x + 1][y + 1].getClass() == Rei.class
				&& campo[x + 1][y + 1].getCor() != cor
				|| this.x + 1 < 8 && this.y - 1 > -1 && campo[x + 1][y - 1].getClass() == Rei.class
						&& campo[x + 1][y - 1].getCor() != cor
				|| this.x - 1 > -1 && this.y + 1 < 8 && campo[x - 1][y + 1].getClass() == Rei.class
						&& campo[x - 1][y + 1].getCor() != cor
				|| this.x - 1 > -1 && this.y - 1 > -1 && campo[x - 1][y - 1].getClass() == Rei.class
						&& campo[x - 1][y - 1].getCor() != cor
				|| this.y - 1 > -1 && campo[x][y - 1].getClass() == Rei.class && campo[x][y - 1].getCor() != cor
				|| this.y + 1 < 8 && campo[x][y + 1].getClass() == Rei.class && campo[x][y = 1].getCor() != cor
				|| this.x - 1 > -1 && campo[x - 1][y].getClass() == Rei.class && campo[x - 1][y].getCor() != cor
				|| this.x + 1 < 8 && campo[x + 1][y].getClass() == Rei.class && campo[x + 1][y].getCor() != cor) {
			muv = true;
		}
		return muv;
	}

	public boolean tower(Campo[][] campo, boolean cor) {
		boolean muv = false;
		// oeste
		muv = direcoes(campo, cor, 0, -1, new Torre(0, 0, false));
		// leste
		if (muv == false) {
			muv = direcoes(campo, cor, 0, 1, new Torre(0, 0, false));
		}
		// norte
		if (muv == false) {
			muv = direcoes(campo, cor, -1, 0, new Torre(0, 0, false));
		}
		// sul
		if (muv == false) {
			muv = direcoes(campo, cor, 1, 0, new Torre(0, 0, false));
		}
		return muv;
	}

	public boolean paw(Campo[][] campo, boolean cor) {
		boolean muv = false;
		if (this.x + 1 < 8 && this.y + 1 < 8 && campo[x + 1][y + 1].getClass() == Peao.class
				&& campo[x + 1][y + 1].getCor() != cor
				|| this.x + 1 < 8 && this.y - 1 > -1 && campo[x + 1][y - 1].getClass() == Peao.class
						&& campo[x + 1][y - 1].getCor() != cor
				|| this.x - 1 > -1 && this.y + 1 < 8 && campo[x - 1][y + 1].getClass() == Peao.class
						&& campo[x - 1][y + 1].getCor() != cor
				|| this.x - 1 > -1 && this.y - 1 > -1 && campo[x - 1][y - 1].getClass() == Peao.class
						&& campo[x - 1][y - 1].getCor() != cor) {
			muv = true;
		}
		return muv;
	}

	public boolean horse(Campo[][] campo, boolean cor) {
		boolean muv = false;
		if ((this.x - 2 > -1 && this.y - 1 > -1 && campo[this.x - 2][this.y - 1].getClass() == Cavalo.class
				&& campo[this.x - 2][this.y - 1].getCor() != cor)
				|| this.x - 2 > -1 && this.y + 1 < 8
						&& (campo[this.x - 2][this.y + 1].getClass() == Cavalo.class
								&& campo[this.x - 2][this.y + 1].getCor() != cor)
				|| this.x + 2 < 8 && this.y - 1 > -1
						&& (campo[this.x + 2][this.y - 1].getClass() == Cavalo.class
								&& campo[this.x + 2][this.y - 1].getCor() != cor)
				|| this.x + 2 < 8 && this.y + 1 < 8 && campo[this.x + 2][this.y + 1].getClass() == Cavalo.class
						&& campo[this.x + 2][this.y + 1].getCor() != cor
				|| this.x - 1 > -1 && this.y - 2 > -1 && campo[this.x - 1][this.y - 2].getClass() == Cavalo.class
						&& campo[this.x - 1][this.y - 2].getCor() != cor
				|| this.x - 1 > -1 && this.y + 2 > 8 && campo[this.x - 1][this.y + 2].getClass() == Cavalo.class
						&& campo[this.x - 1][this.y + 2].getCor() != cor
				|| this.x + 1 < 8 && this.y - 2 > -1 && campo[this.x + 1][this.y - 2].getClass() == Cavalo.class
						&& campo[this.x + 1][this.y - 2].getCor() != cor
				|| this.x + 1 < 8 && this.y + 2 < 8 && campo[this.x + 1][this.y + 2].getClass() == Cavalo.class
						&& campo[this.x + 1][this.y + 2].getCor() != cor) {
			muv = true;
		}
		return muv;
	}

	public boolean bishop(Campo[][] campo, boolean cor) {
		boolean muv = false;
		// nordeste
		muv = direcoes(campo, cor, -1, 1, new Bispo(0, 0, false));
		// noroeste
		if (muv == false) {
			muv = direcoes(campo, cor, -1, -1, new Bispo(0, 0, false));
		}
		// sudoeste
		if (muv == false) {
			muv = direcoes(campo, cor, 1, -1, new Bispo(0, 0, false));
		}
		// sudeste
		if (muv == false) {
			muv = direcoes(campo, cor, 1, 1, new Bispo(0, 0, false));
		}
		return muv;
	}

//anda pela direção indicada
	public boolean direcoes(Campo[][] campo, boolean cor, int i, int j, Campo p) {
		boolean muv = false;
		int s1, s2;
		s1 = i;
		s2 = j;

		do {
			if (x + s1 >= 0 && x + s1 <= 7 && y + s2 >= 0 && y + s2 <= 7) {
				if ((campo[x + s1][y + s2].getClass() == p.getClass()) && campo[x + s1][y + s2].getCor() != cor) {
					muv = true;
				}
			}
			s1 = i + s1;
			s2 = j + s2;

		} while ((x + s1 > -1 && x + s1 < 8 && y + s2 > -1 && y + s2 < 8) && muv == false
				&& campo[x + s1 - i][y + s2 - j].getPeca() == false);
		return muv;
	}
}
