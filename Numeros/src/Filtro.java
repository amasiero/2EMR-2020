import java.util.List;
import java.util.function.Consumer;

public class Filtro implements Consumer<Integer> {

	private Predicado regra;
	private List<Integer> listaFiltrada;
	
	public Filtro(List<Integer> listaFiltrada, Predicado regra) {
		this.listaFiltrada = listaFiltrada;
		this.regra = regra;
	}
	
	@Override
	public void accept(Integer numero) {
		if(regra.valida(numero)) {
			listaFiltrada.add(numero);
		}
	}

}
