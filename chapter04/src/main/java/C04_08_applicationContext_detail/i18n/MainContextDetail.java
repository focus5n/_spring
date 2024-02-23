package C04_08_applicationContext_detail.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

public class MainContextDetail {

    public static void main(String[] args) {

        // 선언적 방식으로 리소스 100% 관리 가능
        
        // 국제화
        // MessageSource 인터페이스 사용하여 [Message] 라고 명명한 다양한 언어로 저장된 String 리소스에 접근 가능
        var config = "C04_08/i18n-config.xml";
        var english = Locale.ENGLISH;
        var korean = Locale.KOREAN;

        var context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        System.out.println("Get from message source : " + context.getMessage("message", null, english));
        System.out.println("Get from message source : " + context.getMessage("message", null, korean));

        System.out.println("Get from message source : " + context.getMessage("nameMessage", new Object[] {"Hans", "Mayor"}, english));
        System.out.println("Get from message source : " + context.getMessage("nameMessage", new Object[]{"한징", "종"}, korean));

        context.close();

        // ApplicationObjectSupport

        // 이벤트 발행
        // ApplicationContext 인터페이스에는 BeanFactory 인터페이스가 지원하지 않는, 이벤트 발행 및 수신 기능이 있다.
        // 모든 빈은 ApplicationListener<T> 인터페이스를 구현해 이벤트를 받을 수 있다.
        // ApplicationContext 구성 시, 자동으로 ApplicationListener<T> 구현체를 빈으로 등록하기 때문이다.
        // ApplicationEventPublisher.publishEvent() 메서드로 발행.
        // 스프링 MVC 웹앱에서는 스프링 프레임워크가 protected 형태로 ApplicationContext 타입에 접근할 수 있음.
        // 독립형 앱에서는 ApplicationContextAware 타입을 구현하면 접근이 가능.
        
        // 리소스 관리 및 접근
        
        // 추가적인 라이프사이클 인터페이스
        
        // 개선된 스프링 인프라스트럭처 컴포넌트 자동 구성
    }
}
