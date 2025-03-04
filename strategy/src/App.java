import strategy.ChatAppStrategy;

public class App {
    public static void main(String[] args) throws Exception {
        ChatAppStrategy strategy = new ChatAppStrategy();
        System.out.println(strategy.getChatApp("whatsapp").sendMessage());
        System.out.println(strategy.getChatApp("facebook").sendMessage());
        System.out.println(strategy.getChatApp("telegram").sendMessage());
    }
}
