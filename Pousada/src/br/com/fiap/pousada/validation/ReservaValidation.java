package br.com.fiap.pousada.validation;

import java.util.List;

import br.com.fiap.pousada.domain.Categoria;
import br.com.fiap.pousada.domain.Reserva;
import br.com.fiap.pousada.exception.ReservaException;
import br.com.fiap.pousada.helper.DateHelper;

public class ReservaValidation {

	private static final Long MAX_QUARTOS_VIP = 5L;
	private static final Long MAX_QUARTOS_APARTAMENTO = 10L;
	
	public static void validaCapaciadadeMaximaDeQuartos(List<Reserva> reservas, Categoria categoria) throws ReservaException {
		if (quantidadeQuartosNaCategoria(reservas, categoria) > MAX_QUARTOS_VIP || 
				quantidadeQuartosNaCategoria(reservas, categoria) > MAX_QUARTOS_APARTAMENTO) {
			throw new ReservaException(
					String.format("Quantidade de quartos da categoria %s n�o est�o dispon�veis.",
							categoria)
			);
		}

	}
	
	private static Long quantidadeQuartosNaCategoria(List<Reserva> reservas, Categoria categoria) {
		return reservas.stream()
				.filter(reserva -> reserva.getQuarto().getCategoria() == categoria)
				.count();
	}

	public static void validaDataEntrada(Reserva reserva) throws ReservaException {
		if(DateHelper.ehAnteriorAtual(reserva.getDataEntrada())) {
			throw new ReservaException("A data de entrada deve ser igual ou maior que a atual.");
		}
	}

	public static void validaDataSaida(Reserva reserva) throws ReservaException {
		if(DateHelper.ehMaiorQueChegada(reserva.getDataEntrada(), reserva.getDataSaida())) {
			throw new ReservaException("A data de saida deve ser no m�nimo dois dias ap�s a entrada.");
		}
		
	}

	public static void validaQuantidadePessoas(Reserva reserva) throws ReservaException {
		if(reserva.getQtdePessoas().compareTo(reserva.getQuarto().getMaxPessoas()) > 0) {
			String msg = String.format("O m�ximo de pessoas permitidas nesse quarto � %s pessoas.", 
					reserva.getQuarto().getMaxPessoas());
			throw new ReservaException(msg);
		}
		
	}
}
