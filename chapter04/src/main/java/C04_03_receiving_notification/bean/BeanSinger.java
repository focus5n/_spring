package C04_03_receiving_notification.bean;

import C04_03_receiving_notification.JSR_250.JSR_Singer;
import C04_03_receiving_notification.callbackMethod.Singer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;

public class BeanSinger implements Singer {

    private static final String DEFAULT_NAME = "BEAN SINGER";
    private String name;
    private int age = Integer.MIN_VALUE;

    @Override
    public void sing() {

    }

    private void init() {
        System.out.println("Initialize Bean : BeanSinger");

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

    public static BeanSinger getBean(String beanName, ApplicationContext context) {

        try {
            var bean = (BeanSinger) context.getBean(beanName);
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
        return "BeanSinger{" +
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
}
