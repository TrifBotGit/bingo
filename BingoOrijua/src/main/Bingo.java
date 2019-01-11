/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author oriol
 */
public class Bingo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] carton = new int[3][9];
        int[] bombo = new int[90];
        boolean partida;

        do {
            CartonModificado(carton);
            pedirNumero(carton, bombo);

            crearBombo(bombo);
            darNumeroBombo(bombo);
            partida = seguirJugando();

        } while (partida);
    }

    public static boolean seguirJugando() {
        char respuesta;

        respuesta = SiNo("Quieres seguir jugando(s/n)?", 's', 'n');
        if (respuesta == 'n') {
            return false;
        } else {
            return true;
        }
    }

    public static void pedirNumero(int[][] carton, int[] bombo) {
        Random rd = new Random();
        char respuesta;

        do {
            mostrarCarton(carton);
            System.out.println("\nNuevo numero: " + darNumeroBombo(bombo));
            respuesta = SiNo("Siguiente numero (s/n)?", 's', 'n');

        } while (respuesta == 's');

    }

    public static int[][] crearCarton(int[][] carton) {
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                carton[i][j] = 0;
            }
        }
        return carton;
    }

    public static void CartonModificado(int[][] carton) {
        Random rd = new Random();
        boolean igual = false;
        int contador = 0, numeroAleatorio = rd.nextInt(9);
        carton = crearCarton(carton);

        for (int i = 0; i < carton.length;) {
            if (contador == 5) {
                contador = 0;
                i++;
            } else if (carton[i][numeroAleatorio] == 0) {
                carton[i][numeroAleatorio] = rd.nextInt(89) + 1;
                while (igual == false) {
                    for (int j = 0; j < carton.length; j++) {
                        for (int k = 0; k < carton[j].length; k++) {
                            if (carton[i][numeroAleatorio] == carton[j][k]) {
                                carton[j][k] = rd.nextInt(89) + 1;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void mostrarCarton(int carton[][]) {
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

    public static int[] crearBombo(int[] bombo) {
        int listado = 0;

        for (int i = 0; i < bombo.length; i++) {
            listado += 1;
            bombo[i] = listado;
        }
        return bombo;
    }

    public static int darNumeroBombo(int[] bombo) {
        Random rd = new Random();
        int numeroEnviar, numeroAleatorio;

        bombo = crearBombo(bombo);
        numeroAleatorio = rd.nextInt(89) + 1;
        numeroEnviar = bombo[numeroAleatorio];
        bombo[numeroAleatorio] = 0;

        return bombo[numeroEnviar] - 1;
    }

    public static char SiNo(String frase, char caracter1, char caracter2) {
        Scanner sc = new Scanner(System.in);

        System.out.println(frase);
        char caracter = sc.next().charAt(0);

        while (caracter != caracter1 && caracter != caracter2) {
            System.out.println(frase);
            caracter = sc.next().charAt(0);
        }

        return caracter;
    }
}