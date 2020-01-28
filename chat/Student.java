package chat;

public class Student {
    public static void main(String[] args) {
        new Thread(new TalkSender(6666, "localhost", 7777)).start();
        new Thread(new TalkReceiver(9999, "student")).start();
    }
}
