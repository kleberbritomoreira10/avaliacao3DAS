package Cadastros;

public class Viagem {
	
	Duracao duracao = new Duracao();
	
	private Viagem(int hora, int minutos) {
		duracao.horaInicio = hora;
		duracao.minutosInicio = minutos;
	}

	protected static Viagem obterViagem(int hora, int minutos) {
		Viagem v = new Viagem (hora, minutos);
		return v;
	}

	public int getHoraInicio() {
		return duracao.horaInicio;
	}

	public int getMinutoInicio() {
		return duracao.minutosInicio;
	}

	public void encerrarViagem(int horaTermino, int minutosTermino) {
		duracao.horaTermino = horaTermino;
		duracao.minutosTermino = minutosTermino;
	}

	public int getHoraTermino() {
		return duracao.horaTermino;
	}

	public int getMinutosTermino() {
		return duracao.minutosTermino;
	}

	public int getDuracaoHoras() {
		if (duracao.horaTermino == duracao.horaInicio)
			duracao.duracaoHoras = 0;
		if (duracao.horaTermino > duracao.horaInicio) //varias possibilidades... 
			if (duracao.horaTermino == duracao.horaInicio + 1) {  
				if (duracao.minutosTermino < duracao.minutosInicio)  //nao chegou a uma hora
					duracao.duracaoHoras = 0;
				else //durou pelo menos uma hora
					duracao.duracaoHoras = 1;
			} else { //possivelmente ultrapassou duas horas
				if (duracao.horaTermino - duracao.horaInicio > 2) //
					duracao.duracaoHoras = duracao.horaTermino - duracao.horaInicio;
				else if (duracao.horaTermino - duracao.horaInicio == 2 &&   //certamente menos de duas horas  
						duracao.minutosTermino < duracao.minutosInicio)    //e mais de uma hora
					duracao.duracaoHoras = 1;
				else //duracao de duas horas, certamente
					duracao.duracaoHoras = 2;
					
			}
		if (duracao.horaTermino < duracao.horaInicio) 
			duracao.duracaoHoras = -1; //para casos em que a hora de termino nao foi registrada
		return duracao.duracaoHoras;
	}

	public int getDuracaoMinutos() {
		if (duracao.minutosTermino > duracao.minutosInicio) 
			duracao.duracaoMinutos = duracao.minutosTermino - duracao.minutosInicio;
		else {
			duracao.duracaoMinutos = 60 - duracao.minutosInicio + duracao.minutosTermino;
			if (duracao.duracaoMinutos == 60) //caso especial
				duracao.duracaoMinutos = 0;
		}
		return duracao.duracaoMinutos;
	}

	public int getDuracaoTotalMinutos() {
		duracao.duracaoTotalMinutos = getDuracaoHoras() * 60 + getDuracaoMinutos();
		return duracao.duracaoTotalMinutos;
	}

}
