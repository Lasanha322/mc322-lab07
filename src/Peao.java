public class Peao extends Campo {
	protected boolean primeiroLance; //true se for o primeiro movimento na partida e false se não for o primeiro movimento
	protected int fator; //variavel que indica se o peao sobe ou desce, em funcao da sua cor
	
	Peao (int x, int y, boolean corPreta) {
		super(x, y);
		this.corPreta = corPreta;
		primeiroLance = true;
		peca = true;
		
		if (corPreta == true)
			fator = 1;
		else 
			fator = -1;
	}
	
	//Imprime um peao no console
	public void mostrarCampo() {
		if (corPreta == true)
			System.out.print("P ");
		else
			System.out.print("p ");
	}
	
	//Verifica a validade do movimento que um peao fez
	public boolean verificaMovimento(Campo[][] campo, int x, int y) {
		boolean muv;
		
		if (y == this.y) {
			muv = ParaFrente(campo, x);
		} else {
			muv = ParaLado(campo, x, y);
		}
		
		primeiroLance = false;
        return muv;
    }
	
	//Verifica se um movimento pra frente eh valido
	public boolean ParaFrente(Campo[][] campo, int x) {
		boolean muv=false;
		
		if (campo[this.x+fator][y].getPeca() == false) {
			if (primeiroLance == true && this.x+(2*fator) == x && campo[this.x+(2*fator)][y].getPeca() == false)
				muv=true;
			if (this.x+fator == x)
				muv=true;
		}
		
		return muv;
	}
	
	//Verifica se um movimento de captura eh valido
	public boolean ParaLado(Campo[][] campo, int x, int y) {
		boolean muv=false;
		
		if (this.x+fator == x
			&& (this.y+1==y || this.y-1==y)
			&& campo[x][y].getPeca() == true 
			&& campo[x][y].getCor() != this.corPreta)
			muv=true;
		
		return muv;
	}
}