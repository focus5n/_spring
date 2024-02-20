package C04_06_factoryBean;

import C04_06_factoryBean.S01_encryption.MessageDigestConfigDemo;
import C04_06_factoryBean.S01_encryption.MessageDigester;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainFactoryBean {

    public static void main(String[] args) {
        
        // 스프링 구문으로는 생성 및 관리할 수 없는 객체를 관리하기 위한 어댑터 FactoryBean 인터페이스
        // new 연산자로 생성할 수 없는 객체를 생성할 때 사용
        // 트랜잭션 프록시, JNDI 컨텍스트에서 자동으로 리소스 획득
        
        // 암호화
        // 암호화 처리가 필요할 때 message digest 생성하거나 비밀번호를 데이터베이스에 저장할 때 Hash 함수로 단방향 암호화를 시도.
        // 자바에서는 임의의 데이터로 해시 값을 얻으려고 할 때 MessageDigest 클래스가 제공하는 기능을 사용.
        /*
        String config = "C04_06/message-digest.xml";
        String beanName = "digester";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        var digester = context.getBean(beanName, MessageDigester.class);
        digester.digest("Hello, Digest!");

        context.close();
         */

        /*
        var config = MessageDigestConfigDemo.MessageDigestConfig.class;
        String beanName = "digester";

        GenericApplicationContext context = new AnnotationConfigApplicationContext(config);
        MessageDigester digester = context.getBean(beanName, MessageDigester.class);

        digester.digest("Hello, Digester by javaConfig!");

        context.close();
         */

        // 서드파티에서 제공하는 자바빈 인스턴스를 사용해야 한다면?
        // 무슨 클래스를 어떻게 초기화해야 하는지 알 수가 없지만...
        // 해당 클래스가 스프링 앱이 필요로 하는 인스턴스를 제공하는 것은 분명하다.
        // 이럴 때는 <bean> 태그에 factory-bean, factory-method 사용
        String config = "C04_06/message-digest.xml";
        String beanName = "digester";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        var digester = context.getBean(beanName, MessageDigester.class);
        digester.digest("Hello, Digester by factory-bean!");

        context.close();
    }
}
