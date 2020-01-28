package chat;

public class Teacher {
    public static void main(String[] args) {
        new Thread(new TalkSender(8888, "localhost", 9999)).start();
        new Thread(new TalkReceiver(7777, "teacher")).start();
    }
}
