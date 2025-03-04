# Strategy Pattern

## About the Pattern

The Strategy Pattern is a behavioral design pattern that allows selecting an algorithm's implementation at runtime.

## Implementation

### Creating an Interface to Define the Strategy Contract

The `ChatApp` interface defines a contract that all messaging strategies must follow.

```java
public interface ChatApp {
    String sendMessage();
}
```

### Implementing the Strategies

Each strategy overrides the `sendMessage` method, returning a message indicating which strategy is being used.

```java
public class Facebook implements ChatApp {

    @Override
    public String sendMessage() {
        return "Facebook message sent";
    }
}

public class Telegram implements ChatApp {

    @Override
    public String sendMessage() {
        return "Telegram message sent";
    }
}

public class WhatsApp implements ChatApp {

    @Override
    public String sendMessage() {
        return "WhatsApp message sent";
    }
}
```

### Creating a Strategy Map

The `chatApps` map is an immutable mapping of input strings to corresponding strategy objects. If no match is found, it returns `null`.  
The `getChatApp` method provides access to the selected strategy.

```java
import java.util.Map;

public class ChatAppStrategy {
    private final Map<String, ChatApp> chatApps;

    public ChatAppStrategy() {
        this.chatApps = Map.of(
            "whatsapp", new WhatsApp(),
            "facebook", new Facebook(),
            "telegram", new Telegram()
        );
    }

    public ChatApp getChatApp(String chatApp) {
        return chatApps.get(chatApp);
    }
}
```

### Using the Strategy Pattern

Each execution will produce a different output based on the selected strategy.

```java
ChatAppStrategy strategy = new ChatAppStrategy();

System.out.println(strategy.getChatApp("whatsapp").sendMessage());
System.out.println(strategy.getChatApp("facebook").sendMessage());
System.out.println(strategy.getChatApp("telegram").sendMessage());
```