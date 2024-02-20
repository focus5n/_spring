package C04_05_aware;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainAware {

    public static void main(String... args) {
        String config = "C04_05/aware.xml";
        String beanName = "aware-01";
        AwareSinger bean;

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        bean = (NamedSinger) context.getBean(beanName);
        bean.sing();

        context.close();
    }
}
