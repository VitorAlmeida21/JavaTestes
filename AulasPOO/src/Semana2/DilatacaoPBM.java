package Semana2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DilatacaoPBM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomeArquivo = scanner.nextLine();
        scanner.close();

        try {
            File arquivo = new File(nomeArquivo);
            Scanner leitor = new Scanner(arquivo);

            // Lê o cabeçalho
            String tipo = leitor.nextLine(); // Exemplo: P1
            int largura = leitor.nextInt();
            int altura = leitor.nextInt();
            leitor.nextLine(); // Avança para a próxima linha após altura

            int[][] imagem = new int[altura][largura];

            // Lê a imagem (caracter por caracter, mesmo sem espaços)
            for (int i = 0; i < altura; i++) {
                String linha = leitor.nextLine().trim();
                for (int j = 0; j < largura; j++) {
                    imagem[i][j] = linha.charAt(j) - '0';
                }
            }
            leitor.close();

            // Exibe a imagem original
            System.out.println(nomeArquivo);
            System.out.println(tipo);
            System.out.println(largura + " " + altura);
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    System.out.print(imagem[i][j]);
                }
                System.out.println();
            }

            // Dilatação em 8 direções
            int[][] resultado = new int[altura][largura];

            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    if (imagem[i][j] == 1) {
                        for (int di = -1; di <= 1; di++) {
                            for (int dj = -1; dj <= 1; dj++) {
                                int ni = i + di;
                                int nj = j + dj;
                                if (ni >= 0 && ni < altura && nj >= 0 && nj < largura) {
                                    resultado[ni][nj] = 1;
                                }
                            }
                        }
                    }
                }
            }

            // Exibe a matriz resultante
            System.out.println("\nMatriz Resultante:");
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    System.out.print(resultado[i][j]);
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + nomeArquivo);
        }
    }
}
