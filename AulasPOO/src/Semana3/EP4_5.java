package Semana3;
import java.util.Scanner;

interface Conectavel{
    void conectar();
    void desconectar();
}

class Bluetooth implements Conectavel{
    @Override
    public void conectar(){
        System.out.println("Bluetooth conectado");
    }

    @Override
    public void desconectar(){
        System.out.println("Bluetooth desconectado");
    }
}

class WiFi implements Conectavel{
    @Override
    public void conectar(){
        System.out.println("WiFi conectado");
    }

    @Override
    public void desconectar(){
        System.out.println("WiFi desconectado");
    }
}

public class EP4_5 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String tipo = s.nextLine().trim();
        s.close();

        Conectavel conecta;

        if(tipo.equalsIgnoreCase("Bluetooth")){
            conecta = new Bluetooth();

        }else if(tipo.equalsIgnoreCase("WiFi")){
            conecta = new WiFi();

        }else {
            System.out.println("Tipo de conexão inválida.");
            return;

        }

        conecta.conectar();
        conecta.desconectar();

    }
}
