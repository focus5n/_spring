package C04_15_springboot.web_springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class MainWebSpringBoot  {

    private static Logger logger = LoggerFactory.getLogger(MainWebSpringBoot.class);

    public static void main(String... args) throws IOException {

        ConfigurableApplicationContext context = SpringApplication.run(MainWebSpringBoot.class, args);

        assert context != null;
        logger.info(":::::: Start Web SpringBoot Application! ::::::\n");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(beanName -> logger.info(":::: " + beanName + " ::::"));
        logger.info(":::::: End Web SpringBoot Application! ::::::");

        System.in.read();
        context.close();
    }
}
