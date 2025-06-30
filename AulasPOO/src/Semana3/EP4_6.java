package Semana3;
import java.util.Scanner;
import java.util.Locale;

interface MetodoPagamento{
    String pagar(double valor);
}

class CartaoCredito implements MetodoPagamento{
    @Override
    public String pagar(double valor){
        return String.format(Locale.US, "Pagando R$%.1f via Cartão de Crédito", valor);
    }
}

class Boleto implements MetodoPagamento{
    @Override
    public String pagar(double valor){
        return String.format(Locale.US, "Pagando R$%.1f via Boleto", valor);
    }
}

class Pix implements MetodoPagamento{
    @Override
    public String pagar(double valor){
        return String.format(Locale.US, "Pagando R$%.1f via Pix", valor);
    }
}

public class EP4_6 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String tipo = s.nextLine().trim();
        double valor = Double.parseDouble(s.nextLine().trim());
        s.close();

        MetodoPagamento pagamento;

        if(tipo.equalsIgnoreCase("Cartao")){
            pagamento = new CartaoCredito();
        }else if(tipo.equalsIgnoreCase("Boleto")){
            pagamento = new Boleto();
        }else if(tipo.equalsIgnoreCase("Pix")){
            pagamento = new Pix();
        }else{
            System.out.println("Método de pagamento não condizente com o esperado!");
            return;
        }

        System.out.println(pagamento.pagar(valor));
    }
}
