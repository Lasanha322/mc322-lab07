public class Cavalo extends Campo {
	
	Cavalo (int x, int y, boolean corPreta) {
		super(x, y);
		this.corPreta = corPreta;
		peca=true;
	}
	
	//Imprime um cavalo no console
	public void mostrarCampo() {
		if (corPreta == true)
			System.out.print("H ");
		else
			System.out.print("h ");
	}
	
	//Verifica a validade do movimento do cavalo
	public boolean verificaMovimento(Campo[][] campo, int x, int y) {
		boolean muv=false;
		
		if ((campo[x][y].corPreta != corPreta && campo[x][y].getPeca()== true) 
			|| campo[x][y].getPeca()== false) {			
			if ((x == this.x-2 || x == this.x+2)
				&& (y==this.y-1 || y==this.y+1))				
				muv=true;
			
			if ((x == this.x-1 || x == this.x+1)
				&& (y==this.y+2 || y==this.y-2))			
				muv=true;
		}
		
		return muv;
	}
}