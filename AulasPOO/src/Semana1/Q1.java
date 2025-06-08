package Semana1;
import java.util.Scanner;

class Q1{
    public static void main (String[] args) {
        Scanner entrada = new Scanner(System.in);
        int C = entrada.nextInt();
        float F = (C*9/5)+32;
        System.out.println(C+ " graus Celsius corresponde a " + F + " Fahrenheit.");
    }
}