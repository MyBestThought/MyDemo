import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class URLTest {
    public static void main(String[] args) throws Exception{
        URL url = new URL("your URL");

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream in = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("F:\\test\\bb.mp4"));
        byte[] buffer = new byte[2048];
        int len = 0;
        while((len=in.read()) != -1){
            fos.write(buffer, 0, len);
        }

        fos.close();
        in.close();
        urlConnection.disconnect();
    }
}
