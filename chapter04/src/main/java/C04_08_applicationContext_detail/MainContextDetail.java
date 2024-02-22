package C04_08_applicationContext_detail;

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
        
        // 이벤트 발행
        
        // 리소스 관리 및 접근
        
        // 추가적인 라이프사이클 인터페이스
        
        // 개선된 스프링 인프라스트럭처 컴포넌트 자동 구성
    }
}
