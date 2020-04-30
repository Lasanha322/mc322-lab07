public class main {
	public static void main(String[] args) {
		Comando cmd = new Comando();
		cmd.setDataSource("src/db/normalGame.csv");
		cmd.executaJogo();
	}
}