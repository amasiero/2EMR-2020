
public class MultiplosDeTres implements Predicado {

	@Override
	public boolean valida(Integer numero) {
		return numero % 3 == 0;
	}

}
