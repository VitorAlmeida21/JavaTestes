package Semana2;
import java.util.Scanner;

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
        Scanner s = new Scanner(System.in);
        
        String tipo = s.nextLine();
        
        if(tipo.equals("quantidade")){
            int x = Integer.parseInt(s.nextLine());
            int y = Integer.parseInt(s.nextLine());
            
            System.out.println(carrinho.inserirItem(x, y));
            
        } else if(tipo.equals("itens")){
            String x = s.nextLine();
            String y = s.nextLine();
            
            System.out.println(carrinho.inserirItem(x, y));
            
        } else if(tipo.equals("preco")){
            float x = Float.parseFloat(s.nextLine());
            float y = Float.parseFloat(s.nextLine());
            
            System.out.println(carrinho.inserirItem(x, y));
        
        }
    }
}
