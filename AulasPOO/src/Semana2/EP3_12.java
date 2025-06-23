package Semana2;
import java.util.Scanner;

class CaixaMagica<T> {
    private T presente;

    public CaixaMagica(T presente){
        this.presente = presente;
    }

    public void processar(){
        if(presente instanceof String) {
            System.out.println("Presente: " + presente);
        }else if(presente instanceof Integer){
            System.out.println("Doces com " + presente + " calorias!");
        }else if(presente instanceof Double){
            System.out.println("Poção mágica com " + presente + " ml");
        }
    }

    public void processar(int vezes){
        StringBuilder resultado = new StringBuilder();

        for(int i = 0; i < vezes; i++){
            if(presente instanceof String){
                resultado.append("Presente: ").append(presente);
            }else if(presente instanceof Integer){
                resultado.append("Doces com ").append(presente).append(" calorias!");
            }else if(presente instanceof Double){
                resultado.append("Poção mágica com ").append(presente).append(" ml");
            }
            if(i < vezes-1){
                resultado.append("; ");
            }
        }
        System.out.println(resultado);
    }

    public void processar(String extra) {
        if(presente instanceof String){
            System.out.println("Presente: " + presente + " -> " + extra);
        }else if(presente instanceof Integer){
            System.out.println("Doces com " + presente + " calorias! -> " + extra);
        }else if(presente instanceof Double){
            System.out.println("Poção mágica com " + presente + " ml -> " + extra);
        }
    }
}

public class EP3_12 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        String tipo = s.nextLine();
        String valor = s.nextLine();
        String modo = s.nextLine();

        CaixaMagica<?> caixa = null;

        if(tipo.equals("string")){
            caixa = new CaixaMagica<>(valor);
        }else if(tipo.equals("int")){
            int valorInt = Integer.parseInt(valor);
            caixa = new CaixaMagica<>(valorInt);
        }else if(tipo.equals("double")){
            double valorDouble = Double.parseDouble(valor);
            caixa = new CaixaMagica<>(valorDouble);
        }

        if (modo.equals("simples")) {
            caixa.processar();
        } else if (modo.equals("vezes")) {
            caixa.processar(2);
        } else if (modo.equals("extra")) {
            caixa.processar("Surpresa!");
        }

        s.close();
    }
}
