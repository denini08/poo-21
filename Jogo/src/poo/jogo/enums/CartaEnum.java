package poo.jogo.enums;

public enum CartaEnum {
	AS(11),
	DOIS(2),
	TRES(3),
	QUATRO(4),
	CINCO(5),
	SEIS(6),
	SETE(7),
	OITO(8),
	NOVE(9),
	DEZ(10),
	VALETE(10),
	DAMA(10),
	REI(10);
	
	private int valor;
	
	private CartaEnum (int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return this.valor;
	}
	
	public void setValorAs() {
		if (this.valor == 11) {
			this.valor = 1;
		}
	}
}
