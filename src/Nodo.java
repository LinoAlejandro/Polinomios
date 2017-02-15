
public class Nodo {
	private Nodo siguiente;
	private Double dato;
	
	public Nodo(Double dato){
		this.setDato(dato);
		this.siguiente = null;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public Double getDato() {
		return dato;
	}

	public void setDato(Double dato) {
		this.dato = dato;
	}
}

