import java.util.*;
import java.net.*;
import java.io.*;
public class FileServer{
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket socket = serverSocket.accept();
		InputStream is = socket.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File("F:\\test\\good.jpg"));
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = is.read(buffer)) != -1){
			fos.write(buffer, 0, len);
		}
		
		
		OutputStream os = socket.getOutputStream();
		os.write("我是服务器，已经接收完毕，你可以断开了！！！".getBytes());
		
		os.close();
		fos.close();
		is.close();
		socket.close();
		serverSocket.close();
	}
}