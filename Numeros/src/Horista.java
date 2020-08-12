
public class Horista extends Funcionario {
	int horasTrabalhadas;
	double valorHora;
	
	double calculaSalario() {
		return horasTrabalhadas * valorHora;
	}
 }
