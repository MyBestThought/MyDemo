package chat;
import java.net.*;
import java.io.*;

public class TalkSender implements Runnable{
    DatagramSocket socket = null;
    BufferedReader reader = null;

    private int fromPort;
    private String toIp;
    private int toPort;

    public TalkSender(int fromPort, String toIp, int toPort){
        this.fromPort = fromPort;
        this.toIp = toIp;
        this.toPort = toPort;
        try{
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            try{
                String data = reader.readLine();
                byte[] bytes = data.getBytes();
                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress(toIp, toPort) );
                socket.send(packet);
                if(data.equals("bye")){
                    break;
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        socket.close();
    }
}
