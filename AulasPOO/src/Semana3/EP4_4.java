package Semana3;
import java.util.Scanner;

interface Desenhavel{
    void desenhar();
}

class Circulo implements Desenhavel{
    @Override
    public void desenhar(){
        System.out.println("Desenhando um Círculo com *");
    }
}

class Quadrado implements Desenhavel{
    @Override
    public void desenhar(){
        System.out.println("Desenhando um Quadrado com *");
    }
}

public class EP4_4 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String nome = s.nextLine().trim();
        s.close();

        Desenhavel desenho;

        if(nome.equalsIgnoreCase("Círculo") || nome.equalsIgnoreCase("Circulo")){
            /* Eu fiquei com dúvida no exercício pq não foi claro, na saída mostra círculo com acento e na
             entrada mostra sem acento */
            desenho = new Circulo();
        }else if(nome.equalsIgnoreCase("Quadrado")){
            desenho = new Quadrado();
        }else {
            System.out.println("Forma geométrica inválida!");
            return;
        }

        desenho.desenhar();
    }
}
