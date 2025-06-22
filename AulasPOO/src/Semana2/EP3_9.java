package Semana2;
import java.util.*;

class Pessoa{
    private String nome;
    private List<Pessoa> filhos;

    public Pessoa(String nome){
        this.nome = nome;
        this.filhos = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public void adicionarFilho(Pessoa filho){
        filhos.add(filho);
    }

    public int contarDescendentes(){
        int total = filhos.size();
        for(Pessoa filho : filhos){
            total += filho.contarDescendentes();
        }
        return total;
    }
}

class Pai extends Pessoa{
    public Pai(String nome){
        super(nome);
    }
}

class Filho extends Pessoa{
    public Filho(String nome){
        super(nome);
    }
}

public class EP3_9 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());

        Map<String, Pessoa> pessoas = new HashMap<>();

        for(int i = 0; i<n; i++){
            String[] linha = s.nextLine().split(" ");
            String nome = linha[0];
            int qtdFilhos = Integer.parseInt(linha[1]);

            Pessoa pessoa;
            if (qtdFilhos >0){
                pessoa = pessoas.getOrDefault(nome, new Pai(nome));
            }else{
                pessoa = pessoas.getOrDefault(nome, new Filho(nome));
            }
            pessoas.put(nome, pessoa);

            for(int j = 0; j<qtdFilhos; j++){
                String nomeFilho = s.nextLine();

                Pessoa filho = pessoas.getOrDefault(nomeFilho, new Filho(nomeFilho));
                pessoas.put(nomeFilho, filho);

                pessoa.adicionarFilho(filho);
            }
        }

        String nomeConsulta = s.nextLine();
        Pessoa consultada = pessoas.get(nomeConsulta);

        System.out.println(consultada.contarDescendentes());

        s.close();
    }
}
