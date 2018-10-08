import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class Server {

    private static MulticastSocket socket;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Seu nome: ");
        String username = scanner.nextLine();

        socket = new MulticastSocket();
        socket.joinGroup(InetAddress.getByName("224.0.0.1"));

        new Thread(() -> {
            while (true) {
                System.out.println("Mensagem:");
                String text = scanner.nextLine();
                String msg = username + ":::" + text;
                DatagramPacket datagram = null;
                datagram = new DatagramPacket(msg.getBytes(), msg.length(), socket.getLocalAddress(), socket.getLocalPort());
                try {
                    socket.send(datagram);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                DatagramPacket datagrama = new DatagramPacket(new byte[1024], 1024);
                try {
                    socket.receive(datagrama);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String wrapper = new String(datagrama.getData(), datagrama.getOffset(), datagrama.getLength());
                String[] msg = wrapper.split(":::", 1);
                System.out.println(msg[0] + ": " + msg[1]);
            }
        }).start();

    }

}