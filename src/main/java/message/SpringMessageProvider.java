package message;

public class SpringMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Provided by SpringMessageProvider";
    }
}
