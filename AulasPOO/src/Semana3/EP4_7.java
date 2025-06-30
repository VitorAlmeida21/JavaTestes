package Semana3;
import java.util.Scanner;

interface Transporte{
    void mover();
}

class Carro implements Transporte{
    @Override
    public void mover(){
        System.out.println("O carro está em movimento no asfalto...");

    }
}

class Bicicleta implements Transporte{
    @Override
    public void mover(){
        System.out.println("Pedalando a bicicleta...");

    }
}

class Trem implements Transporte{
    @Override
    public void mover(){
        System.out.println("O trem está em movimento nos trilhos...");

    }
}

public class EP4_7 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String tipo = s.nextLine().trim();
        s.close();

        Transporte transporte;

        if(tipo.equalsIgnoreCase("Carro")){
            transporte = new Carro();
        } else if(tipo.equalsIgnoreCase("Bicicleta")){
            transporte = new Bicicleta();
        } else if(tipo.equalsIgnoreCase("Trem")){
            transporte = new Trem();
        } else {
            System.out.println("O transporte inserido não é válido!");
            return;
        }

        transporte.mover();
    }
}
