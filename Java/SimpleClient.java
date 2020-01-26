import java.net.*;
import java.util.*;
import java.io.*;
public class SampleClient{
	public static void main(String[] args){
		Socket socket = null;
		OutputStream os  = null;
		try{
			InetAddress address = InetAddress.getLocalHost();
			int port = 9999;
			socket = new Socket(address, port);
			os = socket.getOutputStream();
			os.write(new String("Hello I am so charming!!!").getBytes());
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(os != null){
				try{
					os.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(socket != null){
				try{
					socket.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}
}