public class Peao extends Campo {
	
	Peao (int x, int y, boolean corPreta) {
		super(x, y);
		this.corPreta = corPreta;
	}
	
	public void mostrarCampo() {
		if (corPreta == true)
			System.out.print("P ");
		else
			System.out.print("p ");
	}
}