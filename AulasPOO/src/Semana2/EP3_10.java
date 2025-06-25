package Semana2;
import java.util.Scanner;

class Calculadora{
    public int somar(int a, int b){
        return a + b;
    }

    public int somar(int a, int b, int c){
        return a + b + c;
    }

    public double somar(double a, double b){
        return a + b;
    }

    public String somar(String a, String b){
        return a + b;
    }
}

public class EP3_10 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Calculadora calc = new Calculadora();
        
        String tipo = s.nextLine();
        
        if(tipo.equals("int2")){
            int x = Integer.parseInt(s.nextLine());
            int y = Integer.parseInt(s.nextLine());
            
            System.out.println(calc.somar(x, y));
    
        } else if(tipo.equals("int3")){
            int x = Integer.parseInt(s.nextLine());
            int y = Integer.parseInt(s.nextLine());
            int z = Integer.parseInt(s.nextLine());
            
            System.out.println(calc.somar(x, y, z));
            
        } else if(tipo.equals("float2")){
            double x = Double.parseDouble(s.nextLine());
            double y = Double.parseDouble(s.nextLine());
            
            System.out.println(calc.somar(x, y));
        } else if(tipo.equals("str2")){
            String x = s.nextLine();
            String y = s.nextLine();
            
            System.out.println(calc.somar(x, y));
        }

    }
}
