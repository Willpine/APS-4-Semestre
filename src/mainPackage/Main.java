package mainPackage;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		//Instancia e inicializa a classe de ler a tabela excel
		ReadSheet readSheet = new ReadSheet();
		
		//Chama o método para ler a tabela excel
		readSheet.readEverything();
	}

}
