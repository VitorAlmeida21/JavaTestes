package Semana4;
import java.util.Scanner;

class IdadeInvalidaException extends Exception{
    public IdadeInvalidaException(String mensagem){
        super(mensagem);
    }
}

public class EP5_2{
    public static void ValidadorIdade(int idade) throws IdadeInvalidaException{
        if(idade <0){
            throw new IdadeInvalidaException("Idade não pode ser negativa");
        }else if ( idade >150){
            throw new IdadeInvalidaException("Idade não pode ser maior que 150 anos");
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String entrada = s.nextLine();

        try{
            int idade = Integer.parseInt(entrada);
            ValidadorIdade(idade);
            System.out.println("Idade válida: " + idade + " anos");
        }catch(NumberFormatException e){
            System.out.println("A idade deve ser um número inteiro");
        }catch(IdadeInvalidaException e){
            System.out.println(e.getMessage());
        }finally{
            s.close();
        }
    }
}
