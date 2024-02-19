package C04_03_receiving_notification.callbackMethod;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;

public class CallbackSinger implements Singer {

    private static final String DEFAULT_NAME = "J.Fla";
    private String name;
    private int age = Integer.MIN_VALUE;

    private void init() {
        System.out.println("Initialize Bean : CallbackSinger");

        if (name == null) {
            System.out.println("이름이 설정되지 않았으므로 기본 이름을 사용합니다.");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            String message = CallbackSinger.class + " 빈 타입에는 반드시 age 프로퍼티를 설정해야 합니다.";
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public void sing() {
        System.out.println("CallbackSinger Sing~");
    }

    public static CallbackSinger getBean(String beanName, ApplicationContext context) {

        try {
            CallbackSinger bean = (CallbackSinger) context.getBean(beanName);
            System.out.println("Get Bean : " + bean);
            return bean;
        } catch (BeanCreationException beanCreationException) {
            System.out.println("빈 구성 중 오류가 발생하였습니다.\n" + beanCreationException.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "CallbackSinger{" +
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
