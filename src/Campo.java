public class Campo {
	protected int x;// define as coordenadas x,y da matriz de campos
	protected int y;
	protected boolean preta; //false se for branca B, true se for preta P
	protected Comum comum;
	protected Dama dama;
	
	public Campo (int x, int y) {
		this.x = x;
		this.y = y;
		comum = null;
		dama = null;
	}
	//setar as coordenadas x, y
	public void setCoord(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void colocarComum(Comum comum) {
		this.comum = comum;
	}
	
	public Comum getComum() {
		return comum;
	}
	
	public void colocarDama(Dama dama) {
		this.dama = dama;
	}
	
	public Dama getDama() {
		return dama;
	}
	
	
	public boolean getPreta() {
		return preta;
	}
	//retira uma peça do tabuleiro
	public void comerPeca() {
		this.comum = null;
		this.dama = null;
	}
	
	public void mostrarCampo() {
		if (dama != null) {
			if (dama.getPreta() == false) {
				System.out.print("B ");
			} else {
				System.out.print("P ");
			}
		} else if (comum != null){
			if (comum.getPreta() == false) {
				System.out.print("b ");
			} else {
				System.out.print("p ");
			}
		} else {
			System.out.print("- ");
		}
	}
}
