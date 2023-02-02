package macdonal;

public class Principal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Macdonal mac = new Macdonal();

        for (int i = 1; i <= 4; i++) {

            Thread cliente = new Thread(new Cliente(mac,"Cliente "+i));
            cliente.start();
        }

        Thread camarero = new Thread(new Camarero(mac));
        camarero.start();
    }

}
