package resolve;

import methodInjection.Singer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringResolve {

    public static void main(String[] args) {
        
        // 스프링은 구성을 통해서 명시된 의존성만 인식한다.
        // 만약 구성을 하지 않은 상태에서 context.getBean(beanName)을 통해서 인스턴스를 얻는다면,
        // beanName 내부에 설정된 다른 빈 타입에 대한 의존성을 획득하지 않는다.
        // 스프링이 의존성을 알게하려면, 해당 클래스가 ApplicationContextAware 인터페이스를 구현해야 한다.
        String resourceClasspath = "spring/app-resolve.xml";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(resourceClasspath);
        context.refresh();

        SpringSinger HansMayor = context.getBean("HansMayor", SpringSinger.class);
        HansMayor.sing();

        context.close();
    }
}
