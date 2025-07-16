package Semana4;
import java.util.*;

class BibliotecaDigital{
    private static final List<String> LIVROS_DISPONIVEIS = Arrays.asList("L001", "L002", "L003");
    public static void acessarLivro(String codigo){
        try{
            System.out.println("Conectando ao servidor...");
            if(codigo == null || codigo.trim().isEmpty()){
                throw new IllegalArgumentException("Erro: Código do livro é obrigatório");
            }
            if(!LIVROS_DISPONIVEIS.contains(codigo)){
                throw new RuntimeException("Erro: Livro não encontrado");
            }

            System.out.println("Livro acessado: " + codigo);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Conexão encerrada");
        }
    }
}

class EP5_5{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String codigo = s.nextLine();
        BibliotecaDigital.acessarLivro(codigo);
        s.close();
    }
}
