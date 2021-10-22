package com.generaciondeprocesos;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Qué dirección quiere que se abra?");
        String direccionWeb = sc.nextLine();
        System.out.println("¿Cuántas veces quieres que se abra?");
        int numeroDeVeces = sc.nextInt();

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("C:\\Program Files\\Mozilla Firefox\\firefox.exe", "/c", direccionWeb);

        try {
            Process process = processBuilder.start();

            for (int i = 0; i < numeroDeVeces-1; i++) {
                process = processBuilder.start();
            }

            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
