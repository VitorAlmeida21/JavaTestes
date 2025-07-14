package Semana3;
import java.util.Scanner;

abstract class Produto{
    private String nome;
    private double preco;
    private String categoria;

    public Produto(String nome, double preco, String categoria){
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;
    }

    public String getCategoria(){
        return categoria;
    }

    public abstract double calcularDesconto();

    public double calcularDescontoTotal(){
        double descontoBase = calcularDesconto();
        double descontoAdicional = 0.00;

        if(categoria.equals("PROMOCIONAL")){
            descontoAdicional = preco * 0.05;
        }
        return descontoBase + descontoAdicional;
    }

    public double calcularFrete(double pesoOuZero){
        if(categoria.equals("PROMOCIONAL") || categoria.equals("DIGITAL")){
            return 0.00;
        }
        return pesoOuZero * 0.10;
    }

    public void exibirResumo(double pesoOuZero){
        double desconto = calcularDescontoTotal();
        double precoComDesconto = preco - desconto;
        double frete = calcularFrete(pesoOuZero);
        double total = precoComDesconto + frete;

        System.out.println(getClass().getSimpleName() + ": " + getNome());
        System.out.printf("Preço original: %.2f\n", getPreco());
        System.out.printf("Desconto total: %.2f\n", desconto);
        System.out.printf("Frete: %.2f\n", frete);
        System.out.printf("Total com frete: %.2f\n", total);
    }
}

class Eletronico extends Produto{
    public Eletronico(String nome, double preco, String categoria){
        super(nome, preco, categoria);
    }

    @Override
    public double calcularDesconto(){
        return getPreco() * 0.05;
    }
}

class Roupa extends Produto{
    public Roupa(String nome, double preco, String categoria){
        super(nome, preco, categoria);
    }

    @Override
    public double calcularDesconto(){
        return getPreco() * 0.10;
    }
}

class Livro extends Produto{
    public Livro(String nome, double preco, String categoria){
        super(nome, preco, categoria);
    }

    @Override
    public double calcularDesconto(){
        return getPreco() * 0.15;
    }
}

class EP4_11{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        String tipo = s.nextLine().toUpperCase().trim();
        String nome = s.nextLine().trim();
        double preco = Double.parseDouble(s.nextLine().trim());
        String categoria = s.nextLine().toUpperCase().trim();
        double pesoOuZero = Double.parseDouble(s.nextLine().trim());

        Produto produto;

        switch (tipo){
            case "ELETRONICO":
                produto = new Eletronico(nome, preco, categoria);
                break;
            case "ROUPA":
                produto = new Roupa(nome, preco, categoria);
                break;
            case "LIVRO":
                produto = new Livro(nome, preco, categoria);
                break;
            default:
                System.out.println("Tipo de produto inválido!");
                s.close();
                return;

        }

        produto.exibirResumo(pesoOuZero);

        s.close();
    }
}