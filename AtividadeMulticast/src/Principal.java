public class Principal {
    public static void main(String[] args) {

        // Starts the receivers
        for (int i = 0; i < 10; i++) {
            new Receiver(i).start();
        }

        // Starts the sender
        new Sender().start();

    }
}
