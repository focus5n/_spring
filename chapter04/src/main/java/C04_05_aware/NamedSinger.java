package C04_05_aware;

import org.springframework.beans.factory.BeanNameAware;

public class NamedSinger implements AwareSinger, BeanNameAware {
    private String beanName;

    @Override
    public void sing() {
        System.out.println(beanName + " sing~");
    }

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }
}
