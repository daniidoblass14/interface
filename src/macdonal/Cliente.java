package macdonal;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.Socket;

public class Cliente implements Runnable{

    Macdonal mac;
    String nombre;

    public Cliente(Macdonal mac,String nombre) {

        this.mac = mac;
        this.nombre = nombre;
        //System.out.println(nombre+" creado.");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        try {

            mac.ponerserEnCola(this, nombre);
            mac.pedir(this,nombre);
            //mac.esperarPedido(this,nombre);
            mac.recoger(this,nombre);
            crearCliente(nombre);

        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    private void crearCliente (String name){

        String host = "localhost";
        int puerto = 6000;
        System.out.println("Conectando con el servidor");
        Socket cliente;

        try {

            cliente = new Socket(host,puerto);

            //Creamos el flujo de salida al servidor.
            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

            //Creamos el flujo de entrada al servidor.
            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
            String cadena = name + "ha pagado";

            //Envio de mensaje al servidor.
            flujoSalida.writeUTF(cadena);

            //Recepcion de mensaje del servidor.
            System.out.println(flujoEntrada.readUTF());

            //Cierre de streams y sockets
            flujoEntrada.close();
            flujoSalida.close();
            cliente.close();

        }catch (Exception e){

            System.out.println("Problemas de conexion con el servidor. Vuelva a intentarlo");
        }
    }

}
