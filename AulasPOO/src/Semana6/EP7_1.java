package Semana6;
import java.util.Scanner;

class ConfiguracaoBanco{
    private static ConfiguracaoBanco instancia;
    private double taxaJuros;
    public ConfiguracaoBanco(double taxaJuros){
        this.taxaJuros = taxaJuros;
        System.out.println("Instância criada");
    }

    public static ConfiguracaoBanco getInstancia(double taxaInicial){
        if(instancia == null){
            instancia = new ConfiguracaoBanco(taxaInicial);
        }else{
            System.out.println("Instância já existente");
        }

        return instancia;
    }

    public void set_taxa_juros(double novaTaxa){
        taxaJuros = novaTaxa;
        System.out.printf("Taxa definida: %.1f\n", novaTaxa);
    }

    public void get_taxa_juros(){
        System.out.printf("Taxa atual: %.1f\n", taxaJuros);
    }

}

class EP7_1{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        double taxaInicial = Double.parseDouble(s.nextLine());
        String tipo = s.nextLine().toLowerCase();

        ConfiguracaoBanco config = ConfiguracaoBanco.getInstancia(taxaInicial);

        switch(tipo){
            case("get_taxa"):
                config.get_taxa_juros();
                break;
            case("set_new_taxa"):
                double novaTaxa = Double.parseDouble(s.nextLine());
                config.set_taxa_juros(novaTaxa);
                break;
            case("nova_instancia"):
                ConfiguracaoBanco.getInstancia(taxaInicial);
                break;
        }

        s.close();
    }
}
