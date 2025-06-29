package Semana3;
import java.util.Scanner;

abstract class Tarefa{
    public abstract void executar();
}

class TarefaSimples extends Tarefa{
    private String descricao;

    public TarefaSimples(String descricao){
        this.descricao = descricao;
    }

    @Override
    public void executar(){
        System.out.println(descricao + " concluída.");
    }
}

public class EP4_1{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        String descricaoTarefa = s.nextLine();
        s.close();

        Tarefa tarefa = new TarefaSimples(descricaoTarefa);
        tarefa.executar();
    }
}


