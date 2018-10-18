package com.company;

import java.util.Scanner;

public class Main {
    public static double validarDecimal(Scanner sc) {
        double numeroValidado;
        while (!sc.hasNextDouble()) {
            System.out.print("¡Introduce un valor numérico! ");
            sc.next();
        }
        numeroValidado = sc.nextDouble();
        return numeroValidado;
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
        nota = validarDecimal(sc);
        while (!validarNota(nota)) {
            System.out.print("¡Introdice una nota entre 0 y 10! ");
            nota = validarDecimal(sc);
        }
        sc.close();
        System.out.println(redondeaCalificacion(nota));
        System.out.printf("La calificación de la nota %f es: %s\n", nota, daCalificacion((int) redondeaCalificacion(nota)));
    }
}
