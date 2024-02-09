package configuration;

import message.MessageProvider;
import message.MessageRenderer;
import message.SpringMessageProvider;
import message.SpringMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    // <bean id="provider" class="..." /> XML 파일의 해당 구문과 동일한 역할
    @Bean
    public MessageProvider provider() {
        return new SpringMessageProvider();
    }

    // <bean id="renderer" class="..." p:messageProvider-ref="..." /> XML 파일의 해당 구문과 동일한 역할
    @Bean
    public MessageRenderer renderer() {
        MessageRenderer renderer = new SpringMessageRenderer();
        renderer.setMessageProvider(provider());

        return renderer;
    }
}
