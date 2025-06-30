package Semana3;
import java.util.Scanner;

abstract class Veiculo{
    private String marca;
    private double preco;

    public Veiculo(String marca, double preco){
        this.marca = marca;
        this.preco = preco;
    }

    public String getMarca(){
        return marca;
    }

    public double getPreco(){
        return preco;
    }

    public abstract double calcularImposto();

    public double precoFinal(){
        return preco + calcularImposto();
    }
}

class Carro2 extends Veiculo{
    public Carro2(String marca, double preco){
        super(marca, preco);
    }

    @Override
    public double calcularImposto(){
        return 0.15 * getPreco();
    }
}

class Moto extends Veiculo{
    public Moto(String marca, double preco){
        super(marca, preco);
    }

    @Override
    public double calcularImposto(){
        return 0.08 * getPreco();
    }
}

interface Eletrico{
    int autonomiaBateria();
}

class CarroEletrico extends Carro2 implements Eletrico{
    private int autonomia;

    public CarroEletrico(String marca, double preco, int autonomia){
        super(marca, preco);
        this.autonomia = autonomia;
    }

    @Override
    public int autonomiaBateria(){
        return autonomia;
    }
}

class MotoEletrica extends Moto implements Eletrico{
    private int autonomia;

    public MotoEletrica(String marca, double preco, int autonomia){
        super(marca, preco);
        this.autonomia = autonomia;
    }

    @Override
    public double calcularImposto(){
        return 0.15 * getPreco();
    }

    @Override
    public int autonomiaBateria(){
        return autonomia;
    }
}

public class EP4_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tipo = scanner.nextLine().trim();
        String marca = scanner.nextLine().trim();
        double preco = Double.parseDouble(scanner.nextLine().trim());

        Veiculo veiculo;
        boolean isEletrico = scanner.hasNextLine();
        Eletrico eletrico = null;

        if (isEletrico) {
            String linha = scanner.nextLine().trim();

            if (!linha.isEmpty()) {
                int autonomia = Integer.parseInt(linha);

                if (tipo.equals("CARRO")) {
                    veiculo = new CarroEletrico(marca, preco, autonomia);

                } else {
                    veiculo = new MotoEletrica(marca, preco, autonomia);

                }
                eletrico = (Eletrico) veiculo;
            } else {
                veiculo = tipo.equals("CARRO") ? new Carro2(marca, preco) : new Moto(marca, preco);
            }
        } else {
            veiculo = tipo.equals("CARRO") ? new Carro2(marca, preco) : new Moto(marca, preco);
        }

        System.out.printf("Preço: %.2f\n", veiculo.getPreco());
        System.out.printf("Imposto: %.2f\n", veiculo.calcularImposto());
        System.out.printf("Total: %.2f\n", veiculo.precoFinal());
        if (eletrico != null) {
            System.out.printf("Autonomia: %d km\n", eletrico.autonomiaBateria());
        }

        scanner.close();
    }
}