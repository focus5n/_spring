package C04_03_receiving_notification.destroyBeans;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainDestroyBeans {

    public static void main(String[] args) {

        /*
        String config = "C04_03/destroy-beans.xml";
        String beanName = "destroy-beans01";
        DestructiveBean bean;

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        bean = (DestructiveBean) context.getBean(beanName);

        System.out.println("Call Start");
        bean.destroy();
        System.out.println("Call End");

        context.close();
         */

        /*
        String config = "C04_03/destroy-beans-interface.xml";
        String beanName = "destroy-interface-bean-01";
        DestructiveBeanWithInterface bean;

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        bean = (DestructiveBeanWithInterface) context.getBean(beanName);

        System.out.println(":::::: Call Bean Start ::::::");
        bean.destroy();
        System.out.println(":::::: Call Bean End   ::::::");

        context.close();
         */

        String config = "C04_03/destroy-beans-jsr.xml";
        String beanName = "destroy-jsr-bean-01";
        DestructiveBeanWithJSR250 bean;

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        bean = (DestructiveBeanWithJSR250) context.getBean(beanName);

        System.out.println(":::::: Call Bean STT ::::::");
        bean.destroy();
        System.out.println(":::::: Call Bean END ::::::" + "\n");

        context.close();
    }
}
