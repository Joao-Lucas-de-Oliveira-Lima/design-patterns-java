package message;

public class Telegram implements ChatApp{

    @Override
    public String sendMessage() {
        return "Telegram message sent";
    }
    
}
