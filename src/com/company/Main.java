package com.company;

import java.util.Scanner;

public class Main {
    public static double validador(int opcion){
        double validado = 0;
        Scanner sc = new Scanner(System.in);
        switch (opcion){
            case  0:{
                while(!sc.hasNextInt()){
                    System.out.print("¡Por favor introduce un número entero! ");
                    sc.next();
                }
                validado = sc.nextDouble();
            }
            break;
            case 1:{
                while(!sc.hasNextDouble()){
                    System.out.print("¡Por favor introduce un número decimal! ");
                    sc.next();
                }
                validado = sc.nextDouble();
            }
            break;
        }
        return  validado;
    }

    public static boolean validarNota(double nota) {
        boolean validado = true;
        if (nota < 0 || nota > 10) {
            validado = false;
        }
        return validado;
    }

    public static String daCalificacion(int nota) {
        String calificacion = "";
        switch (nota) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                calificacion = "INSUFICIENTE";
                break;
            case 5:
                calificacion = "SUFICIENTE";
                break;
            case 6:
                calificacion = "BIEN";
                break;
            case 7:
            case 8:
                calificacion = "NOTABLE";
                break;
            case 9:
            case 10:
                calificacion = "SOBRESALIENTE";
                break;
        }
        return calificacion;
    }

    public static double redondeaCalificacion(double nota) {
        double notaRedondeada;
        if ((nota + 1) >= (nota + 0.5)) {
            notaRedondeada = Math.ceil(nota);
        } else {
            notaRedondeada = Math.floor(nota);
        }
        return notaRedondeada;
    }

    public static void main(String[] args) {
        double nota;
        Scanner sc = new Scanner(System.in);
        System.out.println("¡Vamos a comprobar una calificación!");
        System.out.print("Introduce un nota: ");
        nota = validador(1);
        while (!validarNota(nota)) {
            System.out.print("¡Introdice una nota entre 0 y 10! ");
            nota = validador(1);
        }
        sc.close();
        System.out.printf("La calificación de la nota %f es: %s\n", nota, daCalificacion((int) redondeaCalificacion(nota)));
    }
}
