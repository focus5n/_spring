package C04_03_receiving_notification.callback_method;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainCallbackMethod {

    public static void main(String[] args) {
        String config = "C04_03/callback-method.xml";
        String beanName01 = "callback-singer01";
        String beanName02 = "callback-singer02";
        String beanName03 = "callback-singer03";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        CallbackSinger.getBean(beanName01, context);
        CallbackSinger.getBean(beanName02, context);
        CallbackSinger.getBean(beanName03, context);

        context.close();
    }
}
