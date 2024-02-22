package C04_07_property_editor;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.beans.PropertyEditor;
import java.io.File;
import java.io.IOException;

public class MainPropertyEditor {

    public static void main(String[] args) throws IOException {

        // 프로퍼티 에디터
        // 프로퍼티 값을 원래 자료 타입에서 String 타입으로 변환하거나 반대로 String 타입을 원래 타입으로 변환하는 인터페이스.
        // 편집기에서 입력받은 String 타입 프로퍼티 값을 사용하고자 하는 타입으로 변환하는 용도
        
        // 스프링 기반 앱에서는 대부분 프로퍼티 값을 BeanFactory 구성 파일에서 읽어오므로 해당 프로퍼티는 String 타입이다.
        // 하지만 빈이 필요로 하는 타입은 String 타입이 아닐 수도 있다.
        // 이때 PropertyEditor 구현체를 개발자가 만들 수 있도록 하여 String 타입을 변환하는 번거로움을 덜어줌.
        // springframework.beans.propertyEditors 참조
        String prefix = "test";
        String suffix = "txt";
        String config = "C04_07/property-editor.xml";
        String beanName = "property-bean-01";

        File file = File.createTempFile(prefix, suffix);
        file.deleteOnExit();

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(config);
        context.refresh();

        var bean = context.getBean(beanName);

        context.close();
    }
}
