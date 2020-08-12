
public class Pares implements Predicado {

	@Override
	public boolean valida(Integer numero) {
		return numero % 2 == 0;
	}

}
