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
	
	//Verifica se um movimento na matriz campo eh possivel, partindo das coordenadas atuais e indo pra x e y
	boolean verificaMovimento(Campo[][] campo, int x, int y) {
		//Eh impossivel mover um campo vazio, entao retornamos falso
		return false;		
	}
}