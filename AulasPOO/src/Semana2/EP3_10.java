package Semana2;

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
        Calculadora calc = new Calculadora();

        System.out.println("Somar dois inteiros " + calc.somar(8, 2));

        System.out.println("Somar três inteiros " + calc.somar(3, 8, 2));

        System.out.println("Somar dois floats " + calc.somar(5.5, 5.5));

        System.out.println("Somar duas strings " + calc.somar("Vi", "tor"));

    }
}
