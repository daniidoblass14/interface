package macdonal;

public class Camarero implements Runnable{

    Macdonal mac;
    public Camarero(Macdonal mac) {

        this.mac = mac;
        System.out.println("Camarero creado");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        try {

            while(mac.cocinaAbierta){

                mac.cocinar(this);
            }


        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }


    }

}