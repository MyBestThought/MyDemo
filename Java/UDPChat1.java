import java.util.*;
import java.net.*;
import java.io.*;
//Java利用UDP协议实现简单的消息发送。
//注意：在UDP中，并不需要建立连接。所以，并没有明显的服务器和客户端的界限。
//在本例子中，以UDPChat1作为客户端，UDPChat2作为服务端，当然两者也可以反过来。如果单独运行UDPChat1，并不会报错
public class UDPChat1{
	public static void main(String[] args) throws Exception{
		//create a socket
		DatagramSocket socket = new DatagramSocket();
		String msg = "Everything will be ok!!!";
		//create a packet
		DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, InetAddress.getByName("localhost"), 9090);
		socket.send(packet);
		//close connection
		socket.close();
	}
}