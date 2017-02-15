public class Lista {
	private Nodo inicio;

	public Lista(){
	}
	
	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}
	
	public void insertarI(Double dato){
		Nodo nuevo = new Nodo(dato);
		if(isVacia()){
			inicio = nuevo;
		} else {
			nuevo.setSiguiente(inicio);
			inicio = nuevo;
		}
	}
	
	public void insertarF(Double double1){
		Nodo nuevo = new Nodo(double1);
		if(isVacia()){
			inicio = nuevo;
		} else {
			Nodo aux = inicio;
			while(aux.getSiguiente() != null){
				aux = aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
		}
	}
	
	public void insertarOrdenado(Double dato){
		Nodo nuevo = new Nodo(dato);
		if(isVacia()){
			inicio = nuevo;
		} else {
			Nodo aux = null;
			Nodo aux2 = inicio;
			while(aux2 != null && aux2.getDato() > nuevo.getDato()){
				aux = aux2;
				aux2 = aux2.getSiguiente();
			}
			if(aux == null){
				nuevo.setSiguiente(inicio);
				inicio = nuevo;
			} else {
				aux.setSiguiente(nuevo);
				nuevo.setSiguiente(aux2);
			}
		}
	}
	
	public void recorrerLista(){
		if(isVacia()){
			System.out.println("Lista Vacia");
		} else {
			Nodo aux = inicio;
			while(aux != null){
				System.out.println(aux.getDato());
				aux = aux.getSiguiente();
			}
		}
	}
	
	public boolean isVacia(){
		return inicio == null;
	}
	
	public void ordenarBurbuja(){
		Nodo aux = inicio;
		while(aux != null){
			Nodo aux2 = aux.getSiguiente();
			while(aux2 != null){
				if(aux.getDato() > aux2.getDato()){
					
					Double intAux = aux2.getDato();
					aux2.setDato(aux.getDato());
					aux.setDato(intAux);
				}
				aux2 = aux2.getSiguiente();
			}
			aux = aux.getSiguiente();
		}
	}
	
	public void ordenarRadix(){
		
		int cantidadCiclos = String.valueOf(obtenerMayor()).length();
		Lista lista0 = new Lista();
		Lista lista1 = new Lista();
		Lista lista2 = new Lista();
		Lista lista3 = new Lista();
		Lista lista4 = new Lista();
		Lista lista5 = new Lista();
		Lista lista6 = new Lista();
		Lista lista7 = new Lista();
		Lista lista8 = new Lista();
		Lista lista9 = new Lista();
		
		for (int i = 0; i < cantidadCiclos; i++) {
			Nodo aux = this.inicio;
			while(aux != null){
				String valor = String.valueOf(aux.getDato());
				if(valor.length() > i){
					char identificador = valor.charAt(valor.length() - (i + 1));
					switch (identificador) {
					case '0':
						lista0.insertarI(aux.getDato());
						break;
					
					case '1':
						lista1.insertarI(aux.getDato());
						break;
						
					case '2':
						lista2.insertarI(aux.getDato());
						break;
						
					case '3':
						lista3.insertarI(aux.getDato());
						break;
						
					case '4':
						lista4.insertarI(aux.getDato());
						break;
						
					case '5':
						lista5.insertarI(aux.getDato());
						break;

					case '6':
						lista6.insertarI(aux.getDato());
						break;
						
					case '7':
						lista7.insertarI(aux.getDato());
						break;
						
					case '8':
						lista8.insertarI(aux.getDato());
						break;
						
					case '9':
						lista9.insertarI(aux.getDato());
						break;

					default:
						break;
					}
					
				} else {
					lista0.insertarI(aux.getDato());
				}	
				aux = aux.getSiguiente();
			}
			
			this.setInicio(null);
			
			Nodo aux2 = lista0.inicio;
			while(aux2 != null){
				this.insertarI(aux2.getDato());
				aux2 = aux2.getSiguiente();
			}
			lista0.setInicio(null);
			
			aux2 = lista1.inicio;
			while(aux2 != null){
				this.insertarI(aux2.getDato());
				aux2 = aux2.getSiguiente();
			}
			lista1.setInicio(null);
			
			aux2 = lista2.inicio;
			while(aux2 != null){
				this.insertarI(aux2.getDato());
				aux2 = aux2.getSiguiente();
			}
			lista2.setInicio(null);
			
			aux2 = lista3.inicio;
			while(aux2 != null){
				this.insertarI(aux2.getDato());
				aux2 = aux2.getSiguiente();
			}
			lista3.setInicio(null);
			
			aux2 = lista4.inicio;
			while(aux2 != null){
				this.insertarI(aux2.getDato());
				aux2 = aux2.getSiguiente();
			}
			lista4.setInicio(null);
			
			aux2 = lista5.inicio;
			while(aux2 != null){
				this.insertarI(aux2.getDato());
				aux2 = aux2.getSiguiente();
			}
			lista5.setInicio(null);
			
			aux2 = lista6.inicio;
			while(aux2 != null){
				this.insertarI(aux2.getDato());
				aux2 = aux2.getSiguiente();
			}
			lista6.setInicio(null);
			
			aux2 = lista7.inicio;
			while(aux2 != null){
				this.insertarI(aux2.getDato());
				aux2 = aux2.getSiguiente();
			}
			lista7.setInicio(null);

			aux2 = lista8.inicio;
			while(aux2 != null){
				this.insertarI(aux2.getDato());
				aux2 = aux2.getSiguiente();
			}
			lista8.setInicio(null);
			
			aux2 = lista9.inicio;
			while(aux2 != null){
				this.insertarI(aux2.getDato());
				aux2 = aux2.getSiguiente();
			}
			lista9.setInicio(null);
			
		}
		
		this.invertirLista();
	}
	
	public void insertarAleatoriamente(int numeroMayor, int numeroMenor, int cantidad){
		Double numero = 0.0;
		for (int i = 0; i < cantidad; i++) {
			numero = (Math.random()*numeroMayor) + numeroMenor;
			this.insertarI(numero);
		}
	}
	
	public String toString(){
		String contenido = "";
		Nodo aux = inicio;
		while(aux != null){
			contenido = contenido + " " + aux.getDato();
			aux = aux.getSiguiente();
		}
		return contenido;
	}
	
	public Double obtenerMayor(){
		Double mayor = 0.0;
		Nodo aux = inicio;
		while(aux != null){
			if(aux.getDato() > mayor){
				mayor = aux.getDato();
			}
			aux = aux.getSiguiente();
		}
		return mayor;
	}
	
	public String imprimirmMuestra(int tamanoMuestra){
		Nodo aux = inicio;
		int c = 0;
		String valores = "";
		while(aux != null && c < tamanoMuestra){
			valores = valores + " " + aux.getDato(); 
			c++;
			aux = aux.getSiguiente();
		}
		
		return valores;
	}
	
	public void invertirLista(){
		Nodo aux = inicio;
		this.inicio = null;
		while(aux != null){
			this.insertarI(aux.getDato());
			aux = aux.getSiguiente();
		}
	}
	
	public void obtenerDivisores(int numero) {
		if(numero < 0){
			numero = numero * - 1;
		}
		Double contador = 1.0;
		while(contador <= numero) {
			if((numero % contador) == 0) {
				this.insertarI(contador);
				this.insertarI(contador * -1);
			}
			contador++;
		}
	}
	
	public int count(){
		Nodo aux = this.getInicio();
		int contador = 0;
		while(aux != null){
			contador++;
			aux = aux.getSiguiente();
		}
		return contador;
	}
}
