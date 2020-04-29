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
}