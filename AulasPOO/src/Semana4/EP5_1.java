package Semana4;
import java.util.Scanner;

public class EP5_1 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        try{
            int a = s.nextInt();
            int b = s.nextInt();
            double resultado = (double) a/b;
            System.out.println(resultado);
        } catch (ArithmeticException e){
            System.out.println("Erro: Divisão por zero não permitida.");
        } catch (Exception e){
            System.out.println("Erro: Valores inválidos");
        } finally{
            s.close();
        }
    }
}
