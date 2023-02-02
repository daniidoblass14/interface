package macdonal;

public class Camarero implements Runnable{

    Macdonal mac;
    String pedido;
    public Camarero(Macdonal mac) {

        this.mac = mac;
        System.out.println("Camarero creado");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        try {


        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }


    }

}