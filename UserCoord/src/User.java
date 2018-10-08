import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class User extends Thread {

    private MulticastSocket mSocket;
    private DatagramSocket uSocket;
    private int port;

    private User() {
        try {
            mSocket = new MulticastSocket(8080);
            InetAddress endereco = InetAddress.getByName("224.0.0.1");
            mSocket.joinGroup(endereco);
            uSocket = new DatagramSocket();
            port = uSocket.getLocalPort();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        User u = new User();
        u.start();
    }

    public void run() {
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                mSocket.receive(packet);
                String msg = String.valueOf(port);
                packet = new DatagramPacket(msg.getBytes(), msg.length(), packet.getAddress(), packet.getPort());
                System.out.println("Respondendo para " + packet.getAddress().getHostName() + ":" + packet.getPort());
                System.out.println(msg);
                uSocket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }


}
