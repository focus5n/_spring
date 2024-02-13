import hierarchical.Song;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HierarchicalApplicationContextUsage {

    public static void main(String... args) {
        String parentContextClasspath = "spring/parent-context.xml";
        String childContextClasspath = "spring/child-context.xml";
        String beanName01 = "song01";
        String beanName02 = "song02";
        String beanName03 = "song03";

        GenericXmlApplicationContext parentContext = new GenericXmlApplicationContext();
        parentContext.load(parentContextClasspath);
        parentContext.refresh();

        GenericXmlApplicationContext childContext = new GenericXmlApplicationContext();
        childContext.load(childContextClasspath);
        childContext.setParent(parentContext);
        childContext.refresh();

        Song song01 = (Song) childContext.getBean(beanName01);
        Song song02 = (Song) childContext.getBean(beanName02);
        Song song03 = (Song) childContext.getBean(beanName03);

        System.out.println("From Parent Context : " + song01.getTitle());
        System.out.println("From Child Context : " + song02.getTitle());
        System.out.println("From Parent Context : " + song03.getTitle());

        childContext.close();
        parentContext.close();
    }
}
