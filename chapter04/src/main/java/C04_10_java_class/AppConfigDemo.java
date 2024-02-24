package C04_10_java_class;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    static class AppConfig02 {
        // ... something
    }
}
