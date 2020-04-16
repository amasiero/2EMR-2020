
public class TesteReferencia {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.saldo = 30;
		
		Conta novaConta = conta;
		System.out.println(novaConta.saldo);
		
		novaConta.saldo = 50;
		System.out.println(conta.saldo);
		
		System.out.println(conta);
		System.out.println(novaConta);
		System.out.println(conta == novaConta);

	}

}
