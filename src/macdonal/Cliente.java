package macdonal;

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

        }catch (Exception e) {
            // TODO: handle exception
        }

    }

}
