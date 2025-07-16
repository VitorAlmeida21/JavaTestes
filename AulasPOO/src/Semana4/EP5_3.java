package Semana4;
import java.util.Scanner;

class EP5_3{
    public static String CalculadoraMedia(String notas){
        try{
            if(notas.trim().isEmpty()){
                return "Erro: Lista vazia\n";
            }

            String[] partes = notas.split(",");
            double soma = 0.0;
            for(String parte : partes){
                double nota = Double.parseDouble(parte);
                soma += nota;
            }
            double media = soma / partes.length;
            return String.format("Média: %.2f", media);

        }catch(NumberFormatException e){
            return "Erro: Valor não numérico encontrado";
        }catch(Exception e){
            return "Erro inesperado.\n";
        }

    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String entrada = s.nextLine();

        System.out.println(CalculadoraMedia(entrada));

        s.close();
    }
}