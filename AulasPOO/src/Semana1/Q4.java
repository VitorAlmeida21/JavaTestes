package Semana1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q4{
    public static void main(String[] args) {
        String caminho = "src/Resources/imagem1.pbm"; // Substitua aqui
        try {
            Scanner scanner = new Scanner(new File(caminho));

            // Ignora cabeçalho P1
            String formato = scanner.next();
            int largura = scanner.nextInt();
            int altura = scanner.nextInt();

            int[][] imagem = new int[altura][largura];
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    if (scanner.hasNextInt()) {
                        imagem[i][j] = scanner.nextInt();
                    }
                }
            }

            System.out.println("Imagem Original:");
            imprimirImagem(imagem);

            int[][] dilatada = dilatar(imagem);

            System.out.println("\nImagem Após Dilatação:");
            imprimirImagem(dilatada);

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
    }

    public static void imprimirImagem(int[][] imagem) {
        for (int[] linha : imagem) {
            for (int pixel : linha) {
                System.out.print(pixel);
            }
            System.out.println();
        }
    }

    public static int[][] dilatar(int[][] imagem) {
        int altura = imagem.length;
        int largura = imagem[0].length;
        int[][] resultado = new int[altura][largura];

        for (int i = 1; i < altura - 1; i++) {
            for (int j = 1; j < largura - 1; j++) {
                if (imagem[i][j] == 1) {
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            resultado[i + di][j + dj] = 1;
                        }
                    }
                }
            }
        }

        return resultado;
    }
}
