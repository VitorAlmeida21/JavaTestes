package Semana1;

import java.io.*;
import java.io.File;

public class Q4 {

    /**
     * Lê uma imagem PBM no formato texto (P1) e retorna a matriz de pixels.
     */
    public static int[][] leiaImagemPBM(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            // Verifica o "magic number"
            String header = br.readLine().trim();
            if (!header.equals("P1")) {
                throw new IllegalArgumentException("O arquivo não é uma imagem PBM P1 válida.");
            }

            // Lê dimensões
            String[] dims;
            do {
                String line = br.readLine();
                // pula comentários
                if (line == null) {
                    throw new IOException("Formato inválido: faltam dimensões.");
                }
                line = line.trim();
                if (line.startsWith("#") || line.isEmpty()) continue;
                dims = line.split("\\s+");
                break;
            } while (true);

            int width = Integer.parseInt(dims[0]);
            int height = Integer.parseInt(dims[1]);

            int[][] pixels = new int[height][width];

            // Lê cada linha de pixels (0 ou 1), sem espaços
            for (int i = 0; i < height; i++) {
                String row;
                do {
                    row = br.readLine();
                    if (row == null) {
                        throw new IOException("Formato inválido: linhas de pixel insuficientes.");
                    }
                    row = row.trim();
                } while (row.isEmpty() || row.startsWith("#"));
                if (row.length() != width) {
                    throw new IOException("Largura de linha não corresponde ao especificado no cabeçalho.");
                }
                for (int j = 0; j < width; j++) {
                    char c = row.charAt(j);
                    if (c != '0' && c != '1') {
                        throw new IOException("Valor de pixel inválido: " + c);
                    }
                    pixels[i][j] = c - '0';
                }
            }

            return pixels;
        }
    }

    /**
     * Aplica a operação de dilatação (máximo em vizinhança 3×3) e
     * retorna a nova matriz resultante.
     */
    public static int[][] dilata(int[][] pixels) {
        int height = pixels.length;
        int width  = pixels[0].length;
        int[][] dil = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int max = pixels[i][j];
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        int ni = i + di, nj = j + dj;
                        if (ni >= 0 && ni < height && nj >= 0 && nj < width) {
                            if (pixels[ni][nj] > max) {
                                max = pixels[ni][nj];
                            }
                        }
                    }
                }
                dil[i][j] = max;
            }
        }

        return dil;
    }

    public static void main(String[] args) {

        String filename = "src" + File.separator + "Resources" + File.separator + "imagem1.pbm";

        try {
            // Leitura e impressão da matriz original
            int[][] pixels = leiaImagemPBM(filename);
            int height = pixels.length;
            int width  = pixels[0].length;

            // Imprime dimensões (igual ao print(width, height) do Python)
            System.out.println(width + " " + height);
            // Imprime cada linha de pixels
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(pixels[i][j]);
                }
                System.out.println();
            }

            // Aplica dilatação
            int[][] dilated = dilata(pixels);

            // Imprime resultado da dilatação
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(dilated[i][j]);
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
