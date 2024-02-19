package C04_03_receiving_notification.JSR_250;

import C04_03_receiving_notification.callbackMethod.Singer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class JSR_Singer implements Singer {

    private static final String DEFAULT_NAME = "JSR SINGER";
    private String name;
    private int age = Integer.MIN_VALUE;

    @Override
    public void sing() {

    }

    @PostConstruct
    public void init() {
        System.out.println("Initialize Bean : JSR_Singer");

        if (name == null) {
            System.out.println("설정된 이름이 없으므로 기본 이름을 할당합니다.");
            name = DEFAULT_NAME;
        }

        System.out.println("CHECK VALUE : " + (age == Integer.MIN_VALUE));
        if (age == Integer.MIN_VALUE) {
            String message = JSR_Singer.class + "반드시 나이 설정을 해야만 합니다.";
            throw new IllegalArgumentException(message);
        }
    }

    public static JSR_Singer getBean(String beanName, ApplicationContext context) {

        try {
            var bean = (JSR_Singer) context.getBean(beanName);
            System.out.println("Get Bean : " + bean);
            return bean;
        } catch (BeanCreationException beanCreationException) {
            String message = "빈 생성 중 오류가 발생하였습니다." + beanCreationException.getMessage();
            System.out.println(message);
            return null;
        }
    }

    @Override
    public String toString() {
        return "JSR_Singer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
