package C04_10_java_class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfig04.class)
public class AppConfig_04_01 {

    @Autowired
    MessageProvider messageProvider;

    @Bean(name = "messageRenderer")
    public MessageRenderer messageRenderer() {
        var renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider);

        return renderer;
    }
}
