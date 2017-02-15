
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polinomio polinomio = new Polinomio();

		polinomio.insertarI(1.0,3);
		polinomio.insertarI(-7.0,1);
		polinomio.insertarI(6.0,0);

		Polinomio polinomio2 = new Polinomio();
		
		polinomio2.insertarI(1.0,1);
		polinomio2.insertarI(-3.0,0);

		//polinomio.sumar(polinomio2);
		//polinomio.restar(polinomio2);
		//polinomio.multiplicar(polinomio2);
		//System.out.println(polinomio.dividir(polinomio2).toString());
		//System.out.println(polinomio.toString());
		/*
		Polinomio polinomio3 = new Polinomio();
		
		/*
		polinomio3.insertarI(1.0, 4);
		polinomio3.insertarI(-1.0, 3);
		polinomio3.insertarI(-1.0, 2);
		polinomio3.insertarI(1.0, 1);
		
		polinomio3.insertarI(1.0, 4);
		polinomio3.insertarI((1.0/3.0), 2);
		polinomio3.insertarI((1.0/36.0), 0);
		*/
		
		
		Polinomio cociente = polinomio.dividir(polinomio2).get(0);
		Polinomio residuo = polinomio.dividir(polinomio2).get(1);
		System.out.println(cociente.toString());
		System.out.println(residuo.toString());
		
		Polinomio resultado = polinomio.multiplicar(polinomio2);
		System.out.println(resultado.toString());
		
		System.out.println(polinomio.toString());
		Lista resolver = polinomio.resolver();
		System.out.println(resolver.toString());
		//Polinomio polinomio4 = new Polinomio();
		//polinomio.insertarI(1.0, 1);
		
		//Lista resultados = polinomio3.resolver();
		
		//System.out.println(resultados.toString());
		/*
		Monomio aux = polinomio3.getInicio();
		while(aux != null){
			System.out.println(aux.getCoeficiente() + " " + aux.getExponente());
			aux = aux.getSiguiente();
		}
		*/
		
		
	}
}
