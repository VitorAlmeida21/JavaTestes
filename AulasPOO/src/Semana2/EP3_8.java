package Semana2;
import java.util.*;

class Produto implements Comparable<Produto> {
    private String nome;
    public Produto(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    @Override
    public int compareTo(Produto outro){
        return 0;
    }
}

class ProdutoEletronico extends Produto{
    private int garantia;

    public ProdutoEletronico(String nome, int garantia){
        super(nome);
        this.garantia = garantia;
    }

    @Override
    public int compareTo(Produto outro){
        ProdutoEletronico outroEletronico = (ProdutoEletronico) outro;
        return Integer.compare(this.garantia, outroEletronico.garantia);
    }
}

class ProdutoRoupa extends Produto{
    private int tamanho;

    public ProdutoRoupa(String nome, String tamanhoStr){
        super(nome);
        switch (tamanhoStr){
            case "P":
                this.tamanho = 1;
                break;
            case "M":
                this.tamanho = 2;
                break;
            case "G":
                this.tamanho = 3;
                break;
            case "GG":
                this.tamanho = 4;
                break;
        }
    }

    @Override
    public int compareTo(Produto outro){
        ProdutoRoupa outraRoupa = (ProdutoRoupa) outro;
        return Integer.compare(this.tamanho, outraRoupa.tamanho);
    }
}

public class EP3_8 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int tipo = Integer.parseInt(s.nextLine());
        int qtd = Integer.parseInt(s.nextLine());

        List<Produto> produtos = new ArrayList<>();

        for(int i = 0; i < qtd; i++){
            String linha = s.nextLine();
            String[] partes = linha.split(" ");

            String nome = partes[0];

            if(tipo == 1) {
                int garantia = Integer.parseInt(partes[1]);
                produtos.add(new ProdutoEletronico(nome, garantia));
            }else if(tipo == 2){
                String tamanho = partes[1];
                produtos.add(new ProdutoRoupa(nome, tamanho));
            }
        }

        Collections.sort(produtos);

        for (Produto p : produtos){
            System.out.println(p.getNome());
        }

        s.close();

    }
}
