package Semana6;
import java.util.Scanner;

abstract class Veiculo{
    abstract void acelerar();
}

class Carro extends Veiculo{
    public Carro(){
        System.out.println("Classe Carro criado");
    }

    @Override
    public void acelerar(){
        System.out.println("Carro acelerando suavemente");
    }
}

class Moto extends Veiculo{
    public Moto(){
        System.out.println("Classe Moto criado");
    }

    @Override
    public void acelerar(){
        System.out.println("Moto acelerando rapidamente");
    }
}

class Caminhao extends Veiculo{
    public Caminhao(){
        System.out.println("Classe Caminhao criado");
    }

    @Override
    public void acelerar(){
        System.out.println("Caminhao acelerando devagar");
    }
}

class FabricaVeiculos{
    public static Veiculo criar_veiculo(String tipo){
        switch(tipo.toLowerCase()){
            case("carro"):
                return new Carro();
            case("moto"):
                return new Moto();
            case("caminhao"):
                return new Caminhao();
            default:
                System.out.println("Tipo de veículo inválido");
                return null;
        }
    }
}

class EP7_2{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String tipo = s.nextLine();

        Veiculo veiculo = FabricaVeiculos.criar_veiculo(tipo);

        if(veiculo!=null){
            veiculo.acelerar();
        }

        s.close();
    }
}







