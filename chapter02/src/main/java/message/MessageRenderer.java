package message;

public interface MessageRenderer {
    void render(String message);
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
