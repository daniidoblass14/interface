package macdonal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args)
    {
        try
        {
            ServerSocket servidor;
            servidor=new ServerSocket(6000);
            System.out.println("Server Casino is running...");
            while (true) {
                Socket cliente = new Socket();
                cliente=servidor.accept();//esperando cliente
                HiloServidor hilo = new HiloServidor(cliente);
                hilo.start();
            }

        } catch (IOException e) { e.printStackTrace(); }

    }
}
