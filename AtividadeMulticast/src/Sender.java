import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender extends Thread {

    public void run() {
        try {
            execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void execute() throws IOException {
        // TODO Auto-generated method stub
        System.out.println("Remetente inicializado");
        DatagramSocket socket = new DatagramSocket();
        int port = 8888;
        InetAddress addr = InetAddress.getByName("224.0.0.1");
        String msg = "Hi, I need you to know me!";
        DatagramPacket datagram = new DatagramPacket(msg.getBytes(), msg.length(), addr, port);
        socket.send(datagram);
        datagram = new DatagramPacket(new byte[1024], 1024);
        socket.receive(datagram);
        msg = new String(datagram.getData(), datagram.getOffset(), datagram.getLength());
        System.out.println(msg);
    }

}
