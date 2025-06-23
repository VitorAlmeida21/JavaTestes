package Semana2;
import java.io.InputStream;
import java.util.Scanner;

public class TestePBM {
    public static void main(String[] args) {
        String nomeArquivo = "/imagem1.pbm";  // Caminho RELATIVO ao Resources Root

        InputStream inputStream = TestePBM.class.getResourceAsStream(nomeArquivo);

        if (inputStream == null) {
            System.out.println("Arquivo não encontrado dentro de Resources!");
            return;
        }

        Scanner leitor = new Scanner(inputStream);
        while (leitor.hasNextLine()) {
            System.out.println(leitor.nextLine());
        }
        leitor.close();
    }
}


