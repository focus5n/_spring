package autoWiring;

import lombok.Getter;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TargetTest {

    public static void main(String[] args) {
        String config = "spring/app-auto-wiring.xml";
        String beanName = "targetByType";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        System.out.println("\nUsing byType:");
        TargetTest targetTest = (TargetTest) context.getBean(beanName);

        context.close();
    }
}
