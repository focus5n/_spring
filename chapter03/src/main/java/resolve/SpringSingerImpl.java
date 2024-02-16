package resolve;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component("HansMayor")
@DependsOn("gopher")
public class SpringSingerImpl implements SpringSinger, ApplicationContextAware {

    private ApplicationContext context;
    private SpringGuitar springGuitar;
    String beanName = "gopher";

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    @Override
    public void sing() {
        springGuitar = context.getBean(beanName, SpringGuitar.class);
        springGuitar.sing();
    }
}
