import java.util.Random;

class Jogo {

	int numeroSecreto;
	int nivel;
	int tentativa;
	int maximoTentativas;
	final int LIMITE_MAXIMO = 100;
	
	void geraNumeroSecreto() {
		numeroSecreto = new Random().nextInt(LIMITE_MAXIMO + 1);
	}
	
	boolean validaIntervalo(int numeroInformado) {
		return numeroInformado < 0 || numeroInformado > LIMITE_MAXIMO;
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
	
	boolean acabouTentativas() {
		return tentativa > maximoTentativas;
	}
	
	void somaTentativa() {
		tentativa++;
	}

}








