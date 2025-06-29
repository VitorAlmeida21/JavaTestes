package Semana3;
import java.util.Scanner;

abstract class Aluno{
    private String nome;
    private double[] notas = new double[3];

    public Aluno(String nome, double[] notas){
        this.nome = nome;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public double[] getNotas(){
        return notas;
    }

    public abstract double calcularMedia();
    public abstract String obterStatus();
}

class AlunoRegular extends Aluno{
    public AlunoRegular(String nome, double[] notas){
        super(nome, notas);
    }

    @Override
    public double calcularMedia(){
        double soma = 0;

        for(double nota : getNotas()) {
            soma += nota;
        }
        return soma / getNotas().length;
    }

    @Override
    public String obterStatus(){
        double media = calcularMedia();
        if (media >= 7.0){
            return "APROVADO";
        }else if(media >= 5.0){
            return "RECUPERACAO";
        }else {
            return "REPROVADO";
        }
    }
}

public class EP4_2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        String nome = s.nextLine();
        double[] notas = new double[3];

        for(int i = 0; i < notas.length; i++){
            notas[i] = s.nextDouble();
        }

        s.close();

        Aluno aluno = new AlunoRegular(nome, notas);
        double media = aluno.calcularMedia();

        System.out.printf("%.2f\n", media);
        System.out.println(aluno.obterStatus());
    }

}
