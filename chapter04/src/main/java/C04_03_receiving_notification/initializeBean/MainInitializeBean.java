package C04_03_receiving_notification.initializeBean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainInitializeBean {

    public static void main(String[] args) {
        String config = "C04_03/initialize-bean.xml";
        String beanName01 = "init-singer01";
        String beanName02 = "init-singer02";
        String beanName03 = "init-singer03";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        var beanNames = context.getBeanDefinitionNames();
        for (var beanName : beanNames) {
            System.out.println("Bean Name : " + beanName);
        }
        System.out.println("");

        InitSinger.getBean(beanName01, context);
        InitSinger.getBean(beanName02, context);
        InitSinger.getBean(beanName03, context);

        context.close();
    }
}
