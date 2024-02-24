package C04_10_java_class;

public class ConfigurableMessageProvider implements MessageProvider {
    private String message = "Default Message";

    public ConfigurableMessageProvider() {
    }

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return null;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
