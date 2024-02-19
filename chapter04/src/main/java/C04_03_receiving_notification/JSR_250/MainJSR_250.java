package C04_03_receiving_notification.JSR_250;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainJSR_250 {

    public static void main(String[] args) {
        String config = "classpath:C04_03/jsr-250.xml";
        String beanName01 = "jsr-singer01";
        String beanName02 = "jsr-singer02";
        String beanName03 = "jsr-singer03";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        var beanNames = context.getBeanDefinitionNames();
        for (var beanName : beanNames) {
            System.out.println("Bean Name : " + beanName);
        }
        System.out.println("");

        JSR_Singer.getBean(beanName01, context);
        JSR_Singer.getBean(beanName02, context);
        JSR_Singer.getBean(beanName03, context);


        context.close();
    }
}
