package C04_12_environment;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

public class MainEnvironment {

//    public static void main(String... args) {
//
//        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
//        context.refresh();
//
//        ConfigurableEnvironment environment = context.getEnvironment();
//        MutablePropertySources propertySources = environment.getPropertySources();
//
//        Map<String, Object> applicationMap = new HashMap<>();
//        applicationMap.put("application.home", "application_home");
//        propertySources.addLast(new MapPropertySource("hanSpring_MAP", applicationMap));
//
//        System.out.println("user.home : " + System.getProperty("user.home"));
//        System.out.println("JAVA_HOME : " + System.getProperty("JAVA_HOME"));
//
//        System.out.println("user_home : " + environment.getProperty("user.home"));
//        System.out.println("JAVA_HOME : " + environment.getProperty("JAVA_HOME"));
//        System.out.println("application.home : " + environment.getProperty("application.home"));
//
//        context.close();
//    }

    public static void main(String... args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.refresh();

        ConfigurableEnvironment environment = context.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();

        Map<String, Object> applicationMap = new HashMap<>();
        applicationMap.put("user.home", "dfsdfsd");
        propertySources.addFirst(new MapPropertySource("hanSpring_MAP", applicationMap));

        System.out.println("user.home : " + System.getProperty("user.home"));
        System.out.println("JAVA_HOME : " + System.getProperty("JAVA_HOME"));

        System.out.println("user_home : " + environment.getProperty("user.home"));
        System.out.println("JAVA_HOME : " + environment.getProperty("JAVA_HOME"));
        System.out.println("application.home : " + environment.getProperty("application.home"));

        context.close();
    }
}
