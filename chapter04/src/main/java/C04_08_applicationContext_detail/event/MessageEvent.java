package C04_08_applicationContext_detail.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class MessageEvent extends ApplicationEvent {

    private String message;

    public MessageEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
