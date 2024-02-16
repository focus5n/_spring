package autoWiring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainAutoWiring {

    public static void main(String[] args) {
        
        // 스프링은 다섯 가지 방법으로 의존성을 자동으로 주입한다.
        // byName : 프로퍼티와 이름이 같은 빈을 찾아서 연결
        // byType : ApplicationContext 내부에 생성된 동일한 타입의 빈에 연결 (수정자에 의한 주입)
        // Constructor : byType 동일하지만 생성자에 의한 주입
        // Default : 스프링은 기본적으로 Constructor 방식을 채택하고, 기본 생성자가 없다면 byType 방식을 채택함.
        // no : 자동으로 연결하지 않는 상태며, 기본값이다.
        String config = "spring/app-auto-wiring.xml";
        String beanName01 = "targetByName";
        String beanName02 = "targetByType";
        String beanName03 = "targetByConstructor";

        Target target = null;

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        System.out.println("byName 방식으로 호출 :");
        target = (Target) context.getBean(beanName01);

        System.out.println("\nbyType 방식으로 호출 :");
        target = (Target) context.getBean(beanName02);

        System.out.println("\nConstructor 방식으로 호출 :");
        target = (Target) context.getBean(beanName03);

        context.close();
    }
}
