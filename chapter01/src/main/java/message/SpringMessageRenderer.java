package message;


public class SpringMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    @Override
    public void render(String message) {
        if (messageProvider != null) {
            System.out.println(messageProvider.getMessage(message));
        } else {
            throw new RuntimeException("Set the message provider.");
        }
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
