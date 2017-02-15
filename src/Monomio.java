
public class Monomio implements Comparable <Monomio>{
	private Double coeficiente;
	private int exponente;
	private Monomio siguiente;
	
	public Monomio(Double coeficiente, int exponente) {
		this.setCoeficiente(coeficiente);
		this.setExponente(exponente);
		this.siguiente = null;
	}

	public Double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(Double coeficiente) {
		this.coeficiente = coeficiente;
	}

	public int getExponente() {
		return exponente;
	}

	public void setExponente(int exponente) {
		this.exponente = exponente;
	}

	public Monomio getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Monomio siguiente) {
		this.siguiente = siguiente;
	}

	@Override
	public int compareTo(Monomio monomio) {
		if((this.getCoeficiente() == monomio.getCoeficiente())&& (this.getExponente() == monomio.getExponente()) &&
				(this.getSiguiente() == monomio.getSiguiente())){
			return 0;
		} else {
			return 1;
		}
	}
}
