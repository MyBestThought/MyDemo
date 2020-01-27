import java.util.*;
import java.net.*;
import java.io.*;
public class UDPSender{
	public static void main(String[] args) throws Exception{
		DatagramSocket socket = new DatagramSocket(6666);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String data = reader.readLine();
			byte[] bytes = data.getBytes();
			System.out.println(bytes.length);
			DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress("localhost", 9999) );
			socket.send(packet);
			if(data.equals("bye")){
				break;
			}
		}
		socket.close();
	}
}