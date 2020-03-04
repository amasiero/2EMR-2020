// Configuracao do PATH no prompt de comando
// path %path%;C:\Program Files\Java\jdk1.8.0_212\bin

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		System.out.println("********************");
		System.out.println(" Jogo da Advinhacao ");
		System.out.println("********************");

		int numeroSecreto = 42;

		System.out.printf("O numero secreto eh %d\n", numeroSecreto);
		
		Scanner entrada = new Scanner(System.in);
		
		
		int tentativa = 1;
		int maximoTentativas = 3;

		while(tentativa <= maximoTentativas) {
			System.out.printf("Tentativa %d de %d.\n", tentativa, maximoTentativas);
			System.out.print("Informe um numero inteiro (entre 0 e 100): ");
			int numeroInformado = entrada.nextInt();
	
			boolean acertou = numeroSecreto == numeroInformado;

			if(acertou) {
				System.out.println("Parabens! Voce acertou!");
				break;
			} else {
				System.out.println("Errrrooooooooooou!");			
			}

			tentativa++;
		}
	} 
}