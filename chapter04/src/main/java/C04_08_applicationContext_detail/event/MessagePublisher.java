package C04_08_applicationContext_detail.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MessagePublisher implements ApplicationContextAware {
    private ApplicationContext context;

    public void publish(String message) {
        context.publishEvent(new MessageEvent(this, message));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
