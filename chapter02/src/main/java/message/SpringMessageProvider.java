package message;

public class SpringMessageProvider implements MessageProvider {

    @Override
    public String getMessage(String message) {
        return message;
    }
}
