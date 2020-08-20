import java.util.List;
import java.util.function.Consumer;

public class Principal {

	public static void main(String[] args) {
		List<Integer> numbers = getNumbers();
		
		// Programação Imperativa
		// for tradicional
		for(int i = 0; i < numbers.size(); i++) {
			System.out.printf("%d ", numbers.get(i));
		}
		System.out.println();
		
		// for each
		for(Integer number : numbers) {
			System.out.printf("%d ", number);
		}
		System.out.println();
		
		// Programação Declarativa -> Funcional
		ShowNumbers showNumbers = new ShowNumbers();
		numbers.forEach(showNumbers);
		System.out.println();
		
		// Classe Anonima
		Consumer<Integer> consumer = new Consumer<>() {
			@Override
			public void accept(Integer number) {
				System.out.printf("%d ", number);
			}
		};
		numbers.forEach(consumer);
		System.out.println();
		
		
		numbers.forEach(new Consumer<>() {
			@Override
			public void accept(Integer number) {
				System.out.printf("%d ", number);
			}
		});
		System.out.println();
		
		// Lambda Expression 
		numbers.forEach((Integer number)  -> {
			System.out.printf("%d ", number);
		});
		System.out.println();
		
		numbers.forEach(number -> {
			System.out.printf("%d ", number);
		});
		System.out.println();
		
		numbers.forEach(number -> System.out.printf("%d ", number));
		System.out.println();
		
		// Method Reference
		numbers.forEach(System.out::println);
		
	}
	
	public static List<Integer> getNumbers() {
		return List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	}
}
