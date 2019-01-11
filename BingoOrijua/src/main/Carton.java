package main;

import java.util.Random;

public class Carton {
	
	private int columnas;
	private int filas;
	private Random random;
	
	private int[][] carton;
	
	public Carton() {
		columnas = 9;
		filas = 3;
		carton = new int[columnas][filas];
		random = RandomSingleton.getInstance();
	}
	
	public void rellenar() {
		//Todo a 0
		for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                carton[i][j] = 0;
            }
        }
		
		//Números
		for (int i = 0; i < filas; i++) {
			int total = 0;
			int numero;
			int rellenados = 0;
			int columna;
			int fila;
			boolean imprimido = false;
			do {
				numero = random.nextInt(89)+1;
				columna = numero / 10;
				if(numero==90) {
					if(carton[columnas-1][filas-1]==0) {
						carton[columnas-1][filas-1]=90;
					}
				}else{
					//carton[columna][0]=numero;
					rellenados = 0;
					for (int j = 0; j < filas; j++) {
						if(carton[columna][j]!=0) {
							rellenados++;
						}
					}
					if(rellenados<2) {
						do {
							fila = random.nextInt(3);
							if(carton[columna][fila]==0) {
								carton[columna][fila]=numero;
								imprimido = true;
							}
						}while(imprimido==false);
					}
				}
			} while (total<15);
			 
		}
	}
	
	public void mostrarCarton(int carton[][]) {
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                if (carton[i][j] == 0) {
                    System.out.printf("  @ ");
                } else {
                    System.out.printf("%3d ", carton[i][j]);
                }
            }
            System.out.println();
        }
    }
	
	public int[][] getCarton(){
		return carton;
	}

}
//numero = random.nextInt(2);
//if(numero==1) {
//	carton[i][j] = -1;
//}