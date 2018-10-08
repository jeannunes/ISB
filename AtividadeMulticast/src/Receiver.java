import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Receiver extends Thread {

    private int n;

    Receiver(int n) {
        this.n = n;
    }

    public void run() {
        try {
            execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void execute() throws IOException {

        // TODO Auto-generated method stub
        System.out.println("Receiver " + n + " - started");

        MulticastSocket socket = new MulticastSocket(8888);
        DatagramPacket datagrama = new DatagramPacket(new byte[1024], 1024);
        socket.receive(datagrama);

        String mensagemRecebida = new String(datagrama.getData(), datagrama.getOffset(), datagrama.getLength());
        System.out.println(n + ": " + mensagemRecebida);
        String resposta = "Hi, I'm the receiver #" + n;
        InetAddress ipOrigem = datagrama.getAddress();
        int portaOrigem = datagrama.getPort();

        datagrama = new DatagramPacket(resposta.getBytes(), resposta.length(), ipOrigem, portaOrigem);
        socket.send(datagrama);
    }
}
