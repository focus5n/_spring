package methodInjection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupConfigDemo {

    @Configuration
    @ComponentScan(basePackages = {"methodInjection"})
    public static class LookupConfig {}

    public static void main(String[] args) {
        String contextClasspath = "spring/app-context-annotation.xml";
        String beanName01 = "abstractLookupBean";
        String beanName02 = "standardLookupBean";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        LookupDemo instance = new LookupDemo();

        context.load(contextClasspath);
        context.refresh();

        DemoBean abstractBean = context.getBean(beanName01, DemoBean.class);
        DemoBean standardBean = context.getBean(beanName02, DemoBean.class);

        instance.displayInfo(beanName01, abstractBean);
        instance.displayInfo(beanName02, standardBean);

        context.close();
    }
}
