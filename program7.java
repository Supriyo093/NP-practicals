// 7. WAP to find the address of the local machine.
import java.net.InetAddress;

public class Program7 {
  public static void main(String[] args) throws Exception {
    InetAddress localAddress = InetAddress.getLocalHost();
    String hostname = localAddress.getHostName();
    String ipAddress = localAddress.getHostAddress();
    System.out.println("Hostname: " + hostname);
    System.out.println("IP address: " + ipAddress);
  }
}