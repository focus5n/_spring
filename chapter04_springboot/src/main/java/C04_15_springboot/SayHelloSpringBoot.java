package C04_15_springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SayHelloSpringBoot {

    private static Logger logger = LoggerFactory.getLogger(SayHelloSpringBoot.class);

    public void sayHello() {
        logger.info(":::::: Hello, SpringBoot! ::::::");
    }
}
