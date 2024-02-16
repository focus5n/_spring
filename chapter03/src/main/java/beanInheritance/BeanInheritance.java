package beanInheritance;

import beanInheritance.component.Singer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanInheritance {

    public static void main(String[] args) {

        String config = "bean-inheritance/bean-inheritance.xml";
        String beanName01 = "parent";
        String beanName02 = "child";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        Singer parent = (Singer) context.getBean(beanName01);
        Singer child = (Singer) context.getBean(beanName02);

        System.out.println("부모:\n" + parent);
        System.out.println("자식:\n" + child);

        context.close();
    }
}
