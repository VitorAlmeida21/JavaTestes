package Semana4;
import java.util.Scanner;

class EP5_1{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        try{
            int a = s.nextInt();
            int b = s.nextInt();
            double resultado = a/b;

            System.out.println(resultado);
        }catch (ArithmeticException e){
            System.out.println("Não é possível dividir por zero.");
        }catch (Exception e){
            System.out.println("Valores inválidos");
        }finally{
            s.close();
        }
    }
}