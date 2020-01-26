import java.util.*;
import java.net.*;
import java.io.*;
public class FileClient{
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream(new File("F:\\test\\1002214.jpg"));
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = fis.read(buffer))!=-1){
			os.write(buffer, 0, len);
		}
		socket.shutdownOutput();
		
		InputStream is = socket.getInputStream();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] bytes = new byte[1024];
		int len2 = 0;
		while((len2 = is.read(bytes)) != -1){
			bos.write(bytes, 0, len2);
		}
		System.out.println(bos.toString());
		bos.close();
		is.close();
		fis.close();
		os.close();
		socket.close();
	}
}