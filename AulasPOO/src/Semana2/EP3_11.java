package Semana2;

class Carrinho{
    public int inserirItem(int itemA, int itemB){
        return itemA + itemB;
    }
    public String inserirItem(String nomeA, String nomeB){
        return nomeA + " " + nomeB;
    }
    public float inserirItem(float precoA, float precoB){
        return precoA + precoB;
    }
}

public class EP3_11 {
    public static void main(String[] args){
        Carrinho carrinho = new Carrinho();

        int totalQuantidade = carrinho.inserirItem(5, 10);
        System.out.println("Total de itens: " + totalQuantidade);

        String descricao = carrinho.inserirItem("Mouse", "Teclado");
        System.out.println(descricao);

        double totalPreco = carrinho.inserirItem(11.20f, 2.80f);
        System.out.println("Preço total: R$" + totalPreco);
    }
}
