package strategy;

import java.util.HashMap;
import java.util.Map;

import message.ChatApp;
import message.Facebook;
import message.Telegram;
import message.WhatsApp;

public class ChatAppStrategy {
    private final Map<String, ChatApp> chatApps;

    public ChatAppStrategy() {
        this.chatApps = Map.of(
            "whatsapp", new WhatsApp(),
            "facebook", new Facebook(),
            "telegram", new Telegram()
        );
    }

    public ChatApp getChatApp(String chatApp){
        return chatApps.get(chatApp);
    }
    
}
