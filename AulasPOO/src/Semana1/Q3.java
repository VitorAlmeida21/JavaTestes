package Semana1;
import java.util.Scanner;

/*
Escreva um programa que leia um vetor de inteiros com n elementos. Depois ordene todos os elementos em ordem crescente.
Importante: não utilize funções prontas da linguagem para ordenação! Escreva o seu algoritmo de ordenação.
* */

public class Q3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o tamanho do vetor: ");
        int n = scanner.nextInt();
        int[] v = new int[n];

        System.out.println("Insira os valores: ");
        for(int i=0; i<n;i++){
            v[i] = scanner.nextInt();
        }

        // Ordenação Bubble Sort
        for(int i=0; i<n-1;i++){
            // Controla quantas vezes o vetor será varrido
            for (int j=0; j<n-1-i;j++){
                if(v[j]>v[j+1]){
                    // Troca os elementos de posição
                    int temp = v[j];
                    v[j] = v[j+1];
                    v[j+1] = temp;
                }

            }
        }

        // Imprimir os valores:
        for(int i=0; i<n;i++){
            System.out.print(v[i]);
            if (i < n-1){
                System.out.print(" ");
            }
        }
        scanner.close();
    }
}
