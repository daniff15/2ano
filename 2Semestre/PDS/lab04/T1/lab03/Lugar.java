package lab03;

public abstract class Lugar {
	
	private int fila;
	private int coluna;
	private int reserva = 0;
	
	public Lugar(int fila, int coluna) {
		this.fila = fila;
		this.coluna = coluna;
	}

	/**
	 * Reserva o lugar
	 * @param reserva Número da reserva
	 * @return true se foi possivel reservar, false caso contrário
	 */
	public boolean reservarLugar(int reserva) {
		if (this.reserva != 0)
			return false;
		this.reserva = reserva;
		return true;
	}

	public void anularReserva() {
		reserva = 0;
	}
	
	public int getColuna() {
		return coluna;
	}

	public int getFila() {
		return fila;
	}
	
	public boolean isReservado() {
		return reserva > 0;
	}

	
	public int getReserva() {
		return reserva;
	}

	@Override
	public String toString() {
		return "" + reserva;
	}

}
