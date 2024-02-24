package C04_10_java_class;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    public ConfigurableMessageProvider() {
    }

    public ConfigurableMessageProvider(@Value("정상적으로 작동함?")String message) {
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
