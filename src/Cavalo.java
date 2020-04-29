public class Cavalo extends Campo {
	
	Cavalo (int x, int y, boolean corPreta) {
		super(x, y);
		this.corPreta = corPreta;
	}
	
	public void mostrarCampo() {
		if (corPreta == true)
			System.out.print("H ");
		else
			System.out.print("h ");
	}
}