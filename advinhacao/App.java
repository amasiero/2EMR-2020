// Configuracao do PATH no prompt de comando
// path %path%;C:\Program Files\Java\jdk1.8.0_212\bin

import java.util.Scanner;
import java.util.Random;

public class App {
	public static void main(String[] args) {
		System.out.println("********************");
		System.out.println(" Jogo da Advinhacao ");
		System.out.println("********************");

		int numeroSecreto = new Random().nextInt(101);

		System.out.printf("O numero secreto eh %d\n", numeroSecreto);
		
		Scanner entrada = new Scanner(System.in);
		
		
		System.out.println("Escolha o nivel de dificuldade:");
		System.out.println("(1) Recruta (2) Pro (3) Survivor");
		System.out.print("Qual o seu nivel? ");
		
		// int tentativa = 1;
		int maximoTentativas = 0;
		
		int nivel = entrada.nextInt();
		
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
				System.out.println("O nivel automatico eh o recruta");
				maximoTentativas = 20;
				break;
		}

		// while(tentativa <= maximoTentativas) {
		for(int tentativa = 1; tentativa <= maximoTentativas; tentativa++) {
			System.out.printf("Tentativa %d de %d.\n", tentativa, maximoTentativas);
			System.out.print("Informe um numero inteiro (entre 0 e 100): ");
			int numeroInformado = entrada.nextInt();
			
			if(numeroInformado < 0 || numeroInformado > 100) {
				System.out.println("O numero informado deve estar entre 0 e 100");
				continue;
			}
	
			boolean acertou = numeroSecreto == numeroInformado;
			boolean maior = numeroSecreto > numeroInformado;
			boolean menor = numeroSecreto < numeroInformado;

			if(acertou) {
				System.out.println("Parabens! Voce acertou!");
				break;
			} else {
				System.out.println("Errrrooooooooooou!");
				if(maior) {
					System.out.println("O seu chute foi menor que o numero secreto.");
				} else if(menor) {
					System.out.println("O seu chute foi maior que o numero secreto.");
				}
			}
			
			//tentativa++;
			//if(tentativa > maximoTentativas) {
			//	System.out.printf("O numero secreto era %d\n", numeroSecreto);
			//}
		}
	} 
}