package Semana3;
import java.util.Locale;
import java.util.Scanner;

abstract class Conta{
    private String numero;
    private double saldo;

    public Conta(String numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero(){
        return numero;
    }
    public double getSaldo(){
        return saldo;
    }

    public abstract double calcularTaxa(int qtdOperacoes);
}

interface Investimento{
    double renderJuros();
}

class ContaCorrente extends Conta{
    public ContaCorrente(String numero, double saldo){
        super(numero, saldo);
    }

    @Override
    public double calcularTaxa(int qtdOperacoes){
        return qtdOperacoes * 10.00;
    }
}

class ContaEspecial extends Conta{
    public ContaEspecial(String numero, double saldo){
        super(numero, saldo);
    }

    @Override
    public double calcularTaxa(int qtdOperacoes){
        return getSaldo() * qtdOperacoes * 0.02;
    }

}

class ContaPoupanca extends Conta implements Investimento{
    public ContaPoupanca(String numero, double saldo){
        super(numero, saldo);
    }

    @Override
    public double calcularTaxa(int qtdOperacoes){
        return 0.00;
    }

    public double renderJuros(){
        return getSaldo() * 0.005;
    }
}

public class EP4_9 {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner s = new Scanner(System.in);

        String tipo = s.nextLine().trim();
        String numero = s.nextLine().trim();
        double saldoInicial = Double.parseDouble(s.nextLine().trim().replace(",", "."));
        int operacoes = Integer.parseInt(s.nextLine().trim());

        Conta conta;

        switch (tipo) {
            case "CC":
                conta = new ContaCorrente(numero, saldoInicial);
                break;
            case "CE":
                conta = new ContaEspecial(numero, saldoInicial);
                break;
            case "CP":
                conta = new ContaPoupanca(numero, saldoInicial);
                break;
            default:
                System.out.println("Tipo de conta inválido.");
                s.close();
                return;
        }

        double taxa = conta.calcularTaxa(operacoes);
        double saldoFinal = saldoInicial - taxa;

        if(conta instanceof ContaPoupanca) {
            saldoFinal += ((ContaPoupanca) conta).renderJuros();
        }

        System.out.printf("Saldo inicial: %.2f\n", saldoInicial);
        System.out.printf("Taxa: %.2f\n", taxa);
        System.out.printf("Saldo final: %.2f\n", saldoFinal);

        s.close();
    }
}
