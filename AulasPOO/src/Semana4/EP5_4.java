package Semana4;
import java.util.Scanner;

class SaldoInsuficienteException extends Exception{
    public SaldoInsuficienteException(String mensagem){
        super(mensagem);
    }
}

class ValorInvalidoException extends Exception{
    public ValorInvalidoException(String mensagem){
        super(mensagem);
    }
}

class ContaBancaria{
    private double saldoInicial;
    public ContaBancaria(double saldoInicial){
        this.saldoInicial = saldoInicial;
    }

    public void depositar(double valor) throws ValorInvalidoException{
        if(valor <= 0){
            throw new ValorInvalidoException("Valor deve ser positivo");
        }
        saldoInicial += valor;
        System.out.printf("Depósito realizado. Saldo atual: R$ %.2f", saldoInicial);
    }

    public void sacar(double valor) throws ValorInvalidoException, SaldoInsuficienteException{
        if(valor <= 0){
            throw new ValorInvalidoException("Valor deve ser positivo");
        }
        if(valor > saldoInicial){
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        saldoInicial -= valor;
        System.out.printf("Saque realizado. Saldo atual: R$ %.2f", saldoInicial);
    }
}

class EP5_4{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);


        try{
            double saldoInicial = Double.parseDouble(s.nextLine());
            String operacao = s.nextLine();
            String[] partes = operacao.split(" ");
            String categoria = partes[0].toUpperCase().trim();
            double valor = Double.parseDouble(partes[1].trim());

            ContaBancaria conta = new ContaBancaria(saldoInicial);

            if(categoria.equals("DEPOSITAR")){
                conta.depositar(valor);
            }else if(categoria.equals("SACAR")){
                conta.sacar(valor);
            }

        }catch(ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println("Erro: " + e.getMessage());
        }catch(Exception e){
            System.out.println("Erro inesperado: "+ e.getMessage());
        }
        finally{
            s.close();
        }
    }
}