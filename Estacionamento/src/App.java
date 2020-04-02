import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Informe a placa do veiculo: ");
		String placa = scan.nextLine();
		
		System.out.print("Informe a marca do veiculo: ");
		String marca = scan.nextLine();
		
		System.out.print("Informe o modelo do veiculo: ");
		String modelo = scan.nextLine();
		
		Estacionamento estacionamento = new Estacionamento();
		estacionamento.entra(new Veiculo(placa, marca, modelo));
		
		int opcao = 0;
		while(opcao != 1) {
			System.out.print("Pressione 1 para sair com o veiculo: ");
			opcao = scan.nextInt();
			
			if(opcao == 1) {
				estacionamento.sai();
			}
		}
		
		System.out.println(estacionamento.relatorio());
		scan.close();
	}
	 
}
