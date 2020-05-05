public class Rei extends Campo {
	
	Rei (int x, int y, boolean corPreta) {
		super(x, y);
		this.corPreta = corPreta;
		peca=true;
	}
	
	//Imprime o rei no console
	public void mostrarCampo() {
		if (corPreta == true)
			System.out.print("K ");
		else
			System.out.print("k ");
	}
	
	//Verifica a validade do movimento do rei
	public boolean verificaMovimento(Campo[][] campo, int x, int y) {
		boolean muv=false;
		
		if ((x==this.x+1 || x==this.x-1)
			&& (y==this.y-1 || y==this.y || y==this.y+1))
			muv=true;
				
		if (x == this.x
			&& (y == this.y-1 || y == this.y+1))
			muv=true;
		
		return muv;
	}
}