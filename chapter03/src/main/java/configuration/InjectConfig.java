package configuration;

import org.springframework.stereotype.Component;

@Component("injectConfig")
public class InjectConfig {
    private String name = "Hans Mayor";
    private int age = 32;
    private float height = 175f;
    private boolean programmer = true;
    private Long ageInSeconds = 1_241_401_112L;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }
}
