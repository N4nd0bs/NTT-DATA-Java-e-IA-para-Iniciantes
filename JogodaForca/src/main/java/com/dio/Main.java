package com.dio;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Instanciar Scanner, JogoForca e Random
        Scanner sc = new Scanner(System.in);
        JogoForca jogo = new JogoForca();
        Random gerar = new Random();
        int option;
        //Selecionar uma palavra aleatória para o jogo da forca
        String palavra = jogo.getWord()[gerar.nextInt(2)];
        //Criar palavra oculta igual no jogo da forca
        StringBuilder palavraCryptoBuilder = new StringBuilder();
        palavraCryptoBuilder.append("_ ".repeat(palavra.length()));
        //String palavraCrypto = palavraCryptoBuilder.toString();
        //Roda o jogo da forca
        while(jogo.getVida() > 0) {
            //Menu
            System.out.println("========Menu========");
            System.out.println("Esse é um jogo da forca, escolha uma das opções abaixo");
            System.out.println("0 - Escolher uma letra");
            System.out.println("1 - Advinhar palavra");
            System.out.println("2 - Sair");
            System.out.printf("Vida %d \n", jogo.getVida());
            System.out.println(palavraCryptoBuilder);
            System.out.println("\n================");
            //Selecionar opção
            try {
                option = sc.nextInt();
                if(option == 0){
                    //Colocar uma letra na variável
                    String letra = sc.next();
                    //Verificar se letra está contida na palavra
                    if(palavra.contains(letra)){
                        //Criar um StringBuilder para trocar o _ por uma letra
                        //StringBuilder troca = new StringBuilder(palavraCrypto);
                        //Transformar a letra em char e a palavra em array de chars
                        char le = letra.charAt(0);
                        char[] w = palavra.toCharArray();
                        //Comparar o char da letra com os char do array
                        for(var l = 0; l < palavra.length(); l++){
                            if(w[l] == le){
                                //Realizar a troca de _ para um char
                                palavraCryptoBuilder.setCharAt(l*2, le);
                            }
                        }
                        //Transformar StringBuilder em String
                        //palavraCrypto = troca.toString();
                    } else {
                        //Errar a letra te faz perder vida
                        System.out.println("Não tem essa letra");
                        jogo.setVida(-1);
                    }
                } else if(option == 1) {
                    //Advinhar a palavra do jogo da forca
                    String word = sc.next();

                    //Caso acerte, ganha o jogo
                    if(word.equals(palavra)){
                        System.out.println("Você ganhou!!");
                        break;
                    } else {
                        //Caso erre, perde o jogo
                        System.out.println("Você perdeu!!");
                        jogo.setVida(-6);
                    }
                } else if(option == 2) {
                    //Sair do jogo
                    break;
                } else {
                    //Selecionar números válidos
                    System.out.println("Escolha uma opção válida!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("As opções são números inteiros!!");
                sc.next();
            }
        }
    }
}