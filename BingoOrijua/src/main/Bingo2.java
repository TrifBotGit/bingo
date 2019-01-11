package main;

public class Bingo2 {
	
	public static void main(String[] args) {
		Carton carton = new Carton();
		
		carton.rellenar();
		carton.mostrarCarton(carton.getCarton());
	}

}
