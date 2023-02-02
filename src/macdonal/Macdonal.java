package macdonal;

import java.util.ArrayList;

public class Macdonal {

    boolean pedidoListo = false;

    ArrayList<String> colaPedido = new ArrayList<>();
    ArrayList<String> colaRecoger = new ArrayList<>();
    boolean cocinaAbierta = true;

    int contadorPedidos = 0;

    public Macdonal() {
        System.out.println("MACDONAL creado");
    }

    public void ponerserEnCola(Cliente cliente, String nombre) {

        Colores.imprimirAzul(nombre + " se ha metido en cola");
        colaPedido.add(nombre);
    }

    public synchronized void pedir(Cliente cliente, String nombre){
        // TODO Auto-generated method stub

        try {

            while(!colaPedido.get(0).equals(nombre)) {
                Colores.imprimirRojo(nombre + " se queria colar");
                wait();
            }
            colaPedido.remove(0);
            Colores.imprimirVerde(nombre + " Pedido realizado");
            colaRecoger.add(nombre);
            contadorPedidos = contadorPedidos + 1;
            Colores.imprimirVerde(nombre + " marcha a la cola para recoger su pedido");
            notifyAll();

        }catch (Exception e ){

            e.printStackTrace();
        }


    }

    public synchronized void esperarPedido(Cliente cliente, String nombre) {


            try {
                while(!colaRecoger.get(0).equals(nombre)) {
                    Colores.imprimirRojo(nombre + " se queria colar para esperar su pedido");
                    wait();
                }

                Colores.imprimirVerde(nombre + " esperando....");
                notifyAll();
                Thread.sleep(6000);
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public synchronized void recoger(Cliente cliente, String nombre) {
        // TODO Auto-generated method stub

        try {
            while(!colaRecoger.get(0).equals(nombre)){

                wait();
            }

            pedidoListo = false;
            Colores.imprimirVerde(nombre + " recogio su pedido correctamente y se fue.");
            contadorPedidos--;
            colaRecoger.remove(0);
            notifyAll();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


    public synchronized void cocinar(Camarero camarero) {

        try {

            while (contadorPedidos == 0);{
                Colores.imprimirRojo("esperando pedidos");
                wait();
            }
            System.out.println("Cocinando...");
            Thread.sleep(2000);
            pedidoListo = true;

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
