package resolve;

import org.springframework.stereotype.Component;

@Component("gopher")
public class SpringGuitar {
    void sing() {
        System.out.println("Guitar~~!");
    }
}
