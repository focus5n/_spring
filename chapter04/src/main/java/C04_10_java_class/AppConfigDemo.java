package C04_10_java_class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

public class AppConfigDemo {

    @Configuration
    static class AppConfig01 {

        @Bean
        public MessageProvider messageProvider() {
            return new ConfigurableMessageProvider();
        }

        @Bean
        public MessageRenderer messageRenderer() {
            var renderer = new StandardOutMessageRenderer();
            renderer.setMessageProvider(messageProvider());
            return renderer;
        }
    }

    @Configuration
    @PropertySource(value = "classpath:C04_10/message.properties")
    static class AppConfig02 {

        private Environment environment;

        public AppConfig02(Environment environment) {
            this.environment = environment;
        }

        @Bean
        @Lazy
        public MessageProvider messageProvider() {
            return new ConfigurableMessageProvider(environment.getProperty("message"));
        }

        @Bean(name = "messageRenderer")
        @Scope(value = "prototype")
        @DependsOn(value = "messageProvider")
        public MessageRenderer messageRenderer() {
            var renderer = new StandardOutMessageRenderer();
            renderer.setMessageProvider(messageProvider());
            return renderer;
        }
    }

    @Configuration
    @ComponentScan(basePackages = "C04_10_java_class")
    static class AppConfig03 {

        @Autowired
        MessageProvider provider;

        @Bean(name = "messageRenderer")
        public MessageRenderer messageRenderer() {
            var renderer = new StandardOutMessageRenderer();
            renderer.setMessageProvider(provider);
            return renderer;
        }
    }
}
