 package Semana2;
import java.util.Scanner;

class Personagem{
    private String nome;
    private double vida;
    public Personagem(String nome, double vida){
        this.nome = nome;
        this.vida = vida;
    }

    public String getNome(){
        return nome;
    }

    public double getVida(){
        return vida;
    }

    public void atacar(Personagem alvo){

    }

    public boolean condicaoVida(){
        return vida > 0;
    }

    public double reduzirVida(double dano){
        return vida -= dano;
    }
}

class Guerreiro extends Personagem{
    private double forcaAtaque;

    public Guerreiro(String nome, double vida, double forcaAtaque){
        super(nome, vida);
        this.forcaAtaque = forcaAtaque;
    }

    @Override
    public void atacar(Personagem alvo){
        double dano = forcaAtaque;
        alvo.reduzirVida(dano);
        System.out.println(getNome() + " ataca " + alvo.getNome() + "! " +
                alvo.getNome() + " tem " + alvo.getVida() + " de vida.");
    }
}

 class Mago extends Personagem{
     private double poderMagico;

     public Mago(String nome, double vida, double poderMagico){
         super(nome, vida);
         this.poderMagico = poderMagico;
     }

     @Override
     public void atacar(Personagem alvo){
         double dano = poderMagico * 1.5;
         alvo.reduzirVida(dano);
         System.out.println(getNome() + " ataca " + alvo.getNome() + "! " +
                 alvo.getNome() + " tem " + alvo.getVida() + " de vida.");
     }
 }

class EP3_7{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        Personagem[] personagens = new Personagem[2];

        for(int i = 0; i<2; i++){
            String linha = s.nextLine();
            String[] partes = linha.split(" ");

            String tipo = partes[0];
            String nome = partes[1];
            double vida = Double.parseDouble(partes[2]);

            if(tipo.equals("G")){
                double forcaAtaque = Double.parseDouble(partes[3]);
                personagens[i] = new Guerreiro(nome, vida, forcaAtaque);
            } else if(tipo.equals("M")){
                double poderMagico = Double.parseDouble(partes[3]);
                personagens[i] = new Mago(nome, vida, poderMagico);
            }
        }

        Personagem p1 = personagens[0];
        Personagem p2 = personagens[1];

        while(p1.condicaoVida() && p2.condicaoVida()){
            p1.atacar(p2);
            if(p2.condicaoVida()){
                p2.atacar(p1);
            }
        }

        if(!p1.condicaoVida()){
            System.out.println(p1.getNome() + " foi derrotado.");
        }
        if(!p2.condicaoVida()){
            System.out.println(p2.getNome() + " foi derrotado.");
        }

        System.out.println("Batalha encerrada!");

        s.close();
    }
}
