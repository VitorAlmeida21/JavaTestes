package Semana2;
import java.util.Scanner;

class Empregado{
    private String nome;
    private double salarioBase;

    public Empregado(String nome, double salarioBase){
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public String getNome(){
        return nome;
    }

    public double CalcularSalario(){
        return salarioBase;
    }
}

class Gerente extends Empregado{
    private double bonusAnual;

    public Gerente(String nome, double salarioBase, double bonusAnual){
        super(nome, salarioBase);
        this.bonusAnual = bonusAnual;
    }

    @Override
    public double CalcularSalario(){
        return super.CalcularSalario() + (bonusAnual / 12);
    }
}

class Vendedor extends Empregado{
    private double totalVendas;

    public Vendedor(String nome, double salarioBase, double totalVendas){
        super(nome, salarioBase);
        this.totalVendas = totalVendas;
    }

    @Override
    public double CalcularSalario(){
        return  super.CalcularSalario() + (totalVendas * 0.05);
    }
}

public class EP3_5{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int qtdEmpregados = Integer.parseInt(s.nextLine());
        Empregado[] empregados = new Empregado[qtdEmpregados];

        for(int i = 0; i < qtdEmpregados; i++){
            String linha = s.nextLine();
            String[] partes = linha.split(" ");

            String tipo = partes[0];
            String nome = partes[1];
            double salarioBase = Double.parseDouble(partes[2]);

            if(tipo.equals("E")) {
                empregados[i] = new Empregado(nome, salarioBase);
            }else if(tipo.equals("G")) {
                double bonusAnual = Double.parseDouble(partes[3]);
                empregados[i] = new Gerente(nome, salarioBase, bonusAnual);
            }else if(tipo.equals("V")) {
                double totalVendas = Double.parseDouble(partes[3]);
                empregados[i] = new Vendedor(nome, salarioBase, totalVendas);
            }
        }

        for(Empregado emp : empregados){
            System.out.printf("Nome: %s Salario: %.2f\n", emp.getNome(), emp.CalcularSalario());
        }

        s.close();
    }
}
