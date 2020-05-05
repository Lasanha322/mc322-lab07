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
		// verificando possibilidade de adversarios
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
		// verifica se tem rainha
		if (muv == false) {
			muv = rainha(campo, cor);
		}
		return muv;
	}
//procura nas direções possiveis de cada peça
	public boolean rainha(Campo[][] campo, boolean cor) {
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
		if (campo[this.x - 2][this.y - 1].getClass() == Cavalo.class && campo[this.x - 2][this.y - 1].getCor() != cor
				|| campo[this.x - 2][this.y + 1].getClass() == Cavalo.class
						&& campo[this.x - 2][this.y + 1].getCor() != cor
				|| campo[this.x + 2][this.y - 1].getClass() == Cavalo.class
						&& campo[this.x + 2][this.y - 1].getCor() != cor
				|| campo[this.x + 2][this.y + 1].getClass() == Cavalo.class
						&& campo[this.x + 2][this.y + 1].getCor() != cor
				|| campo[this.x - 1][this.y - 2].getClass() == Cavalo.class
						&& campo[this.x - 1][this.y - 2].getCor() != cor
				|| campo[this.x - 1][this.y + 2].getClass() == Cavalo.class
						&& campo[this.x - 1][this.y + 2].getCor() != cor
				|| campo[this.x + 1][this.y - 2].getClass() == Cavalo.class
						&& campo[this.x + 1][this.y - 2].getCor() != cor
				|| campo[this.x + 1][this.y + 2].getClass() == Cavalo.class
						&& campo[this.x + 1][this.y + 2].getCor() != cor) {
			muv = true;
		}
		return muv;
	}

	public boolean bispo(Campo[][] campo, boolean cor) {
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
	public boolean  direcoes(Campo[][] campo, boolean cor,int i,int j, Campo p) {
		boolean muv = false;
		int m1=0,M=0,s1=0,S=0;
		if(i<0) {
			m1=7;
			s1=-1;
		}
		else if(i==0) {
			s1=0;
		}else {
			m1=0;
			s1=1;
		}
		
		if(j<0) {
			M=7;
			S=-1;
		}
		else if(j==0) {
			S=0;
		}else {
			M=7;
			S=1;
		}
		
		do {
			if (campo[x+i][y + j].getClass() == p.getClass() && campo[x + i][y + j].getCor() != cor) {
				muv = true;
			}
			i+=s1;
			j+=S;
		} while (x + i <=m1 && i!=0 || y + j <=M && j!=0|| campo[x + i][y + j].getPeca() == true || muv==true);
		return muv;
		}
}
