public class Bispo extends Campo {	
	
	Bispo (int x, int y, boolean corPreta) {
		super(x, y);
		this.corPreta = corPreta;
	}
	
	public void mostrarCampo() {
		if (corPreta == true)
			System.out.print("B ");
		else
			System.out.print("b ");
	}
}