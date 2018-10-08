import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class Coordinator extends Thread {

    private DatagramSocket uSocket;
    private ArrayList<String> ids;

    private Coordinator() {
        ids = new ArrayList<>();
        try {
            uSocket = new DatagramSocket();

            int porta = 8080;
            InetAddress endereco = InetAddress.getByName("224.0.0.1");

            // Manda o sinal
            String msg = "cheguei";
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), endereco, porta);
            uSocket.send(packet);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Coordinator c = new Coordinator();
        c.start();
    }

    public void run() {

        // Limita a 10 segundos
        try {
            uSocket.setSoTimeout(10 * 1000);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        while (true) {
            try {

                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                uSocket.receive(packet);

                if (get() == 0)
                    uSocket.setSoTimeout(5 * 1000);

                String msg2 = new String(packet.getData(), packet.getOffset(), packet.getLength());
                add(msg2);
                System.out.println(get() + " usuários");


            } catch (SocketTimeoutException e) {
                System.out.println("O tempo acabou!");
                System.out.println(get() + " respostas");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int get() {
        return ids.size();
    }

    private void add(String word) {
        if (!ids.contains(word))
            ids.add(word);
    }

}
