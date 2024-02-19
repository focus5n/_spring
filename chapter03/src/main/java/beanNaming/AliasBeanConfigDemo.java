package beanNaming;

import methodInjection.LyricSinger;
import methodInjection.Singer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;
import java.util.Map;

public class AliasBeanConfigDemo {

//    @Configuration
//    public static class AliasBeanConfig {
//
//        @Bean(name = {"Hans Mayor", "Mayor", "Hans", "June"})
//        public Singer singer() {
//            return new LyricSinger();
//        }
//    }

    public static void main(String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("spring/app-context.xml");
        context.refresh();

        Map<String, Singer> beans = context.getBeansOfType(Singer.class);
        beans.entrySet().stream().forEach(each -> System.out.println(
                "id : " + each.getKey() + "\n별칭 : " + Arrays.toString(context.getAliases(each.getKey())) + "\n"
        ));

        context.close();
    }
}
