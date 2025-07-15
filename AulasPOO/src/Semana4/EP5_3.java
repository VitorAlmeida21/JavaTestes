package Semana4;
import java.util.Scanner;

class EP5_3{
    public static String calcularMedia(String notas){
        try{
            if(notas.trim().isEmpty()){
                return "Erro: Lista vazia";
            }

            String[] partes = notas.split(",");

            double soma = 0;
            for(String parte : partes){
                parte = parte.trim();
                double valor = Double.parseDouble(parte);
                soma += valor;
            }

            double media = soma / partes.length;
            return String.format("Média: %.2f", media);
        }catch(NumberFormatException e ){
            return "Erro: Valor não numérico encontrado";
        }catch(Exception e){
            return "Erro: Problema inesperado";
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String entrada = s.nextLine();

        System.out.println(calcularMedia(entrada));

        s.close();
    }
}
