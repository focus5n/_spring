package C04_10_java_class;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaClass {

    public static void main(String[] args) {

        // XML, property 파일 대신 자바 클래스로 스프링 ApplicationContext 구성을 할 수 있음.
        // JavaConfig
        var config = AppConfig.class;
        String beanName = "messageRenderer";
        var beanClass = MessageRenderer.class;

        ApplicationContext context = new AnnotationConfigApplicationContext(config);
        MessageRenderer renderer = context.getBean(beanName, beanClass);

        renderer.render();
    }
}
