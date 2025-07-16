package Semana5;
import java.util.*;

class Motor {
    int cilindros;
    int potencia;
    boolean ligado;

    public Motor(int cilindros, int potencia) {
        this.cilindros = cilindros;
        this.potencia = potencia;
        this.ligado = false;
    }
}

class Carro {
    private Motor motor;

    public Carro(int cilindros, int potencia) {
        this.motor = new Motor(cilindros, potencia);
        System.out.println("Carro criado");
    }

    public void ligar() {
        motor.ligado = true;
        System.out.println("Carro ligado");
    }

    public void desligar() {
        motor.ligado = false;
        System.out.println("Carro desligado");
    }

    public void acelerar() throws Exception {
        if (!motor.ligado) {
            throw new Exception("Erro: Motor desligado");
        }
        System.out.println("Acelerando...");
    }
}

public class EP6_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada inicial: cilindros e potencia
        int cilindros = Integer.parseInt(scanner.nextLine());
        int potencia = Integer.parseInt(scanner.nextLine());

        Carro carro = new Carro(cilindros, potencia);

        while (true) {
            String comando = scanner.nextLine();

            if (comando.equalsIgnoreCase("sair")) {
                break;
            }

            switch (comando) {
                case "ligar":
                    carro.ligar();
                    break;
                case "desligar":
                    carro.desligar();
                    break;
                case "acelerar":
                    try {
                        carro.acelerar();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        scanner.close();
    }
}

