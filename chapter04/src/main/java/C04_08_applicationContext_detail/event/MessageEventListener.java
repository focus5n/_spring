package C04_08_applicationContext_detail.event;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent event) {
        MessageEvent messageEvent = event;
        System.out.println("수신 : " + messageEvent.getMessage());
    }
}
