package br.com.fiap.pousada;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.pousada.dao.QuartoDAO;
import br.com.fiap.pousada.domain.Categoria;
import br.com.fiap.pousada.domain.Pousada;
import br.com.fiap.pousada.domain.Quarto;
import br.com.fiap.pousada.domain.Reserva;
import br.com.fiap.pousada.exception.FileException;
import br.com.fiap.pousada.exception.ReservaDaoException;
import br.com.fiap.pousada.exception.ReservaException;
import br.com.fiap.pousada.helper.DateHelper;

public class Main {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			Pousada pousada = new Pousada();
			pousada.atualiza();
			int opcao = 0;
			do {
				menu();
				System.out.print("> ");
				opcao = scan.nextInt();

				switch (opcao) { // Java 14
				case 1 -> cadastraQuarto(scan);
				case 2 -> cadastraReserva(scan, pousada);
				case 3 -> consultaQuartos();
				case 4 -> consultaReservas(pousada);
				}

				System.out.println("\n\n");
			} while (opcao != 0);

			System.out.println("#--- Programa finalizado com sucesso ---#");
		} catch (ReservaDaoException e) {
			System.err.println(e.getMessage());
		}

	}

	private static void cadastraReserva(Scanner scan, Pousada pousada) throws ReservaDaoException {
		System.out.println("\n#---> Cadastro de Reserva");

		System.out.print("\nInforme o número do quarto: > ");
		Integer numero = scan.nextInt();
		scan.nextLine();

		System.out.print("\nInforme a data de chegada: > ");
		LocalDate dataEntrada = DateHelper.toLocalDate(scan.nextLine());

		System.out.print("\nInforme a data de saida: > ");
		LocalDate dataSaida = DateHelper.toLocalDate(scan.nextLine());

		System.out.print("\nInforme a quantidade de pessoas: > ");
		Integer qtdePessoas = scan.nextInt();

		try {

			Quarto quarto = new QuartoDAO().consultaPorNumero(numero);

			if (quarto == null) {
				System.err.println("\nO quarto informado não existe no cadastro.");
				return;
			}

			Reserva reserva = new Reserva(quarto, dataEntrada, dataSaida, qtdePessoas);
			pousada.efetuaReserva(reserva);

		} catch (ClassNotFoundException | SQLException | ReservaException | FileException e) {
			System.err.println(e.getMessage());
		}

		System.out.println("\nReserva realizada com sucesso #---> ");
	}

	private static void consultaReservas(Pousada pousada) {
		List<Reserva> reservas = pousada.getReservas();
		reservas.forEach(System.out::println);
	}

	private static void consultaQuartos() {
		System.out.println("\n#---> Consulta Quartos\n");

		try {
			List<Quarto> quartos = new QuartoDAO().consultaTodos();
			quartos.forEach(System.out::println); // A partir do Java 8
		} catch (ClassNotFoundException | SQLException | FileException e) {
			System.err.println(e.getMessage());
		}

		System.out.println("\nConsulta finalizada com sucesso #---> ");
	}

	private static void cadastraQuarto(Scanner scan) {
		System.out.println("\n#---> Cadastro de Quarto");

		System.out.print("\nInforme o número do quarto: > ");
		Integer numero = scan.nextInt();

		System.out.println("\nInforme a cartegoria do quarto.");
		System.out.print("Digite: 1 - VIP | 2 - Apartamento > ");
		Categoria categoria = scan.nextInt() == 1 ? Categoria.VIP : Categoria.APARTAMENTO;

		System.out.print("\nInforme a capacidade máxima do quarto: > ");
		Integer maxPessoas = scan.nextInt();

		System.out.print("\nInforme o valor da diária do quarto: > ");
		Double valorDiaria = scan.nextDouble();

		Quarto quarto = new Quarto(numero, categoria, maxPessoas, valorDiaria);

		try {
			new QuartoDAO().salva(quarto);
		} catch (ClassNotFoundException | SQLException | FileException e) {
			System.err.println(e.getMessage());
		}

		System.out.println("\nQuarto cadastrado com sucesso #---> ");
	}

	private static void menu() {
		System.out.println("|-----------------------------|");
		System.out.println("|          POUSADA            |");
		System.out.println("|                             |");
		System.out.println("| Digite a opção desejada:    |");
		System.out.println("| 1 - Cadastrar quarto        |");
		System.out.println("| 2 - Cadastrar reserva       |");
		System.out.println("| 3 - Consultar quartos       |");
		System.out.println("| 4 - Consultar reservas      |");
		System.out.println("| 0 - Sair do sistema         |");
		System.out.println("|-----------------------------|");
	}

}

//switch(opcao) { // até o Java 13
//case 1:
//	System.out.println("Cadastrando um quarto...");
//	break;
//case 2:
//	System.out.println("Cadastrando uma reserva...");
//	break;
//case 3:
//	System.out.println("Consultando quartos...");
//	break;
//case 4:
//	System.out.println("Consultando reservas...");
//	break;
//}
