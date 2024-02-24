package C04_10_java_class;

public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    public StandardOutMessageRenderer() {
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public void render() {

        if (messageProvider == null) {
            throw new RuntimeException(StandardOutMessageRenderer.class.getName() + " 클래스의 messageProvider 프로퍼티를 설정해야 합니다.");
        }
    }

    @Override
    public MessageProvider getMessageProvider() {
        return null;
    }
}
