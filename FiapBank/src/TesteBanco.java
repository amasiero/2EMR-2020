
public class TesteBanco {
	public static void main(String[] args) {
		Conta contaDoJim = new Conta();
		contaDoJim.saldo = 3000;
		contaDoJim.deposita(500);
		System.out.println(contaDoJim.saldo);

		Conta contaDoThiago = new Conta();
		contaDoThiago.deposita(2000);
		boolean sacou = contaDoThiago.saca(500);
		if (sacou) {
			System.out.println("Saque efetuado com sucesso.");
		} else {
			System.out.println("Saldo insuficiente.");
		}

		if (contaDoJim.transfere(2000, contaDoThiago)) {
			System.out.println("Transferência efetuada com sucesso.");
		} else {
			System.out.println("Saldo insuficiente.");
		}
		System.out.println("Saldo do Jim: " + contaDoJim.saldo);
		System.out.println("Saldo do Thiago: " +contaDoThiago.saldo);

	}
}
