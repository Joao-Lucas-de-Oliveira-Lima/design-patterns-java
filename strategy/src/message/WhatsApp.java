package message;

public class WhatsApp implements ChatApp{

    @Override
    public String sendMessage() {
        return "WhatsApp message sent";
    }
    
}
