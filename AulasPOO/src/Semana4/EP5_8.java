package Semana4;
import java.util.*;
//EP5_8 – Sistema Hospitalar com múltiplas exceções
class PacienteException extends Exception {
    public PacienteException(String mensagem) {
        super(mensagem);
    }
}

class ProntuarioException extends Exception {
    public ProntuarioException(String mensagem) {
        super(mensagem);
    }
}

class SistemaException extends Exception {
    public SistemaException(String mensagem) {
        super(mensagem);
    }
}

class SistemaHospitalar {

    public void processarAtendimento(String cpf, String prontuario) throws PacienteException, ProntuarioException, SistemaException {
        // ✅ Valida CPF (11 dígitos)
        if (cpf.length() != 11) {
            throw new PacienteException("CPF deve ter 11 dígitos");
        }

        // ✅ Valida prontuário (6 dígitos)
        if (prontuario.length() != 6) {
            throw new ProntuarioException("Prontuário deve ter 6 dígitos");
        }

        // ✅ Simula erro de sistema com 30% de chance
        if (new Random().nextInt(10) < 3) {
            throw new SistemaException("Erro inesperado no sistema");
        }

        // ✅ Se tudo correto
        System.out.println("Atendimento processado com sucesso");
    }

    public void logError(Exception e) {
        String tipo = e.getClass().getSimpleName(); // nome simples da exceção
        System.out.println("ERRO [" + tipo + "]: " + e.getMessage());
    }
}

public class EP5_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura de duas linhas (CPF e prontuário)
        String cpf = scanner.nextLine();        // Ex: 12345678901
        String prontuario = scanner.nextLine(); // Ex: 123456

        SistemaHospitalar sistema = new SistemaHospitalar();

        try {
            sistema.processarAtendimento(cpf, prontuario);
        } catch (Exception e) {
            // Faz log detalhado
            sistema.logError(e);
            // Mensagem amigável
            System.out.println("Erro no atendimento. Contate o administrador.");
        } finally {
            scanner.close();
        }
    }
}

