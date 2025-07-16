package Semana4;
import java.util.*;

class ConexaoBanco implements AutoCloseable {
    public ConexaoBanco() {
        System.out.println("Conexão com banco estabelecida");
    }

    @Override
    public void close() {
        System.out.println("Conexão com banco fechada");
    }
}

class SistemaReservas {
    private static final List<String> VEICULOS_DISPONIVEIS = Arrays.asList("V001", "V002", "V003");

    public void processarReserva(String codigoVeiculo) throws Exception {
        if (!VEICULOS_DISPONIVEIS.contains(codigoVeiculo)) {
            throw new Exception("Veículo não disponível");
        }
        System.out.println("Reserva confirmada: " + codigoVeiculo);
    }
}

public class EP5_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String codigoVeiculo = scanner.nextLine(); // Ex: V001 ou V999
        scanner.close();

        // try-with-resources garante fechamento automático
        try (ConexaoBanco conexao = new ConexaoBanco()) {
            SistemaReservas sistema = new SistemaReservas();
            try {
                sistema.processarReserva(codigoVeiculo);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}

