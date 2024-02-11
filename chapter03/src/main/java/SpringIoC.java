import message.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoC {

    public static void main(String[] args) {

        // Step 03-1 : 의존성 풀
        // IoC에는 의존성 주입(DI), 의존성 룩업(DL)로 나눌 수 있음
        // 해당 하위분류에서 구체적인 구현체로 또다시 나뉘어짐

        // 의존성 룩업은 문맥에 따른 의존성 룩업(CDL), 의존성 풀(DP) 하위 분류로 나뉘어짐.
        // 의존성 주입은 생성자 의존성 주입과 수정자 의존성 주입으로 나뉘어짐.

        // 의존성 풀에서는 레지스트리에서 의존성을 가져옴. (JNDI API 활용하여 EJB 컴포넌트 룩업)
        // 의존객체 -> 룩업 -> JNDI 레지스트리 <- 컨테이너
        String springProperty = "spring/springContext.xml";
        String rendererName = "renderer";

        ApplicationContext context = new ClassPathXmlApplicationContext(springProperty);
        MessageRenderer renderer = context.getBean(rendererName, MessageRenderer.class);
        
        renderer.render("Step 03-1 : 의존성 풀(DP) 활용한 의존성 룩업(DL) 방식.");

        // Step 03-2 : 문맥에 따른 의존성 룩업
        // 의존객체 -> 룩업 -> 컨테이너
        // 컨테이너는 performLookup 메서드를 제공하는 인터페이스를 구현해 의존관계를 얻으려는 컨테이너에 신호를 보냄.
        // 일반적으로 컨테이너는 톰캣, 제이보스 같은 앱서버, 기반 프레임워크, 스프링 같은 앱 프레임워크에서 제공.

        // Step 03-3 : 수정자 의존성 주입
        // 자바빈 방식의 수정자 메서드를 사용하여 컨포넌트의 의존성을 주입함.
        // 의존성 없이도 객체를 생성할 수 있음.
        // 해당 수정자를 호출해 의존성을 나중에 제공할 수 있음.

        // ** 의존성 주입 vs 의존성 룩업
        // 현재 사용하는 컨테이너가 EJB 2.1 이하 버전을 사용하면 의존성 룩업 방식을 사용해야 함. (~Java 1.4)
        // 스프링에서는 초기 빈 룩업을 제외하면 컴포넌트와 의존성은 항상 의존성 주입 방식을 이용하여 연결됨.
        // 스프링을 사용할 때는 명시적인 의존성 룩업을 수행하지 않고도 EJB 자원에 접근 할 수 있음.
        // 따라서 스프링을 활용하면 의존성 주입을 사용해 모든 리소스를 관리할 수 있음.
        // 둘 중 하나를 선택할 수 있다면 무조건 의존성 주입이 낫다. (관련된 어떤 코드도 변경하지 않음.)
        // 의존성 주입은 객체가 필드에만 저장되므로 저장소나 컨테이너에서 의존성을 가져오는 코드가 필요하지 않음.
        
        // ** 의존성 주입 중 수정자 주입 vs 생성자 주입
        // 생성자 주입 : 컴포넌트 사용 전 해당 컴포넌트의 의존성을 반드시 갖고 있어야 한다면 매우 유용. + 빈 객체를 불변객체로 활용 가능.
        // 일반적인 상황에서는 수정자 주입이 의존성 주입에 가장 좋은 방법.
        // 수정자 주입 : 의존성을 컨테이너에 노출. 인터페이스에서 모든 의존성을 선언 가능.

        // 인터페이스에 의존성을 설정하는 것은 좋지 않지만,
        // 구성인자에 접근하는 수정자 및 접근자를 인터페이스에 정의하는 것은 좋은 방식이다.
        // 구성인자 : 구현체가 작동하는데 필수적인 상세 구성 정보를 담고 있는 정보.
        // 참조 : NewsletterSender
    }
}
