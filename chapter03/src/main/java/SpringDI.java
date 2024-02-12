import injection.Oracle;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class SpringDI {

    public static void main(String... args) {
        
        // 빈
        // 컨테이너가 관리하는 모든 컴포넌트를 뜻함.
        
        // 빈 팩토리 (BeanFactory Interface)
        // 컴포넌트 관리.
        // 라이프사이클 관리.
        // 의존성 관리.
        // BeanFactory 인터페이스의 구현체를 이용해 스프링 DI 컨테이너와 직접 연동 가능.
        // BeanFactory 인터페이스를 사용하려면 구현체의 인스턴스를 생성하고 빈과 의존성 정보를 구성해야 함.
        // BeanFactory 구성 파일을 사용해 외부에서 구성하는 방법이 일반적.
        // 스프링 내부에서 빈 구성은 BeanDefinition 인터페이스를 구현한 클래스의 인스턴스로 표현.
        String beanConfig = "spring/xmlBeanFactoryConfig.xml";
        String oracleBeanName = "oracle";

        // 팩토리 - 리더 - 구성파일
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanReader = new XmlBeanDefinitionReader(beanFactory);
        beanReader.loadBeanDefinitions(new ClassPathResource(beanConfig));

        // 팩토리에서 빈 가져오기
        Oracle oracle = (Oracle) beanFactory.getBean(oracleBeanName);
        System.out.println(oracle.defineMeaningOfLife());
        
        // 수정자 주입
        
        // 생성자 주입
        
        // 메서드 주입
    }
}
