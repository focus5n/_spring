package C04_03_receiving_notification.initializeBean;

import C04_03_receiving_notification.callbackMethod.Singer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

public class InitSinger implements Singer, InitializingBean {

    private static final String DEFAULT_NAME = "INIT SINGER";
    private String name;
    private int age = Integer.MIN_VALUE;

    @Override
    public void sing() {
        System.out.println("InitSinger Sing~");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("Initialize Bean : InitSinger");

        if (name == null) {
            System.out.println("이름이 설정되지 않아서 기본 이름을 사용합니다.");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            String message = InitSinger.class + " 빈 타입에는 반드시 age 프로퍼티를 설정해야 합니다.";
            throw new IllegalArgumentException(message);
        }
    }

    public static InitSinger getBean(String beanName, ApplicationContext context) {

        try {
            InitSinger bean = (InitSinger) context.getBean(beanName);
            System.out.println("Get Bean : " + bean);
            return bean;
        } catch (BeanCreationException beanCreationException) {
            String message = "빈 구성 도중에 오류가 발생하였습니다.\n" + beanCreationException.getMessage();
            System.out.println(message);
            return null;
        }
    }

    @Override
    public String toString() {
        return "InitSinger{" +
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
