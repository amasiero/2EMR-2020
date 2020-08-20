import java.util.function.Consumer;

public class ShowNumbers implements Consumer<Integer>{

	@Override
	public void accept(Integer number) {
		System.out.printf("%d ", number);		
	}

}
