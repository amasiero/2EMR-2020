import java.util.Random;

class Jogo {

	int numeroSecreto;
	int nivel;
	int tentativa;
	int maximoTentativas;
	
	void geraNumeroSecreto() {
		numeroSecreto = new Random().nextInt(101);
	}
	
	int defineNivel(int nivel) {
		switch(nivel) {
			case 1:
				maximoTentativas = 20;
				break;
			case 2:
				maximoTentativas = 10;
				break;
			case 3:
				maximoTentativas = 5;
				break;
			default:
				maximoTentativas = 20;
				break;
		}
		return maximoTentativas;
	}
	
	boolean acertou(int numeroInformado) {
		return numeroSecreto == numeroInformado;
	}
	
	boolean ehMaior(int numeroInformado) {
		return numeroSecreto > numeroInformado;
	}
	
	boolean ehMenor(int numeroInformado) {
		return numeroSecreto < numeroInformado;
	}

}





