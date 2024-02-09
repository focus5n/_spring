package factory;

import message.MessageProvider;
import message.MessageRenderer;

import java.util.Properties;

public class SpringMessageFactory {
    
    // 팩토리 클래스를 인스턴스로 생성하여 제공
    private static SpringMessageFactory instance;

    // 설정파일을 팩토리에서 생성하여 제공
    // 설정파일은 변경될 수 있으므로 final 키워드를 붙이지 않음
    private Properties propeties;
    private MessageRenderer renderer;
    private MessageProvider provider;

    private SpringMessageFactory() {
        propeties = new Properties();

        // 이름
        String propertyNameWithSlash = "/spring/springMessage.properties";
        String rendererClassName = "renderer.class";
        String providerClassName = "provider.class";

        try {
            // 클래스 이름을 찾음
            propeties.load(this.getClass().getResourceAsStream(propertyNameWithSlash));
            String rendererClass = propeties.getProperty(rendererClassName);
            String providerClass = propeties.getProperty(providerClassName);

            // 찾은 클래스 이름을 활용하여 해당 클래스 인스턴스를 획득하여 필드에 할당
            renderer = (MessageRenderer) Class.forName(rendererClass).getDeclaredConstructor().newInstance();
            provider = (MessageProvider) Class.forName(providerClass).getDeclaredConstructor().newInstance();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // 팩토리 클래스가 로딩될 때 팩토리 인스턴스를 초기화
    static {
        instance = new SpringMessageFactory();
    }

    // 수정은 불가능하게 Setter 설정은 하지 않음
    public static SpringMessageFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return renderer;
    }

    public MessageProvider getMessageProvider() {
        return provider;
    }
}
