// 2. Simulate and implement stop and wait protocol for noisy channel. 

    import java.util.Random;

    public class Program2 {
    private static final int MAX_PACKET_LOSS_RATE = 2;
    private static final int MAX_PACKET_ERROR_RATE = 2;
    private static final int WINDOW_SIZE = 1;

    public static void main(String[] args) {
        Random random = new Random();
        int packetNumber = 0;

        while (true) {
            Packet packet = new Packet(packetNumber);
            int packetLossRate = random.nextInt(5);
            if (packetLossRate < MAX_PACKET_LOSS_RATE) {
                System.out.println("Packet lost: " + packet);
                continue;
            }          
            System.out.println("Sending packet: " + packet);
            boolean packetReceived = false;
          
            while (!packetReceived) {
                int packetErrorRate = random.nextInt(5);
                if (packetErrorRate < MAX_PACKET_ERROR_RATE) {
                    System.out.println("Packet error: " + packet);
                } else {
                    packetReceived = true;
                    System.out.println("Packet received: " + packet);
                }
            }

            packetNumber++;
        }
    }
}

class Packet {
    private int packetNumber;

    public Packet(int packetNumber) {
        this.packetNumber = packetNumber;
    }

    @Override
    public String toString() {
        return "Packet " + packetNumber;
    }
}