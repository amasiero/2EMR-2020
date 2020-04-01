import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String placa = scan.nextLine();
		
		Veiculo veiculo = new Veiculo(placa, "Ferrari", "F458");
		System.out.println(veiculo.getPlaca());
		
		veiculo.setPlaca("DEF-1234");
		System.out.println(veiculo.getPlaca());
		
		scan.close();
	}

}
