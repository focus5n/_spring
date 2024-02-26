package C04_15_springboot.default_springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MainHelloSpringBoot {

    private static final Logger logger = LoggerFactory.getLogger(MainHelloSpringBoot.class);

    public static void main(String... args) throws Exception {

        // 스프링부트 진입점
        // 주어진 클래스와 커맨드 라인 인자(args)를 기반으로 스프링 ApplicationContext 초기화 함.
        // 내장 서버를 실행시킴. 개발 및 테스트 목적이므로, 상용 서버는 별도로 둔다.
        ConfigurableApplicationContext context = SpringApplication.run(MainHelloSpringBoot.class, args);

        // JVM 옵션으로 -enableassertions or -ea 추가해야 작동함
        assert context != null;
        logger.info(":::::: Searching Beans... ::::::");

        Arrays.stream(context.getBeanDefinitionNames()).forEach(beanName -> logger.info(":::: " + beanName + " ::::"));
        SayHelloSpringBoot sayHelloSpringBoot = context.getBean(SayHelloSpringBoot.class);

        sayHelloSpringBoot.sayHello();
        System.in.read();

        context.close();
    }
}
