package Semana5;
import java.util.*;
//EP6_1 – Biblioteca

class Livro {
    String titulo;
    String autor;
    String isbn;

    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }
}

class Usuario {
    String nome;
    String email;
    List<Livro> livrosEmprestados = new ArrayList<>();

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void emprestarLivro(Livro livro) {
        livrosEmprestados.add(livro);
        System.out.println("Livro emprestado: " + livro.titulo);
    }

    public void devolverLivro(Livro livro) {
        livrosEmprestados.remove(livro);
        System.out.println("Livro devolvido: " + livro.titulo);
    }

    public void listarEmprestimos() {
        if (livrosEmprestados.isEmpty()) {
            System.out.println(); // linha vazia se nenhum empréstimo
            return;
        }
        List<String> titulos = new ArrayList<>();
        for (Livro l : livrosEmprestados) {
            titulos.add(l.titulo);
        }
        System.out.println(String.join(", ", titulos));
    }
}

public class EP6_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Cadastro de livros
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Livro> acervo = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String titulo = scanner.nextLine();
            String autor = scanner.nextLine();
            String isbn = scanner.nextLine();
            Livro livro = new Livro(titulo, autor, isbn);
            acervo.put(titulo, livro);
        }

        // 2. Cadastro de usuário
        String nomeUsuario = scanner.nextLine();
        String emailUsuario = scanner.nextLine();
        Usuario usuario = new Usuario(nomeUsuario, emailUsuario);

        // 3. Processar comandos
        while (true) {
            String comando = scanner.nextLine();
            if (comando.equalsIgnoreCase("sair")) {
                break;
            } else if (comando.startsWith("Emprestar: ")) {
                String titulo = comando.substring("Emprestar: ".length());
                Livro livro = acervo.get(titulo);
                if (livro != null) {
                    usuario.emprestarLivro(livro);
                }
            } else if (comando.startsWith("Devolver: ")) {
                String titulo = comando.substring("Devolver: ".length());
                Livro livro = acervo.get(titulo);
                if (livro != null) {
                    usuario.devolverLivro(livro);
                }
            } else if (comando.equals("Listar empréstimos")) {
                usuario.listarEmprestimos();
            }
        }

        scanner.close();
    }
}
