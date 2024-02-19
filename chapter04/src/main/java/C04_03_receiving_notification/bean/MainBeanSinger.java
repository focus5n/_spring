package C04_03_receiving_notification.bean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainBeanSinger {

    public static void main(String[] args) {
        String beanName01 = "singer01";
        String beanName02 = "singer02";
        String beanName03 = "singer03";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext(BeanSingerConfig.SingerConfig.class);

        System.out.println(context.getBeanDefinitionNames().length);
        var beanNames = context.getBeanDefinitionNames();
        for (var beanName : beanNames) {
            System.out.println("Bean Name : " + beanName);
        }
        System.out.println("");

        BeanSinger.getBean(beanName01, context);
        BeanSinger.getBean(beanName02, context);
        BeanSinger.getBean(beanName03, context);

        context.close();
    }
}
