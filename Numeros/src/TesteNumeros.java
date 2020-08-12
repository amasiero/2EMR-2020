import java.util.List;
// import java.util.Arrays;

public class TesteNumeros {
	public static void main(String[] args) {
		// Java 8
		// ArrayList<Integer> numeros = 
		// (ArrayList<Integer>) Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		// A partir do java 11
		List<Integer> numeros = 
				List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		Numeros numerosFiltros = new Numeros();
		List<Integer> pares = numerosFiltros.filtra(numeros, new Pares());
		int soma = pares.stream()
				.mapToInt(numero -> numero)
				.sum();
		System.out.println(soma);
		System.out.println(numerosFiltros.filtra(numeros, numero -> numero % 3 == 0));
//		System.out.println(numerosFiltros.filtra(numeros, impares));
		
	}
}
