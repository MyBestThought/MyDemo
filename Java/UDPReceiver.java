import java.util.*;
import java.net.*;
public class UDPReceiver{
	public static void main(String[] args) throws Exception{
		DatagramSocket socket = new DatagramSocket(9999);
		while(true){
			byte[] buffer = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
			socket.receive(packet);

			String receiveData = new String(buffer, 0, packet.getLength());
			System.out.println("[data]:" + receiveData);
			if(receiveData.equals("bye")){
				break;
			}
		}
		socket.close();
		
	}
}