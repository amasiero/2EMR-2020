package br.com.fiap.escola;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.escola.dao.AlunoDAO;
import br.com.fiap.escola.domain.Aluno;

public class Principal {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int opcao = 0;
			do {
				menu();
				System.out.print("> ");
				opcao = scan.nextInt();
				scan.nextLine();
				
//				até Java 13
//				switch(opcao) {
//					case 1:
//						cadastrarAluno();
//						break;
//					case 2:
//						consultarTurma();
//						break;
//				}
				
				// Java 14
				switch(opcao) {
					case 1 -> cadastrarAluno(scan);
					case 2 -> consultarTurma();
					case 3 -> consultarAluno(scan);
				}
				
				System.out.println("\n\n");
			} while(opcao != 0);
			
			System.out.println("Sistema finalizado com sucesso.");
		}

	}

	private static void menu() {
		System.out.println("|-----------------------------|");
		System.out.println("|       ESCOLA D.O.S          |");
		System.out.println("|                             |");
		System.out.println("| Digite a opção desejada:    |");
		System.out.println("| 1 - Cadastrar aluno         |");
		System.out.println("| 2 - Consultar turma         |");
		System.out.println("| 3 - Consultar por RM        |");
		System.out.println("| 0 - Sair do sistema         |");
		System.out.println("|-----------------------------|");
	}

	private static void consultarTurma() {
		System.out.println("|----- Consulta da Turma -----|");
		List<Aluno> alunos = null;
		
		try {
			alunos = new AlunoDAO().consultaTodos();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Listando os alunos...");
		
		if(alunos != null) alunos.forEach(System.out::println);
		
		System.out.println("|------ Fim do Consulta ------|");
	}

	private static void cadastrarAluno(Scanner scan) {
		System.out.println("|----- Cadastro do Aluno -----|");
		
		System.out.print("Digite o RM do aluno: ");
		Long rm = scan.nextLong();
		scan.nextLine();
		
		System.out.print("Digite o nome do aluno: ");
		String nome = scan.nextLine();
		
		System.out.print("Digite o nota 1 do aluno: ");
		double nota1 = scan.nextDouble();
		scan.nextLine();
		
		System.out.print("Digite o nota 2 do aluno: ");
		double nota2 = scan.nextDouble();
		scan.nextLine();
		
		Aluno aluno = new Aluno(rm, nome, true, nota1, nota2);
		
		try {
			new AlunoDAO().salva(aluno);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("|------ Fim do Cadastro ------|");
	}
	
	private static void consultarAluno(Scanner scan) {
		System.out.println("|----- Consulta de Aluno -----|");
		
		Aluno aluno = null;
		
		System.out.print("Digite o RM do aluno a consultar: ");
		Long rm = scan.nextLong();
		scan.nextLine();
		
		try {
			aluno = new AlunoDAO().consultaPorRM(rm);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		if(aluno != null) System.out.println(aluno);
		
		System.out.println("|------ Fim da Consulta ------|");
	}

}

