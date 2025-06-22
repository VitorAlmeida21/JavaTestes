package Semana2;
import java.util.Scanner;

class Cliente{
    public double calcularDesconto(double valor){
        return valor;
    }
}

class ClienteRegular extends Cliente{
    @Override
    public double calcularDesconto(double valor){
        if(valor > 100){
            return (valor*0.95);
        }
        return (valor);
    }
}

class ClienteVip extends Cliente{
    @Override
    public double calcularDesconto(double valor){
        if (valor > 200){
            return (valor*0.85);
        } else if (valor > 50){
            return (valor* 0.90);
        }
        return(valor);
    }
}

class ClientePremium extends Cliente{
    @Override
    public double calcularDesconto(double valor){
        return (valor*0.80);
    }
}

public class EP3_4 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int tipoCliente = Integer.parseInt(s.nextLine());
        double valor =  Double.parseDouble(s.nextLine());

        Cliente cliente;

        if(tipoCliente == 1){
            cliente = new ClienteRegular();
        }else if(tipoCliente == 2){
            cliente = new ClienteVip();
        }else if(tipoCliente == 3){
            cliente = new ClientePremium();
        }else {
            cliente = new Cliente();
        }

        double valorFinal = cliente.calcularDesconto(valor);

        System.out.printf("%.2f\n", valorFinal);

        s.close();

    }
}
