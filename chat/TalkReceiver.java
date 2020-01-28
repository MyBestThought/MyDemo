package chat;

import java.io.IOException;
import java.net.*;

public class TalkReceiver implements Runnable{
    DatagramSocket socket = null;

    private int port;
    private String name;

    public TalkReceiver(int port, String name){
        this.port = port;
        this.name = name;
        try {
            socket = new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    public void run(){

        while(true){
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String receiveData = new String(buffer, 0, packet.getLength());
            System.out.println(this.name + " say:" + receiveData);
            if(receiveData.equals("bye")){
                break;
            }
        }
        socket.close();
    }
}
