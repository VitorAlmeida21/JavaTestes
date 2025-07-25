package Semana4;
import java.util.*;

//EP5_6 – Validador de Personagem
class AtributoInvalidoException extends Exception {
    public AtributoInvalidoException(String mensagem) {
        super(mensagem);
    }
}

class PersonagemInvalidoException extends Exception {
    public PersonagemInvalidoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

class ValidadorPersonagem {
    private static final List<String> CLASSES_VALIDAS = Arrays.asList("Guerreiro", "Mago", "Arqueiro");

    public static void validarPersonagem(String nome, int nivel, String classe) throws PersonagemInvalidoException {
        try {
            // 1. Nome não pode ser vazio
            if (nome == null || nome.trim().isEmpty()) {
                throw new AtributoInvalidoException("Nome é obrigatório");
            }

            // 2. Nível deve estar entre 1 e 100
            if (nivel < 1 || nivel > 100) {
                throw new AtributoInvalidoException("Nível deve estar entre 1 e 100");
            }

            // 3. Classe deve ser válida
            if (!CLASSES_VALIDAS.contains(classe)) {
                throw new AtributoInvalidoException("Classe inválida");
            }

            // Se tudo certo
            System.out.println("Personagem válido: " + nome + " - " + classe + " Nível " + nivel);

        } catch (AtributoInvalidoException e) {
            // Relança como exceção encadeada
            throw new PersonagemInvalidoException("Erro na validação", e);
        }
    }
}

public class EP5_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura das 3 linhas de entrada
        String nome = scanner.nextLine();       // Linha 1 → Nome
        String nivelStr = scanner.nextLine();   // Linha 2 → Nível (string)
        String classe = scanner.nextLine();     // Linha 3 → Classe

        try {
            // ✅ Primeiro valida se nome está vazio antes de converter nível
            if (nome == null || nome.trim().isEmpty()) {
                throw new PersonagemInvalidoException("Erro na validação", new AtributoInvalidoException("Nome é obrigatório"));
            }

            // ✅ Converte o nível
            int nivel = Integer.parseInt(nivelStr);

            // ✅ Chama o validador para nível/classe
            ValidadorPersonagem.validarPersonagem(nome, nivel, classe);

        } catch (NumberFormatException e) {
            // Se nível não for número válido
            System.out.println("Erro na validação: Nível deve ser um número inteiro");
        } catch (PersonagemInvalidoException e) {
            // Mostra apenas a causa do erro
            System.out.println("Erro na validação: " + e.getCause().getMessage());
        } finally {
            scanner.close();
        }
    }
}

