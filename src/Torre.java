public class Torre extends Campo {	
	
	Torre (int x, int y, boolean corPreta) {
		super(x, y);
		this.corPreta = corPreta;
	}
	
	public void mostrarCampo() {
		if (corPreta == true)
			System.out.print("T ");
		else
			System.out.print("t ");
	}
}