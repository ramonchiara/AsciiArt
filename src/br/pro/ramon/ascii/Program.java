package br.pro.ramon.ascii;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        mostraArquivo("artes/titulo.txt");

        System.out.print("Qual arquivo você quer? 1, 2, 3 ou sorteia? ");
        String arquivo = console.nextLine();

        if (arquivo.equalsIgnoreCase("sorteia")) {
            Random rng = new Random();
            int n = rng.nextInt(3);
            arquivo = String.valueOf(n + 1);
        }

        switch (arquivo) {
            case "1":
                mostraArquivo("artes/felix.txt");
                break;
            case "2":
                mostraArquivo("artes/alien.txt");
                break;
            case "3":
                mostraArquivo("artes/batman.txt");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void mostraArquivo(String arquivo) {
        try {
            Scanner leitor = new Scanner(new File(arquivo));

            boolean terminou = false;
            do {
                try {
                    String linha = leitor.nextLine();
                    System.out.println(linha);
                } catch (NoSuchElementException ex) {
                    terminou = true;
                }
            } while (!terminou);
        } catch (FileNotFoundException ex) {
            System.out.println("ARQUIVO NÃO ENCONTRADO! POR FAVOR, VERIFIQUE SEU CÓDIGO!!!");
        }
    }

}
