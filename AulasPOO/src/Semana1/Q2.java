package Semana1;
import java.util.Scanner;

/*
Faça um programa que peça a avaliação de um usuário. O programa recebe notas (inteiras) de 1 a 5. Se um valor diferente
for fornecido, o sistema deve alertar para o erro e fazer uma nova tentativa. O programa só encerra ao receber uma nota
de 1 a 5.

Inicie imprimindo a mensagem "Avalie nosso serviço com uma nota de 1 a 5:". Caso o usuário forneça uma nota inválida,
imprima "O valor fornecido é inválido. Por favor, tente novamente:".

Caso o usuário forneça uma avaliação de 3 a 5, imprima: "Obrigado pela avaliação, esperamos futuras visitas!"; caso a
avaliação seja de 1 ou 2, imprima: "Obrigado pela avaliação, tentaremos melhorar para sua próxima visita!"
*/

public class Q2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int nota = 0;
        boolean notaValida = false;

        System.out.println("Avalie nosso serviço com uma nota de 1 a 5:");

        while(!notaValida){
            if(scanner.hasNextInt()){
                nota = scanner.nextInt();

                if(nota>=1 && nota<=5){
                    notaValida = true;
                }else{
                    System.out.println("O valor fornecido é inválido. Por favor, tente novamente:");
                }
            }else{
                scanner.next();
                System.out.println("O valor fornecido é inválido. Por favor, tente novamente:");
            }
        }

        if(nota>=3 && nota <=5){
            System.out.println("Obrigado pela avaliação, esperamos futuras visitas!");
        }else{
            System.out.println("Obrigado pela avaliação, tentaremos melhorar para sua próxima visita!");
        }

        scanner.close();


    }

}
