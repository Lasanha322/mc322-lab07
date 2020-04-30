public class Peao extends Campo {
	boolean primeiroLance;// true se for o primeiro movimento na partida e false se não for o primeiro moviento
	int fator;//variavel que indica se o peao sobe ou desce, depende da sua cor
	Peao (int x, int y, boolean corPreta) {
		super(x, y);
		this.corPreta = corPreta;
		primeiroLance = true;
		peca=true;
		if(corPreta == true) {
			fator=1;
		}else fator =-1;
	}
	public void mostrarCampo() {
		if (corPreta == true)
			System.out.print("P ");
		else
			System.out.print("p ");
	}
	boolean verificaMovimento(Campo[][] campo, int x, int y) {
		boolean muv;
		if(y==this.y) {
			muv = ParaFrente(campo, x);
		}else {
			muv = ParaLado(campo, x, y);
		}
		primeiroLance=false;
        return muv;
    }
	boolean ParaFrente(Campo[][] campo, int x) {
		boolean muv=false;
		if(campo[this.x+fator][y].getPeca() == false) {
			if(primeiroLance==true && this.x+(2*fator) ==x && campo[this.x+(2*fator)][y].getPeca() == false ) {
				muv=true;
			}
			if(this.x+fator ==x){
				muv=true;
			}
		}
		return muv;
	}
	boolean  ParaLado(Campo[][] campo, int x, int y) {
		boolean muv=false;
		if(this.x+fator == x) {
			if(this.y+1==y || this.y-1==y) {
				if(campo[x][y].getPeca() == true && campo[x][y].getCor()!=corPreta) {
					muv=true;
				}
				else {
					muv=TomadaEnPassant(campo, x, y);
				}
			}
		}
		return muv;
	}
	boolean TomadaEnPassant(Campo[][] campo, int x, int y) {
		boolean muv=false;
		//se  for branca e estiver na fileira 5, verifica se a peça peao adversaria movimentou 2 quadrados no lance anterior
		if(corPreta == false && this.x==3) {
			if(campo[this.x][y].getPeca()==true && campo[this.x][y].corPreta != corPreta) {
				muv=true;
			}
		}
		if(corPreta == true && this.x==4) {
			if(campo[this.x][y].getPeca()==true && campo[this.x][y].corPreta != corPreta) {
				muv=true;
			}
		}
		return muv;
	}
}