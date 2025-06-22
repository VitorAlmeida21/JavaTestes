package Semana2;
import java.util.Scanner;

class Veiculo{
    private String placa;
    private int anoFabricacao;

    public Veiculo(String placa, int anoFabricacao){
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
    }

    public double calcularAno() {
        int anoAtual = 2025;
        return anoAtual - anoFabricacao;
    }

    public double calcularIPVA(){
        return 0.00;
    }
}

class Carro extends Veiculo{
    private double valorMercado;

    public Carro(String placa, int anoFabricacao, double valorMercado){
        super(placa, anoFabricacao);
        this.valorMercado = valorMercado;
    }

    @Override
    public double calcularIPVA(){
        if(calcularAno() <= 20){
            return valorMercado * 0.025;
        }else{
            return 0.00;
        }
    }
}

class Moto extends Veiculo{
    private double cilindradas;

    public Moto(String placa, int anoFabricacao, double cilindradas){
        super(placa, anoFabricacao);
        this.cilindradas = cilindradas;
    }

    @Override
    public double calcularIPVA(){
        if(calcularAno() <= 15){
            return 50.00 + (0.10 * cilindradas);
        }else {
            return 0.00;
        }
    }
}

public class EP3_6 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int qtdVeiculos = Integer.parseInt(s.nextLine());
        Veiculo[] veiculos = new Veiculo[qtdVeiculos];

        for(int i = 0; i < qtdVeiculos; i++){
            String linha = s.nextLine();
            String[] partes = linha.split(" ");

            String tipo = partes[0];
            String placa = partes[1];
            int anoFabricacao = Integer.parseInt(partes[2]);

            if(tipo.equals("C")){
                double valorMercado = Double.parseDouble(partes[3]);
                veiculos[i] = new Carro(placa, anoFabricacao, valorMercado);
            }else if(tipo.equals("M")){
                double cilindradas = Double.parseDouble(partes[3]);
                veiculos[i] = new Moto(placa, anoFabricacao, cilindradas);
            }
        }

        double totalIPVA = 0.00;

        for(Veiculo v : veiculos) {
            totalIPVA += v.calcularIPVA();
        }

        System.out.printf("%.2f\n", totalIPVA);

        s.close();
    }
}
