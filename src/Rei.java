public class Rei extends Campo {
	
	Rei (int x, int y, boolean corPreta) {
		super(x, y);
		this.corPreta = corPreta;
	}
	
	public void mostrarCampo() {
		if (corPreta == true)
			System.out.print("K ");
		else
			System.out.print("k ");
	}
	//o rei pode se mover apenas uma casa em todas as direções
	boolean verificaMovimento(Campo[][] campo, int x, int y) {
		boolean muv=false;
		if(x==this.x+1 || x==this.x-1 ) {
			if(y==this.y-1 || y==this.y || y==this.y+1 ) {
				muv=true;
			}
		}
		if(x==this.x) {
			if(y==this.y-1 || y==this.y+1 ) {
				muv=true;
			}
		}
		return muv;
	}
}