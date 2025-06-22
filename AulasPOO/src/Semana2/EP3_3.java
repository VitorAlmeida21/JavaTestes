package Semana2;

import java.util.Scanner;

class Aluno{
    private String nome;
    private double[] notas;

    public Aluno(String nome, double[] notas){
        this.nome = nome;
        this.notas = notas;
    }

    public double CalcularMedia() {
        double soma = 0;
        for (double nota : notas){
            soma += nota;
        }
        return soma / notas.length;
    }

    public String getNome(){
        return nome;
    }

    public double[] getNotas(){
        return notas;
    }

}

class AlunoRegular extends Aluno{
    public AlunoRegular(String nome, double[] notas){
        super(nome, notas);
    }

    public String verificarSituacao(){
        double media = CalcularMedia();

        if(media >= 7.0){
            return "APROVADO";
        }else if(media >= 5.0){
            return "RECUPERACAO";
        }else{
            return "REPROVADO";
        }
    }
}

public class EP3_3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        String nome = s.nextLine();
        String[] notasStr = s.nextLine().split(" ");
        double[] notas = new double[3];

        for (int i = 0; i < 3; i++){
            notas[i] = Double.parseDouble(notasStr[i]);
        }

        AlunoRegular aluno = new AlunoRegular(nome, notas);

        double media = aluno.CalcularMedia();
        System.out.printf("%.2f\n", media);
        System.out.println(aluno.verificarSituacao());

        s.close();
    }
}


