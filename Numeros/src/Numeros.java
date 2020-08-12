//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Numeros {

	public List<Integer> filtra(List<Integer> numeros, Predicado regra) {
		return numeros.stream()
				.filter(regra::valida)
				.collect(Collectors.toList());
	}
	
//	public List<Integer> filtra(List<Integer> numeros, Predicado regra) {
//		return numeros.stream()
//				.filter(numero -> regra.valida(numero))
//				.collect(Collectors.toList());
//	}
	
//	public List<Integer> filtra(List<Integer> numeros, Predicado regra) {
//		List<Integer> novaLista = new ArrayList<>();
//
//		// Lambda Expression
//		numeros.forEach(numero -> {
//			if (regra.valida(numero)) {
//				novaLista.add(numero);
//			}
//		});
//
//		return novaLista;
//	}

//	public List<Integer> filtra(List<Integer> numeros, Predicado regra) {
//		List<Integer> novaLista = new ArrayList<>();
//		
//		for(Integer numero : numeros) {
//			if(regra.valida(numero)) {
//				novaLista.add(numero);
//			}
//		}
//		
//		return novaLista;
//	}

//	public List<Integer> pares(List<Integer> numeros) {
//		List<Integer> pares = new ArrayList<>();
//		
//		for(Integer numero: numeros) {
//			if(numero % 2 == 0) {
//				pares.add(numero);
//			}
//		}
//		
//		return pares;
//	}
//	
//	public List<Integer> impares(List<Integer> numeros) {
//		List<Integer> impares = new ArrayList<>();
//		
//		for(Integer numero: numeros) {
//			if(numero % 2 == 1) {
//				impares.add(numero);
//			}
//		}
//		
//		return impares;
//	}

}
