public class Campo {
	protected int x;
	protected int y;
	protected boolean corPreta; //Representa a cor das pecas herdeiras. Inicializa como false para os campos vazios
	
	public Campo (int x, int y) {
		this.x = x;
		this.y = y;
		corPreta = false;
	}
	
	//Atualiza as coordenadas do campo
	public void setCoord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//Envia a cor da peca nesse campo
	public boolean getCor() {
		return corPreta;
	}	
	
	//Imprime a peca referente a tal classe que chamou mostrarCampo()
	public void mostrarCampo() {
		System.out.print("- ");
	}
}
