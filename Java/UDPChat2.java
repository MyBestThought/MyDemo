import java.util.*;
import java.net.*;
import java.io.*;
public class UDPChat2{
	public static void main(String[] args) throws Exception{
		//open port
		DatagramSocket socket = new DatagramSocket(9090);
		//receive data packet
		byte[] buffer = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
		//blocking receive
		socket.receive(packet);
		System.out.println(new String(packet.getData(), 0, packet.getLength()));
		//close connection
		socket.close();
	}
}