package C04_03_receiving_notification.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

public class BeanSingerConfig {

    @Configuration
    static class SingerConfig {

        @Lazy
        @Bean(initMethod = "init")
        BeanSinger singer01() {
            BeanSinger singer01 = new BeanSinger();
            singer01.setName("Hans Mayor");
            singer01.setAge(32);
            return singer01;
        }

        @Lazy
        @Bean(initMethod = "init")
        BeanSinger singer02() {
            BeanSinger singer02 = new BeanSinger();
            singer02.setAge(32);
            return singer02;
        }

        @Lazy
        @Bean(initMethod = "init")
        BeanSinger singer03() {
            BeanSinger singer03 = new BeanSinger();
            singer03.setName("Jin Mayor");
            return singer03;
        }
    }
}
