package C04_08_applicationContext_detail.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEvent {

    public static void main(String[] args) {
        String config = "C04_08/event.xml";
        String beanName = "event-publisher-bean-01";

        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        var publisher = context.getBean(beanName, MessagePublisher.class);

        publisher.publish("크흨 내 오른팔에 담긴 흑염룡을 억제할 수 없어...!");
        publisher.publish("크흨 내 왼팔에 담긴 창염룡을 억제할 수 없어...!");
        publisher.publish("크흨 내 가슴에 새긴 백염룡을 억제할 수 없어...!");
    }
}
