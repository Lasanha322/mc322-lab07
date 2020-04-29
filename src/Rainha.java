public class Rainha extends Campo {	
	
	Rainha (int x, int y, boolean corPreta) {
		super(x, y);
		this.corPreta = corPreta;
	}
	
	public void mostrarCampo() {
		if (corPreta == true)
			System.out.print("Q ");
		else
			System.out.print("q ");
	}
}