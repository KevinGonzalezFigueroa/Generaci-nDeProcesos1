package com.generaciondeprocesos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Qué dirección quiere que se abra?");
        String direccionWeb = sc.nextLine();
        System.out.println("¿Cuántas veces quieres que se abra?");
        int numeroDeVeces = sc.nextInt();
        ArrayList<Process> lista = new ArrayList<>();

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\95.0.1020.30\\msedge.exe", direccionWeb, "--new-window");

        try {
            Process process = processBuilder.start();
            lista.add(process);

            for (int i = 0; i <= numeroDeVeces-2; i++) {
                process = processBuilder.start();
                lista.add(process);
            }

            for (Process processFor: lista){
                processFor.waitFor();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
