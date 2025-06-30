package Semana3;
import java.util.Scanner;

abstract class Funcionario{
    private String nome;

    public Funcionario(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public abstract double calcular_salario();
}

class Mensalista extends Funcionario{
    private double salarioFixo;

    public Mensalista(String nome, double salarioFixo){
        super(nome);
        this.salarioFixo = salarioFixo;
    }

    @Override
    public double calcular_salario(){
        return salarioFixo;
    }
}

class Horista extends Funcionario{
    private double salarioHora;
    private int hora;

    public Horista(String nome, int hora, double salarioHora){
        super(nome);
        this.hora = hora;
        this.salarioHora = salarioHora;
    }

    @Override
    public double calcular_salario(){
        return salarioHora * hora;
    }
}

public class EP4_3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        String nome = s.nextLine();
        String tipo = s.nextLine();

        Funcionario funcionario;

        if(tipo.equalsIgnoreCase("Mensalista")){
            double salario = s.nextDouble();
            funcionario = new Mensalista(nome, salario);
        }else if(tipo.equalsIgnoreCase("Horista")){
            double salarioHora = s.nextDouble();
            int horas = s.nextInt();

            funcionario = new Horista(nome, horas, salarioHora);
        }else {
            System.out.println("Tipo inválido!");
            s.close();
            return;
        }

        s.close();
        System.out.printf("%.2f\n", funcionario.calcular_salario());
    }
}
