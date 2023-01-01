// 8. WAP A program that prints the address of www.youtube.com
import java.net.InetAddress;

public class Program8 {
  public static void main(String[] args) throws Exception {
    InetAddress address = InetAddress.getByName("www.youtube.com");
    String ipAddress = address.getHostAddress();
    System.out.println(ipAddress);
  }
}