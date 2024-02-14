package injection;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service("injectCollection")
public class CollectionInjection {

    @Resource(name = "map")
    private Map<String, Object> map;
    @Resource(name = "props")
    private Properties properties;
    @Resource(name = "set")
    private Set set;
    @Resource(name = "list")
    private List list;

    public static void main(String... args) {

        /*
        // 컬렉션 주입
        // List, Map, Set, Properties => <list>, <map>, <set>, <props>
        String contextClasspath = "classpath:spring/app-context.xml";
        String beanName = "injectCollection";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(contextClasspath);
        context.refresh();

        injection.CollectionInjection instance = (injection.CollectionInjection) context.getBean(beanName);
        instance.displayInfo();

        context.close();
         */

        // 어노테이션 기반
        String contextClasspath = "classpath:spring/app-context-annotation.xml";
        String beanName = "injectCollection";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(contextClasspath);
        context.refresh();

        CollectionInjection instance = (CollectionInjection) context.getBean(beanName);
        instance.displayInfo();

        context.close();
    }

    public void displayInfo() {
        System.out.println("Map :");
        map.entrySet().stream().forEach(each -> System.out.println(
                "Key : " + each.getKey() + " - Value : " + each.getValue()
        ));

        System.out.println("\nProperty :");
        properties.entrySet().stream().forEach(each -> System.out.println(
                "Key : " + each.getKey() + " - Value : " + each.getValue()
        ));

        System.out.println("\nSet :");
        set.forEach(each -> System.out.println(
                "Value : " + each
        ));

        System.out.println("\nList :");
        list.forEach(each -> System.out.println(
                "Value : " + each
        ));
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }
}
