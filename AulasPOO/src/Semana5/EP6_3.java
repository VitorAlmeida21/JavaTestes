/*package Semana5;
import java.util.*;

// Exceção customizada para simular ValueError
class ValueError extends Exception {
    public ValueError(String mensagem) {
        super(mensagem);
    }
}

// Interface comum para todos os dispositivos
interface Dispositivo {
    void ligar();
    void desligar();
    String status();
}

// Implementação de uma Lâmpada
class Lampada implements Dispositivo {
    private final String nome;
    private boolean ligado;

    public Lampada(String nome) {
        this.nome = nome;
        this.ligado = false;
    }

    @Override
    public void ligar() {
        ligado = true;
        System.out.println("Lampada " + nome + " ligada.");
    }

    @Override
    public void desligar() {
        ligado = false;
    }

    @Override
    public String status() {
        return "Lampada " + nome + ": " + (ligado ? "ligado" : "desligado");
    }
}

// Implementação de um Ar Condicionado
class ArCondicionado implements Dispositivo {
    private final String nome;
    private boolean ligado;

    public ArCondicionado(String nome) {
        this.nome = nome;
        this.ligado = false;
    }

    @Override
    public void ligar() {
        ligado = true;
        System.out.println("Ar_Condicionado " + nome + " ligado.");
    }

    @Override
    public void desligar() {
        ligado = false;
    }

    @Override
    public String status() {
        return "Ar_Condicionado " + nome + ": " + (ligado ? "ligado" : "desligado");
    }
}

// Classe Casa que faz a composição dos dispositivos
class Casa {
    private final List<Dispositivo> dispositivos = new ArrayList<>();

    public void adicionarDispositivo(String tipo, String nome) throws ValueError {
        // cria dispositivo baseado no tipo
        if (tipo.equalsIgnoreCase("lampada")) {
            dispositivos.add(new Lampada(nome));
            System.out.println("Lampada adicionada");
        } else if (tipo.equalsIgnoreCase("ar_condicionado")) {
            dispositivos.add(new ArCondicionado(nome));
            System.out.println("Ar_Condicionado adicionado");
        } else {
            throw new ValueError("Dispositivo inválido");
        }
    }

    public void ligarTodos() {
        for (Dispositivo d : dispositivos) {
            d.ligar();
        }
        System.out.println("Todos os dispositivos ligados");
    }

    public void statusCasa() {
        for (Dispositivo d : dispositivos) {
            System.out.println(d.status());
        }
    }
}

public class EP6_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Casa casa = null;

        while (true) {
            String comando = sc.nextLine().trim();

            if (comando.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                if (comando.equalsIgnoreCase("casa()")) {
                    casa = new Casa();
                    System.out.println("Casa criada");

                } else if (comando.startsWith("adicionar;")) {
                    if (casa == null) continue;

                    // Quebra o comando em partes
                    String[] partes = comando.split(";");
                    // Verifica se tem pelo menos tipo e nome
                    if (partes.length < 3) {
                        throw new ValueError("Dispositivo inválido");
                    }

                    String tipo = partes[1].trim();
                    String nome = partes[2].trim();

                    if (nome.isEmpty()) {
                        throw new ValueError("Dispositivo inválido");
                    }

                    casa.adicionarDispositivo(tipo, nome);

                } else if (comando.equalsIgnoreCase("ligar_todos")) {
                    if (casa != null) {
                        casa.ligarTodos();
                    }

                } else if (comando.equalsIgnoreCase("status_casa")) {
                    if (casa != null) {
                        casa.statusCasa();
                    }

                }

            } catch (ValueError e) {
                System.out.println("ValueError: " + e.getMessage());
            }
        }

        sc.close();
    }
}
*/