import java.net.*;
import java.util.*;
import java.io.*;
public class SampleServer{
	public static void main(String[] args){
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream is = null;
		ByteArrayOutputStream bos  = null;
		try{
			serverSocket = new ServerSocket(9999);
			socket = serverSocket.accept();
			is = socket.getInputStream();
			bos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len =is.read(buffer)) != -1){
				bos.write(buffer, 0, len);
			}
			System.out.println(bos.toString());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(bos != null){
				try{
					bos.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(is != null){
				try{
					is.close();
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
			if(serverSocket != null){
				try{
					serverSocket.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
	}
}