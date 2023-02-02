package macdonal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloServidor extends Thread{

    DataInputStream fentrada;
    DataOutputStream fsalida;
    Socket socket = null;

    public HiloServidor (Socket s) throws IOException {
        socket = s;
        // se crean flujos de entrada y salida
        fsalida = new DataOutputStream(socket.getOutputStream());
        fentrada = new DataInputStream(socket.getInputStream());
    }

    public void run(){

        System.out.println("COMUNICO CON: " + socket.toString());
        String cadena = "";
        try {
            cadena = fentrada.readUTF(); // obtener cadena
            System.out.println(cadena);
            fsalida.writeUTF("Gracias "+cadena.substring(0,9));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("FIN CON: " + socket.toString());
        try {
            fsalida.close();
            fentrada.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
