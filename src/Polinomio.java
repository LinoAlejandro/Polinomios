import java.util.ArrayList;

public class Polinomio {
	private Monomio inicio;

	public Polinomio() {
		this.inicio = null;
	}
	public Monomio getInicio() {
		return inicio;
	}

	public void setInicio(Monomio inicio) {
		this.inicio = inicio;
	}
	
	public void simplificar() {
		Monomio aux = this.inicio;
		
		while(aux != null){
			Monomio aux2 = aux.getSiguiente();
			while(aux2 != null){
				
				if(aux.getExponente() == aux2.getExponente()){
					
					aux.setCoeficiente(aux.getCoeficiente() + aux2.getCoeficiente());
					this.eliminar(aux2);
				}
				aux2 = aux2.getSiguiente();
			}
			
			if(aux.getCoeficiente() == 0){
				this.eliminar(aux);
			}
			
			aux = aux.getSiguiente();
		}
	}
	
	public Polinomio sumar(Polinomio polinomio) {
		Polinomio polinomioAuxiliar = new Polinomio();
		Monomio aux = this.getInicio();
		
		while(aux != null){
			polinomioAuxiliar.insertarI(aux.getCoeficiente(), aux.getExponente());
			aux= aux.getSiguiente();
		}
		
		polinomio.simplificar();
		aux = polinomio.getInicio();
		while(aux != null) {
			polinomioAuxiliar.insertarI(aux.getCoeficiente(), aux.getExponente());
			aux = aux.getSiguiente();
		}
		polinomioAuxiliar.ordenarPolinomio();
		return polinomioAuxiliar;
	}
	
	//se le ingresa el sustraendo
	public Polinomio restar(Polinomio polinomio) {
		this.simplificar();
		
		Polinomio polinomioAuxiliar = new Polinomio();
		Monomio aux = this.getInicio();
		
		while(aux != null){
			polinomioAuxiliar.insertarI(aux.getCoeficiente(), aux.getExponente());
			aux = aux.getSiguiente();
		}
		
		polinomio.simplificar();
		aux = polinomio.getInicio();
		
		while(aux != null) {
			polinomioAuxiliar.insertarI((aux.getCoeficiente()*(-1)), aux.getExponente());
			aux = aux.getSiguiente();
		}
		
		polinomioAuxiliar.ordenarPolinomio();
		return polinomioAuxiliar;
		
	}
	
	//eliminar por posicion
	public void eliminar(int posicion) {
		if(this.inicio != null){
			Monomio aux = this.inicio;
			Monomio ant = null;
			int c = 0;
			while(c < posicion && aux != null){
				c++;
				ant = aux;
				aux = aux.getSiguiente();
			}
			if(aux == null){
				System.out.println("Fuera de rango");
			} else {
				if(ant == null){
					this.setInicio(this.getInicio().getSiguiente());
				}else {
					ant.setSiguiente(aux.getSiguiente());
				}
			}
		}
	}
	
	public void insertarI(Double coeficiente, int exponente) {
		Monomio monomio = new Monomio(coeficiente, exponente);
		if(inicio == null){
			this.setInicio(monomio);
		} else {
			monomio.setSiguiente(inicio);
			this.setInicio(monomio);
		}
	}

	//eliminar por monomio
	public void eliminar(Monomio monomio) {
		if(this.inicio != null){
			Monomio aux = this.inicio;
			Monomio ant = null;
			while(aux != null && ((monomio.compareTo(aux)) != 0) ){
				ant = aux;
				aux = aux.getSiguiente();
			}
			if(ant == null){
				if(aux.getSiguiente() != null){
					this.setInicio(aux.getSiguiente());
				} else {
					this.setInicio(this.getInicio().getSiguiente());
				}
			} else {
				if(aux == null){
					System.out.println("Monomio inexistente");
				} else {
					ant.setSiguiente(aux.getSiguiente());
				}
			}
		} else {
			System.out.println("Lista vacia");
		}
	}
	
	public String toString() {
		Monomio aux = this.getInicio();
		String cadena = "";
		while(aux != null){
			//impresion del exponente
			String auxiliar = "";
			if(aux.getExponente() != 0){
				auxiliar = "x^" + aux.getExponente();
			}
			
			//impresion de los coeficientes
			if(aux.getCoeficiente() >= 0 ){
				cadena = cadena + "+" + aux.getCoeficiente() + auxiliar;
			} else if(aux.getCoeficiente() < 0){
				cadena = cadena + aux.getCoeficiente() + auxiliar;
			} else {
				//do nothing
			}
			aux = aux.getSiguiente();
		}
		return cadena;
	}
	
	//se le ingresa de parámetro el multiplicador
	public Polinomio multiplicar(Polinomio polinomio) {
		Polinomio polinomioAux = new Polinomio();
		Monomio aux = polinomio.getInicio();
		Monomio aux2;
		
		while(aux != null){
			aux2 = this.getInicio();
			while(aux2 != null){
				Double coeficiente = aux.getCoeficiente() * aux2.getCoeficiente();
				int exponente = aux.getExponente() + aux2.getExponente();
				polinomioAux.insertarI(coeficiente, exponente);
				
				aux2 = aux2.getSiguiente();
			}
			aux = aux.getSiguiente();
		}
		polinomioAux.ordenarPolinomio();
		return polinomioAux;
		
	}
	
	//se ingresa el divisor
	public ArrayList<Polinomio>  dividir(Polinomio divisor) {
		Polinomio residuo = new Polinomio();
		
		Monomio recorrer = this.getInicio();
		
		while(recorrer != null){
			residuo.insertarI(recorrer.getCoeficiente(), recorrer.getExponente());
			recorrer = recorrer.getSiguiente();
		}
		
		residuo.ordenarPolinomio();
		divisor.ordenarPolinomio();
		
		Polinomio cociente = new Polinomio();
		Monomio divisorAux = divisor.getInicio();
		
		while((residuo.getInicio() != null) && (divisorAux.getExponente() <= residuo.getInicio().getExponente())){
			
			Polinomio temporal = new Polinomio();
			
			Double coeficienteCociente = residuo.getInicio().getCoeficiente() / divisorAux.getCoeficiente();
			int exponenteCociente = residuo.getInicio().getExponente() - divisorAux.getExponente();

			cociente.insertarI(coeficienteCociente, exponenteCociente);
			
			Monomio auxTransferencia = divisor.getInicio();
			while(auxTransferencia != null){
				
				temporal.insertarI(auxTransferencia.getCoeficiente() * coeficienteCociente, auxTransferencia.getExponente() + exponenteCociente);
				auxTransferencia = auxTransferencia.getSiguiente();
			}
			
			residuo.setInicio(residuo.restar(temporal).getInicio());
			temporal.setInicio(null);
		}
		
		cociente.ordenarPolinomio();
		residuo.ordenarPolinomio();
		
		ArrayList<Polinomio> polinomios = new ArrayList<Polinomio>();
		polinomios.add(cociente);
		polinomios.add(residuo);
		
		return polinomios;
	}
	
	
	public Monomio monomioAt(int posicion) {
		Monomio aux = this.getInicio();
		int contador = 1;
		while(aux != null && contador < posicion) {
			contador++;
			aux = aux.getSiguiente();
		}
		return aux;
	}
	
	public int count() {
		Monomio aux = this.getInicio();
		int contador = 0;
		while(aux != null){
			contador++;
			aux = aux.getSiguiente();
		}
		return contador;
	}
	
	public void ordenarPolinomio() {
		this.simplificar();
		Monomio aux = this.getInicio();
		
		while(aux != null) {
			Monomio aux2 = aux.getSiguiente();
			while(aux2 != null){
				if(aux.getExponente() < aux2.getExponente()){
					int exponente = aux.getExponente();
					Double coeficiente = aux.getCoeficiente();
					
					aux.setExponente(aux2.getExponente());
					aux.setCoeficiente(aux2.getCoeficiente());
					
					aux2.setExponente(exponente);
					aux2.setCoeficiente(coeficiente);
				}
				aux2 = aux2.getSiguiente();
			}
			aux = aux.getSiguiente();
		}
	}
	
	//devuelve el arreglo de raices que resuelven el polinomio
	public Lista resolver() {
		this.ordenarPolinomio();
		this.rellenar();
		Lista resultados = null;
		
		if(this.monomioAt(this.count()).getExponente() == 0){
			resultados = this.metodoRufini();
			return resultados;
		} else {
			Polinomio polinomio = new Polinomio();
			polinomio.insertarI(1.0, this.monomioAt(this.count()).getExponente());
			this.setInicio(this.dividir(polinomio).get(0).getInicio());
			this.rellenar();
			
			resultados = this.metodoRufini();
			
			return resultados;
		}
	}
	
	public Lista metodoRufini(){
		Lista resultados = new Lista();
		//ultimo coeficiente del polinomio
		Double coeficienteCero = this.monomioAt(this.count()).getCoeficiente();
		//lista con posibles soluciones
		Lista dividendos = new Lista();
		dividendos.obtenerDivisores(coeficienteCero.intValue());
		Nodo aux = dividendos.getInicio();
		//recorrido de las posibles soluciones
		while(aux != null){
			//lista auxiliar de operaciones
			Lista operaciones = new Lista();
			Monomio nodoTransferencia = this.getInicio();
			//transferencia de coeficientes
			while(nodoTransferencia != null){
				operaciones.insertarF(nodoTransferencia.getCoeficiente());
				nodoTransferencia = nodoTransferencia.getSiguiente();
			}
			//procedimiento ruffini
			Nodo recorrido = operaciones.getInicio();
			Double acumulado = recorrido.getDato();
			for(int c = 0; c < operaciones.count() - 1; c++){
				acumulado = (acumulado * aux.getDato()) + recorrido.getSiguiente().getDato();
				recorrido = recorrido.getSiguiente();
			}
			if(acumulado == 0){
				resultados.insertarI(aux.getDato());
			}
			aux = aux.getSiguiente();
		}
		return resultados;
	}
	
	public void rellenar() {
		this.ordenarPolinomio();
		if(this.getInicio() != null){
			
			Monomio aux = this.getInicio();
			Monomio ant = null;
			int exponente = aux.getExponente();
			
			while(exponente > 0) {  
				Monomio aux2 = new Monomio(0.0, exponente);
				if(aux == null){
					aux2.setSiguiente(aux);
					ant.setSiguiente(aux2);
					aux = aux2;
				} else {
					if(exponente == aux.getExponente()){
						
					} else {
						aux2.setSiguiente(aux);
						ant.setSiguiente(aux2);
						aux = aux2;
					}
				}
				
				exponente--;
				ant = aux;
				aux = aux.getSiguiente();
			}
		}
	}
}
